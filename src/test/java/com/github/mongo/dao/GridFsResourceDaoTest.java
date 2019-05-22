//package com.github.mongo.dao;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.core.env.AbstractEnvironment;
//import org.springframework.data.mongodb.gridfs.GridFsOperations;
//import org.springframework.test.annotation.IfProfileValue;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * <p>
// * 创建时间为 21:54 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@DataMongoTest
//@RunWith(SpringRunner.class)
//@IfProfileValue(name = AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, value = "test")
//public class GridFsResourceDaoTest {
//
////    @Resource
////    private GridFsResourceDao resourceDao;
//
//    @Resource
//    private GridFsOperations operations;
//
//    @Test
//    public void getByName() throws IOException {
//        InputStream inputStream = operations.getResource("123").getInputStream();
////        Assert.assertNull(inputStream);
//    }
//}