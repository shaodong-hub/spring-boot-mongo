package com.github.mongo.pojo.bo;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * 创建时间为 下午7:22 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Data
@ToString
public class ComplexDataBO {

    private String name;

    private String pass;

    private Integer sum;

}
