package com.github.mongo.controller;

import com.alibaba.fastjson.JSON;
import com.github.mongo.pojo.ComplexDataDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
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
 * 创建时间为 15:33 2019-08-20
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
public class SumDataControllerTest {

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
        mockMvc.perform(MockMvcRequestBuilders.post("/sum")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(getSumDataDO())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }


    @NotNull
    private SumDataDO getSumDataDO() {
        SumDataDO sumDataDO = new SumDataDO();
        sumDataDO.setCount(10);
        sumDataDO.setName("name1");
        return sumDataDO;
    }

    @Getter
    @Setter
    @ToString
    @Document(collection = "sum_data")
    private static class SumDataDO {
        @Id
        private String id;
        @Indexed(unique = true)
        private String name;
        private Integer count;
    }

}