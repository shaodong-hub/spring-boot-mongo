package com.github.mongo.provider;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Configuration;

/**
 * 根据时间创建集合名称
 * 用于定时创建表
 *
 * <p>
 * 创建时间为 19:15 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration("auto")
public class ConfigCollectionNameProvider {

    public String getName() {
        return DateTime.now().toString("yyyy-MM-dd_HH:mm");
    }

}
