package com.github.mongo.config;

import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * MongoDB 的配置
 *
 *
 * <p>
 * 创建时间为 15:58 2019/8/6
 * 项目名称 phoenix-waf-analysis
 * </p>
 *
 * @author 石少东
 * @version 2.0.0
 * @since 2.0.0
 */
//@Configuration
public class ConfigMongoPlus {

    /**
     * 新增 Mongodb 的连接配置
     *
     * @param mongoPlus mongo新增的配置
     * @return MongoClientOptions
     */
    @Bean
    public MongoClientOptions mongoClientOptions(@NotNull ConfigMongoPlusProperty mongoPlus) {
        return new MongoClientOptions.Builder()
                .readPreference(ReadPreference.secondary())
                .minConnectionsPerHost(mongoPlus.getMinConnectionPerHost())
                .connectionsPerHost(mongoPlus.getMaxConnectionPerHost())
                .threadsAllowedToBlockForConnectionMultiplier(mongoPlus.getThreadsAllowedToBlockForConnectionMultiplier())
                .serverSelectionTimeout(mongoPlus.getServerSelectionTimeout())
                .maxWaitTime(mongoPlus.getMaxWaitTime())
                .maxConnectionIdleTime(mongoPlus.getMaxConnectionIdleTime())
                .maxConnectionLifeTime(mongoPlus.getMaxConnectionLifeTime())
                .connectTimeout(mongoPlus.getConnectTimeout())
                .socketTimeout(mongoPlus.getSocketTimeout())
                .sslEnabled(mongoPlus.getSslEnabled())
                .sslInvalidHostNameAllowed(mongoPlus.getSslInvalidHostNameAllowed())
                .alwaysUseMBeans(mongoPlus.getAlwaysUseBeans())
                .heartbeatFrequency(mongoPlus.getHeartbeatFrequency())
                .minConnectionsPerHost(mongoPlus.getMinConnectionPerHost())
                .heartbeatConnectTimeout(mongoPlus.getHeartbeatConnectTimeout())
                .heartbeatSocketTimeout(mongoPlus.getSocketTimeout())
                .localThreshold(mongoPlus.getLocalThreshold())
                .build();
    }


    /**
     * _class 不保存
     *
     * @param factory     MongoDbFactory
     * @param context     MongoMappingContext
     * @param beanFactory BeanFactory
     * @return MappingMongoConverter
     */
    @Bean
    @SneakyThrows(NoSuchBeanDefinitionException.class)
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, @NotNull BeanFactory beanFactory) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        mappingConverter.setCustomConversions(beanFactory.getBean(MongoCustomConversions.class));
        // Don't save _class to mongo
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingConverter;
    }

}
