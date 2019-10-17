package com.github.mongo.repository;

import com.github.mongo.pojo.bo.ComplexDataBO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 创建时间为 上午11:41 2019/10/8
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IComplexDataRepository {

    List<ComplexDataBO> getTop5ByDateBetween(Date start, Date end);

}
