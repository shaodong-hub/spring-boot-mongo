package com.github.mongo.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
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
@Document(collection = "#{@auto.getCreate()}")
public class AutoCreateDO {

    @Id
    private String id;

    @Indexed
    private Date date;

    public AutoCreateDO(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
