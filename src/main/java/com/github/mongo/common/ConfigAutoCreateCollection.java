package com.github.mongo.common;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Configuration;

/**
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
public class ConfigAutoCreateCollection {

    public String getCreate() {
        return DateTime.now().toString("yyyy-MM-dd HH:mm.SSS");
    }

}