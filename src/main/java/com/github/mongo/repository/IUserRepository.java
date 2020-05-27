package com.github.mongo.repository;


import com.github.mongo.pojo.orm.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author shao
 * @version 1.0
 * @date 2020/5/27 10:40 下午
 */
public interface IUserRepository extends PagingAndSortingRepository<UserDO, String> {

    <V> Page<V> findAllBy(Pageable pageable, Class<V> clz);


}
