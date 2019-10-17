//package com.github.mongo.service.impl;
//
//import com.github.mongo.pojo.bo.ComplexDataBO;
//import com.github.mongo.service.IComplexDataService;
//import org.joda.time.DateTime;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * <p>
// * 创建时间为 下午7:24 2019/10/16
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ComplexDataServiceImplTest {
//
//    @Resource
//    private IComplexDataService service;
//
//    @Test
//    public void getTop5ByDateBetween() {
//        List<ComplexDataBO> list = service.getTop5ByDateBetween(DateTime.now().minusHours(100).toDate(), DateTime.now().toDate());
//        for (ComplexDataBO complexDataBO : list) {
//            System.out.println(complexDataBO.toString());
//        }
//    }
//}