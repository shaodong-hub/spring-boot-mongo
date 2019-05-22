package com.github.mongo.controller;

import com.github.mongo.pojo.UserFluxDO;
import com.github.mongo.repository.UserFluxRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 10:18 2019-05-21
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class ReactiveMongoController {

    @Resource
    private UserFluxRepository repository;

    @GetMapping("user")
    public Flux<UserFluxDO> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "user/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserFluxDO> getStreamAll() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public Mono<ResponseEntity<UserFluxDO>> findById(@PathVariable String id) {
        return repository.findById(id)
                .map(one -> new ResponseEntity<UserFluxDO>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("user")
    public Mono<UserFluxDO> save(@RequestBody UserFluxDO userFlux) {
        return repository.save(userFlux);
    }

    @PutMapping("/user/{id}")
    public Mono<ResponseEntity<UserFluxDO>> updateUser(@PathVariable String id, @RequestBody UserFluxDO userFlux) {
        return repository.findById(id)
                // 操作数据
                .flatMap(one -> {
                    one.setName(userFlux.getName());
                    return repository.save(one);
                })
                // 转换数据
                .map(one -> new ResponseEntity<>(one, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * 没有返回值,不能使用 deleteById,不能判断是否存在
     * repository.deleteById(id);
     * <p>
     * 当要操作数据时,并返回一个Mono这个时候使用 flatMap
     * 如果不操作数据,只是转换数据,使用 map
     *
     * @param id id
     * @return 返回结果
     */
    @DeleteMapping("user/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
        return repository.findById(id)
                .flatMap(user -> repository
                        .delete(user)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
