package com.github.mongo.init;

import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.service.IComplexDataService;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 创建时间为 下午5:18 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Order(100)
//@Component
public class InitComplexData implements CommandLineRunner {

    @Resource
    private IComplexDataService service;

    private static final Integer NUM = 500000;

    private static final Integer MAP_NUM = 10000;

    private static final Integer THREAD_NUM = 100;

    private static final Random RANDOM = new Random();

    @Override
    public void run(String... args) throws Exception {
        ExecutorService eService = Executors.newFixedThreadPool(THREAD_NUM);
        for (Integer i = 0; i < THREAD_NUM; i++) {
            eService.execute(() -> {
                for (Integer integer = 0; integer < NUM; integer++) {
                    service.save(getComplexDataDO());
                }
            });
        }
    }

    private ComplexDataDO getComplexDataDO() {
        Map<String, Integer> map = Maps.newHashMap();
        int num = RANDOM.nextInt(10000);
        ComplexDataDO complexDataDO = ComplexDataDO.builder()
//                .id(id + "")
                .name("name" + num)
                .pass("pass" + num)
                .count(RANDOM.nextInt(99))
                .date(DateTime.now().minusDays(RANDOM.nextInt(30)).toDate())
                .data(map)
                .build();
        for (int i = 0; i < MAP_NUM; i++) {
            int number = RANDOM.nextInt(20);
            map.put("data:" + number, number);
        }
        return complexDataDO;
    }

}
