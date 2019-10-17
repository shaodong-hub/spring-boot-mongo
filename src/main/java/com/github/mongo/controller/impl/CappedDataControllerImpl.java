package com.github.mongo.controller.impl;

import com.github.mongo.controller.ICappedDataController;
import com.github.mongo.pojo.doo.CappedDataDO;
import com.github.mongo.pojo.dto.ResultDTO;
import com.github.mongo.repository.ICappedDataDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午4:27 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class CappedDataControllerImpl implements ICappedDataController {

    @Resource
    private ICappedDataDoRepository repository;

    @GetMapping("/capped")
    @Override
    public ResultDTO<Long> size() {
        return ResultDTO.<Long>builder().data(repository.count()).build();
    }

    @PostMapping("/capped")
    @Override
    public ResultDTO<CappedDataDO> save(@RequestBody CappedDataDO cappedDataDO) {
        return ResultDTO.<CappedDataDO>builder().data(repository.save(cappedDataDO)).build();
    }

}
