package com.github.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 当 key 中存在小数点的时候, key 需要转换,该模块为转换器
 * 加入这个模块以后 key 中如果有小数点,查出和写入会自动转换
 *
 * <p>
 * 创建时间为 19:10 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigMongoDotConverter {

    @Resource
    private MappingMongoConverter mongoConverter;

    @PostConstruct
    public void setUpKeyDotConverter() {
        mongoConverter.setMapKeyDotReplacement("-\\*dot\\*-");
    }

}
