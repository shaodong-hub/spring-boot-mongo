package com.github.mongo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
public class ScheduleUserData {

    @Scheduled(fixedDelay = 1000)
    public void task() {

    }

}
