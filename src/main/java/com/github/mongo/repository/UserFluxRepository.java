package com.github.mongo.repository;

import com.github.mongo.pojo.UserFluxDO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * <p>
 * 创建时间为 10:17 2019-05-21
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface UserFluxRepository extends ReactiveMongoRepository<UserFluxDO, String> {

}
