package com.github.mongo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import static com.github.mongo.pojo.ICollection.SIMPLE_DATA;

/**
 * <p>
 * 创建时间为 19:17 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Getter
@Setter
@Builder
@ToString
@Document(collection = SIMPLE_DATA)
@CompoundIndexes({@CompoundIndex(name = "IDX_HOSTNAME_CREATED_DATE_USERAGENT", def = "{'hostname':1,'createdDate':1,'userAgent':1}")})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SimpleDataDO {

    @Id
    private String id;

    @Field("hostname")
    private String hostname;

    private String userAgent;

    private Long count;

    /**
     * 创建 ttl 的集合, 创建改集合时需要设置 ttl 字段, 特别要注意, 该字段 存入的数据类型为 Date
     * 用来设置集合中 文档到期的秒数。如果没有设置，则默认为-1
     * 60 秒之后过期
     */
    @Indexed(name = "ttl", expireAfterSeconds = 60 * 60 * 24 * 31)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expire;

    @CreatedDate
    @Field("created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate;

}
