package com.github.mongo.controller;

import com.github.mongo.pojo.doo.CappedDataDO;
import com.github.mongo.pojo.dto.ResultDTO;

/**
 * <p>
 * 创建时间为 下午4:25 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICappedDataController {

    /**
     * 集合的大小
     *
     * @return Long
     */
    ResultDTO<Long> size();

    /**
     * @param cappedDataDO 固定集合对象
     * @return CappedDataDO
     */
    ResultDTO<CappedDataDO> save(CappedDataDO cappedDataDO);

}
