package com.github.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 创建时间为 19:14 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
public class ConfigDropCollections {

    @Resource
    public MongoTemplate template;

    @PostConstruct
    public void init() {
        Set<String> set = template.getCollectionNames();
        set.forEach(one -> template.dropCollection(one));
    }

}
