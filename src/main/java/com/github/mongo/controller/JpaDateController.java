package com.github.mongo.controller;

import com.github.mongo.pojo.doo.JpaDateDO;
import com.github.mongo.repository.IJpaDateDoRepository;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午7:55 2019/8/26
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class JpaDateController {

    @Resource
    private IJpaDateDoRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 10000; i++) {
            repository.save(JpaDateDO.builder().date(new Date()).build());
        }
    }

    @GetMapping("jpadate")
    public Page<JpaDateDO> getAll(@PageableDefault(size = 4, page = 1, sort = "id,asc") Pageable pageable) {
        return repository.findJpaDateDOByDateBetween(DateTime.now().minusMinutes(1).toDate(), new Date(), pageable);
    }


}
