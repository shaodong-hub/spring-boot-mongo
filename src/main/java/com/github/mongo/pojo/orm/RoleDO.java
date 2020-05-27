package com.github.mongo.pojo.orm;

import lombok.*;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author 石少东
 * @date 2020-05-27 22:18
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(collection = "RoleDO")
public class RoleDO extends BaseEntity {

    private static final long serialVersionUID = 8512005668214566989L;

    private String roleName;

    @DBRef
    private Set<UserDO> users;

    @DomainEvents
    public Collection<RoleDO> domainEvents() {
        System.out.println("DomainEvents 开始执行!");
        return Collections.singleton(this);
    }

    @AfterDomainEventPublication
    public void callBackMethod() {
        System.out.println("AfterDomainEventPublication 开始执行!");
    }


}
