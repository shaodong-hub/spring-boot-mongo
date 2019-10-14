package com.github.mongo.controller;

import com.alibaba.fastjson.JSON;
import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.pojo.dto.ComplexDataDTO;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 14:52 2019-08-20
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
public class ComplexDataControllerTest {

    /**
     * 模拟mvc测试对象
     */
    @Resource
    private MockMvc mockMvc;

    @Resource
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() throws Exception {
        mongoTemplate.dropCollection(ComplexDataDO.class);
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/complex")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(getComplexDataDTO())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @NotNull
    private ComplexDataDTO getComplexDataDTO() {
        ComplexDataDTO dataDTO = new ComplexDataDTO();
        dataDTO.setName("name1");
        dataDTO.setKey("key1");
        dataDTO.setValue(10);
        return dataDTO;
    }


}