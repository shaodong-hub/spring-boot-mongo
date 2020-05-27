package com.github.mongo.schedule;

import com.github.mongo.pojo.orm.RoleDO;
import com.github.mongo.pojo.orm.UserDO;
import com.github.mongo.repository.IRoleRepository;
import com.github.mongo.repository.IUserRepository;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    private final IUserRepository userRepository;

    private final IRoleRepository roleRepository;

//    @PostConstruct
    public void init() {
        RoleDO role = roleRepository.save(RoleDO.builder().roleName("TestRole1").build());
        UserDO user = UserDO.builder()
                .username(RandomStringUtils.randomAlphabetic(4))
                .age(RandomUtils.nextInt(1, 120))
                .date(new Date())
                .roles(Sets.newHashSet(role))
                .build();
        userRepository.save(user);
    }

}
