package com.github.mongo.controller;

import com.github.mongo.pojo.doo.UserDataDO;
import com.github.mongo.pojo.dto.ResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 下午3:55 2019/10/15
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserDataController {

    /**
     * @param userDataDO
     * @return
     */
    ResultDTO<UserDataDO> findByName(UserDataDO userDataDO);


    ResultDTO<Page<UserDataDO>> findAll(Pageable pageable);

    /**
     * @param userDataDO
     * @return
     */
    ResultDTO<UserDataDO> create(UserDataDO userDataDO);

    /**
     * @param userDataDO
     * @return
     */
    ResultDTO<UserDataDO> update(UserDataDO userDataDO);

    /**
     * @param name
     * @return
     */
    ResultDTO<Void> deleteByName(String name);

}
