package com.github.mongo.controller;

import com.github.mongo.pojo.doo.DotFieldDO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 创建时间为 上午11:14 2019/10/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IDotFieldDoController {

    DotFieldDO save(@RequestBody DotFieldDO dotFieldDO);

}
