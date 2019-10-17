package com.github.mongo.controller.impl;

import com.alibaba.fastjson.JSON;
import com.github.mongo.pojo.doo.CappedDataDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 上午11:21 2019/10/17
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
public class CappedDataControllerImplTest {


    /**
     * 模拟mvc测试对象
     */
    @Resource
    private MockMvc mockMvc;

    @Test
    public void size() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/capped"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(10))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/capped")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(getCappedDataDO())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    private CappedDataDO getCappedDataDO() {
        return CappedDataDO.builder()
                .date(new Date())
                .build();

    }


}