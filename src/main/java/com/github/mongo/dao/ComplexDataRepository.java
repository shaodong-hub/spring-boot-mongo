package com.github.mongo.dao;

import com.github.mongo.pojo.ComplexDataDO;
import com.github.mongo.pojo.ComplexDataDTO;
import com.mongodb.client.result.UpdateResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 14:41 2019-08-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public class ComplexDataRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 更新数据
     *
     * @param dataDO 数据
     * @return ComplexDataDO
     */
    public ComplexDataDO update(@NotNull ComplexDataDTO dataDO) {
        Query query = Query.query(Criteria.where("name").is(dataDO.getName()));
        Update update = new Update().inc("data." + dataDO.getKey(), dataDO.getValue());
        UpdateResult result = mongoTemplate.upsert(query, update, ComplexDataDO.class);
        return mongoTemplate.findOne(query, ComplexDataDO.class);
    }

}
