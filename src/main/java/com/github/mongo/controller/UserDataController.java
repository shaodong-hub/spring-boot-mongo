package com.github.mongo.controller;

import com.github.mongo.pojo.UserDataDO;
import com.github.mongo.service.UserDataService;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午4:15 2020/1/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class UserDataController {

    @Resource
    private UserDataService service;

    @GetMapping("/users")
    public List<UserDataDO> getAll() {
        return Lists.newArrayList(service.getAll());
    }

    @PostMapping("/user")
    public UserDataDO save(@RequestBody UserDataDO userData) {
        return service.save(userData);
    }

    @PostMapping("/user_tx")
    public UserDataDO saveTx(@RequestBody UserDataDO userData) {
        return service.saveTx(userData);
    }

}
