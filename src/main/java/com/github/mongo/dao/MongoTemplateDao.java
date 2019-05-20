package com.github.mongo.dao;

import com.github.mongo.pojo.SimpleDataDO;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 19:36 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class MongoTemplateDao {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * @return List
     */
    public List<SimpleDataDO> updateAll() {
        Update update = new Update();
        UpdateResult result = mongoTemplate.updateMulti(new Query(), update, SimpleDataDO.class);
        return null;
    }

}
