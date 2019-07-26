package com.github.mongo.config;

import com.mongodb.MongoClientOptions;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 创建时间为 21:03 2019-07-25
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(ConfigMongoProperties.class)
public class ConfigMongo {


    /**
     * @param mongoProperties
     * @return
     */
    @Bean
    public MongoClientOptions mongoClientOptions(ConfigMongoProperties mongoProperties) {
        if (mongoProperties == null) {
            return new MongoClientOptions.Builder().build();
        }
        return new MongoClientOptions.Builder()
                .minConnectionsPerHost(mongoProperties.getMinConnectionPerHost())
                .connectionsPerHost(mongoProperties.getMaxConnectionPerHost())
                .threadsAllowedToBlockForConnectionMultiplier(mongoProperties.getThreadsAllowedToBlockForConnectionMultiplier())
                .serverSelectionTimeout(mongoProperties.getServerSelectionTimeout())
                .maxWaitTime(mongoProperties.getMaxWaitTime())
                .maxConnectionIdleTime(mongoProperties.getMaxConnectionIdleTime())
                .maxConnectionLifeTime(mongoProperties.getMaxConnectionLifeTime())
                .connectTimeout(mongoProperties.getConnectTimeout())
                .socketTimeout(mongoProperties.getSocketTimeout())
                .sslEnabled(mongoProperties.getSslEnabled())
                .sslInvalidHostNameAllowed(mongoProperties.getSslInvalidHostNameAllowed())
                .alwaysUseMBeans(mongoProperties.getAlwaysUseBeans())
                .heartbeatFrequency(mongoProperties.getHeartbeatFrequency())
                .minConnectionsPerHost(mongoProperties.getMinConnectionPerHost())
                .heartbeatConnectTimeout(mongoProperties.getHeartbeatConnectTimeout())
                .heartbeatSocketTimeout(mongoProperties.getSocketTimeout())
                .localThreshold(mongoProperties.getLocalThreshold())
                .build();
    }
}
