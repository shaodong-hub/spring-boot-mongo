package com.github.mongo.pojo.doo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 小数点转换的 demo
 *
 * <p>
 * 创建时间为 19:16 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
@Document(collection = "dot_field")
public class DotFieldDO {

    private String ip;

}
