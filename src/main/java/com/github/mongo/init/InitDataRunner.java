package com.github.mongo.init;

import com.github.mongo.pojo.SimpleDataDO;
import com.github.mongo.repository.ISimpleDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 石少东
 * @date 2020-11-05 14:22
 * @since 1.0
 */

@Slf4j
//@Component
public class InitDataRunner implements CommandLineRunner {

    private final List<String> hostnames = new ArrayList<>();

    private final List<String> userAgents = new ArrayList<>();

    private static final Random RANDOM = new Random();

    @Resource
    private ISimpleDataRepository repository;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 1000; i++) {
            hostnames.add("www." + RandomStringUtils.randomAlphanumeric(5) + ".com");
        }
        for (int i = 0; i < 12; i++) {
            userAgents.add("UA-" + RandomStringUtils.randomAlphanumeric(5));
        }
        userAgents.add("UA-" + "OTHERS");
    }

    @Override
    public void run(String... args) {
        DateTime dateTime = DateTime.now().dayOfYear().roundFloorCopy();
        for (int i = 0; i < 31; i++) {
            log.info("round - {}", i);
            Date date = dateTime.minusDays(i).toDate();
            for (int i1 = 0; i1 < 1000; i1++) {
                repository.save(getSimpleDataDO(date));
            }
        }
        log.info("end");
    }

    private SimpleDataDO getSimpleDataDO(Date date) {
        return SimpleDataDO.builder()
                .hostname(hostnames.get(RANDOM.nextInt(1000)))
                .userAgent(userAgents.get(RANDOM.nextInt(13))).count((long) RANDOM.nextInt(1000))
                .createdDate(date)
                .expire(date).build();
    }

}
