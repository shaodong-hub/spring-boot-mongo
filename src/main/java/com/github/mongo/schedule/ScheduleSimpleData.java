package com.github.mongo.schedule;


import com.github.mongo.pojo.SimpleUserDO;
import com.github.mongo.repository.ISimpleUserReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 19:23 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Slf4j
@Component
public class ScheduleSimpleData {

    @Resource
    private ISimpleUserReactiveRepository repository;

    @Scheduled(fixedDelay = 1000)
    public void task() {
        SimpleUserDO data = SimpleUserDO.builder().expire(new Date()).build();
        Mono<SimpleUserDO> mono = repository.save(data);
        log.info(mono.toString());
    }

}
