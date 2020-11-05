//package com.github.mongo.config;
//
//import com.github.mongo.pojo.SeqInfoDO;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.FindAndModifyOptions;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
//import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//import org.springframework.util.ReflectionUtils;
//
//import javax.annotation.Resource;
//import javax.persistence.GeneratedValue;
//
///**
// * <p>
// * 创建时间为 19:04 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@Configuration
//public class ConfigSaveEventListener<E> extends AbstractMongoEventListener<E> {
//
//    @Resource
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void onBeforeConvert(@Nullable BeforeConvertEvent<E> source) {
//        Assert.notNull(source, "");
//        E target = source.getSource();
//        ReflectionUtils.doWithFields(source.getSource().getClass(), field -> {
//            ReflectionUtils.makeAccessible(field);
//            // 如果字段添加了GeneratedValue注解
//            if (field.isAnnotationPresent(GeneratedValue.class)) {
//                // 设置自增ID
//                field.set(target, getNextId(target.getClass().getSimpleName()));
//            }
//        });
//    }
//
//    /**
//     * 自定义自动生成 ID
//     *
//     * @param collName 列名
//     * @return 返回 ID
//     */
//    private String getNextId(String collName) {
//        Query query = new Query(Criteria.where("collName").is(collName));
//        Update update = new Update();
//        update.inc("seqId", 1);
//        FindAndModifyOptions options = new FindAndModifyOptions();
//        options.upsert(true);
//        options.returnNew(true);
//        SeqInfoDO seq = mongoTemplate.findAndModify(query, update, options, SeqInfoDO.class);
//        Assert.notNull(seq, "");
//        return StringUtils.substring((seq.getSeqId() + 1000000) + "", 1);
//    }
//
//
//
//}
