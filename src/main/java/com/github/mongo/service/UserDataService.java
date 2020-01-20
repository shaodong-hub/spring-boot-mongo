package com.github.mongo.service;

import com.github.mongo.pojo.UserDataDO;
import com.github.mongo.repository.IUserDataRepository;
import com.google.common.collect.Lists;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午4:21 2020/1/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserDataService {

    @Resource
    private IUserDataRepository repository;

    @Resource
    private MongoTemplate mongoTemplate;

    public List<UserDataDO> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public UserDataDO save(UserDataDO userData) {
        return repository.save(userData);
    }

    @Transactional(rollbackFor = Exception.class)
    public UserDataDO saveTx(UserDataDO userData) {
//        return repository.save(userData);
        return mongoTemplate.save(userData);
    }

}
