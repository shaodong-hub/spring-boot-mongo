package com.github.mongo.pojo.doo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 自定义创建表名的 demo
 *
 * <p>
 * 创建时间为 18:59 2019-05-20
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
@Document(collection = "#{@auto.getName()}")
public class AutoCreateDO {

    @Id
    private String id;

    @Indexed
    private Date date;

    public AutoCreateDO(Date date) {
        this.date = date;
    }

}
