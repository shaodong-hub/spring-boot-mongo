package com.github.mongo.repository.impl;

import com.github.mongo.pojo.bo.ComplexDataBO;
import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.repository.IComplexDataRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public List<ComplexDataBO> getTop5ByDateBetween(Date start, Date end) {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gte(start).lt(end)),
                Aggregation.project("name", "count"),
                Aggregation.group("name")
                        .first("name").as("name")
                        .sum("count").as("sum"),
                Aggregation.sort(Sort.Direction.DESC, "sum"),
                Aggregation.limit(5)
        );
        AggregationResults<ComplexDataBO> result = mongoTemplate.aggregate(agg, ComplexDataDO.class, ComplexDataBO.class);
        return result.getMappedResults();
    }


    public List<ComplexDataBO> getTop5ByDateBetween2(Date start, Date end) {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.project("access_count"),
                Aggregation.group("access_count")
                        .sum("access_count").as("sum"),
                Aggregation.sort(Sort.Direction.DESC, "sum"),
                Aggregation.limit(5)
        );
        AggregationResults<ComplexDataBO> result = mongoTemplate.aggregate(agg, ComplexDataDO.class, ComplexDataBO.class);
        return result.getMappedResults();
    }
}
