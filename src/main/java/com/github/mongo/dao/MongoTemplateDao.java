//package com.github.mongo.dao;
//
//import com.github.mongo.pojo.OutputTypeVO;
//import com.github.mongo.pojo.SimpleDataDO;
//import com.mongodb.client.result.UpdateResult;
//import org.joda.time.DateTime;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import static com.github.mongo.pojo.ICollection.SIMPLE_DATA;
//
///**
// * <p>
// * 创建时间为 19:36 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@Repository
//public class MongoTemplateDao {
//
//    @Resource
//    private MongoTemplate mongoTemplate;
//
//    public List<OutputTypeVO> aggregation(Collection<String> hostnames) {
//        Aggregation agg = Aggregation.newAggregation(operation1(hostnames), operation2(), operation3());
//        AggregationResults<OutputTypeVO> results = mongoTemplate.aggregate(agg, SimpleDataDO.class, OutputTypeVO.class);
//        return results.getMappedResults();
//    }
//
//    private AggregationOperation operation1(Collection<String> hostnames) {
//        return Aggregation.match(Criteria.where("created_date").is(new DateTime().dayOfYear().roundFloorCopy().toDate()).and("hostname").in(hostnames));
//    }
//
//    private AggregationOperation operation2() {
//        return Aggregation.project("userAgent", "count");
//    }
//
//    private AggregationOperation operation3() {
//        return Aggregation.group("userAgent").first("userAgent").as("userAgent")
//                .sum("count").as("sum");
//    }
//
//}
