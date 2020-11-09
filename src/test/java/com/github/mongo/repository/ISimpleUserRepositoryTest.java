//package com.github.mongo.repository;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
//
//@DirtiesContext
//@SpringBootTest
//@AutoConfigureDataMongo
//@RunWith(SpringRunner.class)
//public class ISimpleUserRepositoryTest {
//
//    @Resource
//    private ISimpleUserRepository repository;
//
//    @Test
//    public void save() {
//        SimpleUserDO user = SimpleUserDO.builder().id("123").hostname("ee2e2").date(new Date()).build();
//        repository.save(user);
//        repository.save(user);
//        repository.save(user);
//    }
//
//
//}