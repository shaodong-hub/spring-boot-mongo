package com.github.mongo.controller;

import com.github.mongo.dao.MongoTemplateDao;
import com.github.mongo.pojo.OutputTypeVO;
import com.github.mongo.pojo.SimpleDataDO;
import com.github.mongo.repository.ISimpleDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 创建时间为 19:20 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SimpleDataController {

    @Resource
    private ISimpleDataRepository repository;

    @Resource
    private MongoTemplateDao templateDao;

    /**
     * SimpleDataDO
     *
     * @param pageable 分页信息
     * @return Page
     */
    @GetMapping("/simple")
    public Page<SimpleDataDO> findAll(@PageableDefault(size = 4, page = 1, sort = "id,asc") Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @GetMapping("/predicate")
//    public Iterable<SimpleDataDO> querydsl(@QuerydslPredicate(root = SimpleDataDO.class) Predicate predicate) {
//        return repository.findAll(predicate);
//    }

    @GetMapping("/predicate/{hostnames}")
    public List<OutputTypeVO> aggregation(@PathVariable("hostnames") Set<String> hostnames) {
        return templateDao.aggregation(hostnames);
    }


}
