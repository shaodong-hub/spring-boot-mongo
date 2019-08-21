package com.github.mongo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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
@ToString
@Document(collection = "simple_data")
@CompoundIndexes({
        @CompoundIndex(name = "index", def = "{'message':1,'field':1}")
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SimpleDataDO {

    @Id
    private String id;

    @Field("desc")
    private String message;

    private String field;

    /**
     * 创建 ttl 的集合, 创建改集合时需要设置 ttl 字段, 特别要注意, 该字段 存入的数据类型为 Date
     * 用来设置集合中 文档到期的秒数。如果没有设置，则默认为-1
     * 60 秒之后过期
     */
    @Indexed(name = "ttl", expireAfterSeconds = 60)
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

    /**
     * 被 {@link Transient} 标记的字段将不会保存到数据库中
     */
    @Transient
    private Long temp;

    /**
     * 版本号
     */
    @Version
    private Long version;

}
