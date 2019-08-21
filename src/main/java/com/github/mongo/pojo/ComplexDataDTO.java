package com.github.mongo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * 创建时间为 14:39 2019-08-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Setter
@Getter
@ToString
@Document(collection = "complex_data")
public class ComplexDataDTO {

    @Id
    private String id;

    @Indexed
    private String name;

    private String key;

    private Integer value;
}
