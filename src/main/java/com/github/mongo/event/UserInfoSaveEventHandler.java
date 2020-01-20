package com.github.mongo.event;

import com.github.mongo.pojo.UserDataDO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 创建时间为 下午4:47 2020/1/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class UserInfoSaveEventHandler {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 接受User发出的类型为 EventUserSave 的 DomainEvents事件
     *
     * @param event EventUserSave
     */
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void event(@NotNull UserDataDO event) {
        log.info("TransactionPhase:BEFORE_COMMIT-{}", event.toString());
        if (event.getName().contains("error")) {
            REST_TEMPLATE.postForObject("http://www.1111.com", event.toString(), String.class);
        }
    }

}
