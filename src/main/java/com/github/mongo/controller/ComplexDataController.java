package com.github.mongo.controller;

import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.pojo.dto.ComplexDataDTO;
import com.github.mongo.repository.IComplexDataRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    private IComplexDataRepository repository;

    @PostMapping("complex")
    public ComplexDataDO update(@RequestBody ComplexDataDTO dataDTO) {
        return repository.update(dataDTO);
    }

}
