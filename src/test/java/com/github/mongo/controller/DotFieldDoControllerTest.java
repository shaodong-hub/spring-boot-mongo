//package com.github.mongo.controller;
//
//import com.alibaba.fastjson.JSON;
//import lombok.SneakyThrows;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 20:32 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class DotFieldDoControllerTest {
//
//    /**
//     * 模拟mvc测试对象
//     */
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void save() {
//        DotFieldDO dotFieldDO = new DotFieldDO();
//        dotFieldDO.setIp("1.1.1.1");
//        //增加
//        String result1 = mockMvc.perform(MockMvcRequestBuilders.post("/dot")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(JSON.toJSONString(dotFieldDO)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        System.out.println(result1);
//    }
//
//}