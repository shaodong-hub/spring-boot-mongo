package com.github.mongo.repository;

import com.github.mongo.pojo.doo.AuditDataDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>
 * 创建时间为 19:26 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IAuditDataDoRepository extends PagingAndSortingRepository<AuditDataDO, String> {

}
