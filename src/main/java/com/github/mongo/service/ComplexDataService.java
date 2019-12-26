package com.github.mongo.service;

import com.github.mongo.pojo.ComplexDataDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * <p>
 * 创建时间为 下午5:19 2019/12/24
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class ComplexDataService {

    /**
     * 接受 ComplexDataDO 发出的类型为 UserSaveEvent 的DomainEvents事件
     *
     * @param complexDataDO 数据
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void event(ComplexDataDO complexDataDO) {
        System.out.println("TransactionalEventListener  --- " + complexDataDO);
    }


    @EventListener
    public void aaaass(@NotNull AfterSaveEvent<ComplexDataDO> saveEvent) {
        ComplexDataDO source = saveEvent.getSource();
        System.out.println("SpringBootMongo 自带事件发布:" + source);
    }


}
