package com.github.mongo.repository;

import com.github.mongo.pojo.ComplexDataDO;
import com.github.mongo.pojo.SetDataDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * <p>
 * 创建时间为 上午11:41 2019/10/8
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IComplexDataJpaRepository extends PagingAndSortingRepository<ComplexDataDO, String> {

    <V> Page<V> findAllBy(Pageable pageable, Class<V> clz);

    List<ComplexDataDO> findAllBySetContains(String data);

    List<ComplexDataDO> findAllByDoSetContains(SetDataDO setData);
}
