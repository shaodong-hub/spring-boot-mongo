//package com.github.mongo.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.nio.charset.StandardCharsets;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 19:48 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@DirtiesContext
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//public class GridFsResourceControllerTest {
//
//    /**
//     * 模拟mvc测试对象
//     */
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void download() {
//    }
//
//    @Test
//    public void upload() throws Exception {
//        String result = mockMvc.perform(multipart("/file/123")
//                .file(new MockMultipartFile(
//                        "file",
//                        "test.txt",
//                        MediaType.MULTIPART_FORM_DATA_VALUE,
//                        "hello upload".getBytes(StandardCharsets.UTF_8))))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//
//    }
//}