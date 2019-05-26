package com.github.mongo.dao;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 11:00 2019-05-22
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class UserFluxDoDao {

    @Resource
    private ReactiveMongoTemplate template;

    public void findByName() {
//        template.
    }

}
