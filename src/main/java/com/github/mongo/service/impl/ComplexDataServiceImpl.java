package com.github.mongo.service.impl;

import com.github.mongo.pojo.bo.ComplexDataBO;
import com.github.mongo.pojo.doo.ComplexDataDO;
import com.github.mongo.repository.IComplexDataJpaRepository;
import com.github.mongo.repository.IComplexDataRepository;
import com.github.mongo.service.IComplexDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:44 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class ComplexDataServiceImpl implements IComplexDataService {

    @Resource
    private IComplexDataJpaRepository jpaRepository;

    @Resource
    private IComplexDataRepository complexDataRepository;

    @Override
    public ComplexDataDO save(ComplexDataDO complexDataDO) {
        return jpaRepository.save(complexDataDO);
    }

    @Override
    public List<ComplexDataBO> getTopByDateBetween(int top, Date start, Date end) {
        return complexDataRepository.getTop5ByDateBetween(start, end);
    }
}
