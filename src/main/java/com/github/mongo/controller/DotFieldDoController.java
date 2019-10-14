package com.github.mongo.controller;

import com.github.mongo.pojo.doo.DotFieldDO;
import com.github.mongo.repository.IDotFieldDoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 20:30 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class DotFieldDoController {

    @Resource
    private IDotFieldDoRepository repository;

    /**
     * 保存单个 DotFieldDO 对象
     *
     * @param dotFieldDO  DotFieldDO
     * @return DotFieldDO
     */
    @PostMapping("/dot")
    public DotFieldDO save(@RequestBody DotFieldDO dotFieldDO) {
        return repository.save(dotFieldDO);
    }

}
