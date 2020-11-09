package com.github.mongo.repository;

import com.github.mongo.pojo.SimpleUserDO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * <p>
 * 创建时间为 19:21 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISimpleUserReactiveRepository extends ReactiveMongoRepository<SimpleUserDO, String> {

}
