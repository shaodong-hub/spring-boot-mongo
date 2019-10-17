package com.github.mongo.controller.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 下午7:53 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ComplexDataControllerImplTest {

    /**
     * 模拟mvc测试对象
     */
    @Resource
    private MockMvc mockMvc;

    @Test
    public void getByDateBetween() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/top?top=10&start=2019-09-10&end=2019-10-16"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }


    @Test
    public void getComplexDataDTO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test?top=10&start=2019-09-10&end=2019-10-16"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}