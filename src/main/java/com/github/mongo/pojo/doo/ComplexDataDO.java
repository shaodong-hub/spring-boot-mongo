package com.github.mongo.pojo.doo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

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
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "complex_data")
public class ComplexDataDO {

    @Id
    private String id;

    @Indexed
    private String name;

    private String pass;

    private Integer count;

    @Indexed
    private Date date;

    private Map<String, Integer> data;

}
