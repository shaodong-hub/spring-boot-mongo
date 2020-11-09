package com.github.mongo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author 石少东
 * @date 2020-11-09 11:16
 * @since 1.0
 */

@Getter
@Setter
@Builder
@ToString
@Document(collection = "simple_user")
@CompoundIndexes({@CompoundIndex(name = "IDX_HOSTNAME_DATE", def = "{'hostname':1,'date':1}")})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SimpleUserDO {

    @Id
    private String id;

    private String hostname;

    private Date date;

}
