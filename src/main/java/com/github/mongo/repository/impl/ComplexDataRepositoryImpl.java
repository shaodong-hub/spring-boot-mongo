package com.github.mongo.repository.impl;

import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.pojo.dto.ComplexDataDTO;
import com.github.mongo.repository.IComplexDataRepository;
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
 * 创建时间为 上午11:42 2019/10/8
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class ComplexDataRepositoryImpl implements IComplexDataRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public ComplexDataDO update(@NotNull ComplexDataDTO dataDO) {
        Query query = Query.query(Criteria.where("name").is(dataDO.getName()));
        Update update = new Update().inc("data." + dataDO.getKey(), dataDO.getValue());
        UpdateResult result = mongoTemplate.upsert(query, update, ComplexDataDO.class);
        return mongoTemplate.findOne(query, ComplexDataDO.class);
    }

}
