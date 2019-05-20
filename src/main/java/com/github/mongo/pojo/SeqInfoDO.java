package com.github.mongo.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * <p>
 * 创建时间为 19:08 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Document(collection = "sequence")
public class SeqInfoDO {

    @Id
    private String id;

    @Field
    private String collName;

    @Field
    private Long seqId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
