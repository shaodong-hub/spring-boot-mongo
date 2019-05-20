package com.github.mongo.config;

import com.github.mongo.pojo.CappedDataDO;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 19:00 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigCappedCollection {

    @Resource
    private MongoTemplate template;

    @PostConstruct
    public void initCappedCollection() {
        if (!template.collectionExists(CappedDataDO.class)) {
            template.createCollection(CappedDataDO.class, CollectionOptions.empty().capped().maxDocuments(10).size(10000L));
        }
    }

}
