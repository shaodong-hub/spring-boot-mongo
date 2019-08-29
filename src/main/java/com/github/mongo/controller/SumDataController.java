package com.github.mongo.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 15:30 2019-08-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class SumDataController {

    @Resource
    private MongoTemplate mongoTemplate;

    @PostMapping("/sum")
    public SumDataDO update(@NotNull @RequestBody SumDataDO sumDataDO) {
        Query query = Query.query(Criteria.where("name").is(sumDataDO.getName()));
        Update update = new Update().inc("count", sumDataDO.getCount());
        mongoTemplate.upsert(query, update, SumDataDO.class);
        return mongoTemplate.findOne(query, SumDataDO.class);
    }

    @Getter
    @Setter
    @ToString
    @Document(collection = "sum_data")
    private static class SumDataDO {
        @Id
        private String id;

        @Indexed(unique = true)
        private String name;

        private Integer count;
    }

}

