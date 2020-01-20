package com.github.mongo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午5:48 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Order(0)
@Component
public class InitDropCollection implements CommandLineRunner {

    @Resource
    public MongoTemplate template;

    /**
     * 启动时候删除所有的表
     */
    @Override
    public void run(String... args) throws Exception {
        Set<String> set = template.getCollectionNames();
        set.forEach(one -> template.dropCollection(one));
    }

}
