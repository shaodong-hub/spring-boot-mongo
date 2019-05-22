package com.github.mongo.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * 创建时间为 10:16 2019-05-21
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Document(collection = "UserFluxDO")
public class UserFluxDO {

    @Id
    private String id;

    private String name;

    @Range(min = 10, max = 20)
    private Integer age;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
