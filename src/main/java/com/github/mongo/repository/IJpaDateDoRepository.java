package com.github.mongo.repository;

import com.github.mongo.pojo.doo.JpaDateDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

/**
 * <p>
 * 创建时间为 19:24 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IJpaDateDoRepository extends PagingAndSortingRepository<JpaDateDO, String> {

    Page<JpaDateDO> findJpaDateDOByDateBetween(Date date1, Date date2, Pageable pageable);

}
