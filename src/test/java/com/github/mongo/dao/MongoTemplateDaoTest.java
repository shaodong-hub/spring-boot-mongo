//package com.github.mongo.dao;
//
//import com.github.mongo.pojo.OutputTypeVO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
////@DataMongoTest
////@RunWith(SpringRunner.class)
////@SpringBootTest
//@DirtiesContext
//@SpringBootTest
//@AutoConfigureDataMongo
//@RunWith(SpringRunner.class)
//public class MongoTemplateDaoTest {
//
//    @Resource
//    private MongoTemplateDao templateDao;
//
//    @Test
//    public void aggregation() {
//        List<String> list = new ArrayList<>();
//        list.add("www.BI9Nr.com");
//        list.add("www.v40YS.com");
//        list.add("www.m441G.com");
//        List<OutputTypeVO> result = templateDao.aggregation(list);
//        result.forEach(Object::toString);
//    }
//
//}