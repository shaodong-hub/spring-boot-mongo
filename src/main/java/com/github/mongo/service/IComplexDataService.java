package com.github.mongo.service;

import com.github.mongo.pojo.bo.ComplexDataBO;
import com.github.mongo.pojo.doo.ComplexDataDO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:44 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IComplexDataService {

    ComplexDataDO save(ComplexDataDO complexDataDO);

    List<ComplexDataBO> getTopByDateBetween(int top, Date start, Date end);

}
