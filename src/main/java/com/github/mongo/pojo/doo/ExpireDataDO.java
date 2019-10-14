package com.github.mongo.pojo.doo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 数据自动过期 demo
 *
 * <p>
 * 创建时间为 18:50 2019-05-20
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
@AllArgsConstructor
@Document(collection = "expiredo")
public class ExpireDataDO {

    /**
     * 创建 ttl 的集合, 创建改集合时需要设置 ttl 字段, 特别要注意, 该字段 存入的数据类型为 Date
     * 用来设置集合中 文档到期的秒数。如果没有设置，则默认为-1
     * 60 秒之后过期
     */
    @Indexed(name = "ttl", expireAfterSeconds = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expire;

}
