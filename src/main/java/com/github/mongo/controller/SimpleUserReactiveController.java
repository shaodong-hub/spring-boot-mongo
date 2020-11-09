package com.github.mongo.controller;

import com.github.mongo.pojo.SimpleUserDO;
import com.github.mongo.repository.ISimpleUserReactiveRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 19:20 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SimpleUserReactiveController {

    @Resource
    private ISimpleUserReactiveRepository repository;

    @GetMapping("data")
    public Flux<SimpleUserDO> findAll(){
        return repository.findAll();
    }


}
