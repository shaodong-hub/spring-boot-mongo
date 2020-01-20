package com.github.mongo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 19:17 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Slf4j
@Getter
@Setter
@ToString
@Document(collection = "simple_data")
public class UserDataDO {

    @Id
    private String id;

    @Indexed
    private String name;

    @DomainEvents
    public Collection<UserDataDO> domainEvents() {
        log.info("---------- UserDataDO ----------domainEvents");
        return Collections.singletonList(this);
    }

}
