package com.github.mongo.schedule;

import com.github.mongo.pojo.ComplexDataDO;
import com.github.mongo.repository.IComplexDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 创建时间为 19:03 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@RequiredArgsConstructor
public class ScheduleUserData {

    private final IComplexDataJpaRepository repository;

    @Scheduled(fixedDelay = 1)
    public void task() {
        ComplexDataDO data = ComplexDataDO.builder()
                .name(RandomStringUtils.randomAlphabetic(4))
                .age(RandomUtils.nextInt(1,120))
                .date(new Date())
                .build();
        repository.save(data);
    }

}
