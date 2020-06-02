package com.github.mongo.repository;/**
 * @author shao
 * @date 2020/6/2 11:48 上午
 * @version 1.0
 */

import com.github.mongo.pojo.orm.WebUvDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 石少东
 * @date 2020-06-02 11:48
 */

public interface IWebViewReportRepository extends PagingAndSortingRepository<WebUvDO, String> {
}
