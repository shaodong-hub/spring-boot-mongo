package com.github.mongo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 上午11:11 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb.plus")
public class ConfigMongoPlusProperty {

    private Integer minConnectionPerHost = 0;

    private Integer maxConnectionPerHost = 100;

    private Integer threadsAllowedToBlockForConnectionMultiplier = 5;

    private Integer serverSelectionTimeout = 30000;

    private Integer maxWaitTime = 12000;

    private Integer maxConnectionIdleTime = 0;

    private Integer maxConnectionLifeTime = 0;

    private Integer connectTimeout = 10000;

    private Integer socketTimeout = 0;

    private Boolean sslEnabled = false;

    private Boolean sslInvalidHostNameAllowed = false;

    private Boolean alwaysUseBeans = false;

    private Integer heartbeatFrequency = 10000;

    private Integer minHeartbeatFrequency = 500;

    private Integer heartbeatConnectTimeout = 20000;

    private Integer heartbeatSocketTimeout = 20000;

    private Integer localThreshold = 15;


}
