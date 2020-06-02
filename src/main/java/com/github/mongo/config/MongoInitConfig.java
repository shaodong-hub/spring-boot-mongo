package com.github.mongo.config;

import com.github.mongo.pojo.orm.UserDO;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-05-27 17:45
 */

//@Component
public class MongoInitConfig {

    @Resource
    private MongoTemplate template;

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        IndexOperations userIndexOps = template.indexOps(UserDO.class);
        userIndexOps.ensureIndex(new Index().on("username", Sort.Direction.ASC));
    }
}
