package com.github.mongo.controller;

import com.github.mongo.pojo.ComplexDataDO;
import com.github.mongo.repository.IComplexDataJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 14:42 2019-08-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class ComplexDataController {

    @Resource
    private IComplexDataJpaRepository repository;

    @GetMapping("/data")
    public ComplexDataDO getComplexDataDO() {
        Optional<ComplexDataDO> optional = repository.findOne(

        );
        return optional.orElseGet(ComplexDataDO::new);
    }


}
