package com.github.mongo.controller;

import com.github.mongo.pojo.bo.ComplexDataBO;
import com.github.mongo.pojo.dto.ComplexDataDTO;
import com.github.mongo.pojo.dto.ResultDTO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:43 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IComplexDataController {

    ResultDTO<List<ComplexDataBO>> getByDateBetween(ComplexDataDTO complexDataDTO);

}
