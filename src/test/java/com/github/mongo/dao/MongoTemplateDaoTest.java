package com.github.mongo.dao;

import com.github.mongo.pojo.OutputTypeVO;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@DataMongoTest
@RunWith(SpringRunner.class)
public class MongoTemplateDaoTest {

    @Resource
    private MongoTemplateDao templateDao;

    @Test
    public void aggregation() {
        List<String> list = new ArrayList<>();
        list.add("www.BI9Nr.com");
        list.add("www.v40YS.com");
        list.add("www.m441G.com");

        List<OutputTypeVO> result = templateDao.aggregation(list);

        result.forEach(Object::toString);

    }

}