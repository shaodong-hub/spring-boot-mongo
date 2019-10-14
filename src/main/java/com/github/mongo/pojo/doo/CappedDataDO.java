package com.github.mongo.pojo.doo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 固定大小的集合
 *
 * <p>
 * 创建时间为 18:53 2019-05-20
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
@Document(collection = "capped_data")
public class CappedDataDO {

    @Id
    private String id;

    private Date date;

    public CappedDataDO(Date date) {
        this.date = date;
    }

}
