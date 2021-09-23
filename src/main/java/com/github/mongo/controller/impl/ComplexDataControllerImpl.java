package com.github.mongo.controller.impl;

import com.github.mongo.controller.IComplexDataController;
import com.github.mongo.pojo.bo.ComplexDataBO;
import com.github.mongo.pojo.dto.ComplexDataDTO;
import com.github.mongo.pojo.dto.ResultDTO;
import com.github.mongo.service.IComplexDataService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
public class ComplexDataControllerImpl implements IComplexDataController {

    @Resource
    private IComplexDataService service;

    @GetMapping("/top")
    @Override
    public ResultDTO<List<ComplexDataBO>> getByDateBetween(@NotNull ComplexDataDTO complexDataDTO) {
        return ResultDTO.<List<ComplexDataBO>>builder().data(
                service.getTopByDateBetween(
                        complexDataDTO.getTop(),
                        complexDataDTO.getStart(),
                        complexDataDTO.getEnd()
                )
        ).build();
    }


}
