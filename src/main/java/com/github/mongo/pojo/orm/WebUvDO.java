package com.github.mongo.pojo.orm;/**
 * @author shao
 * @date 2020/6/2 11:46 上午
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Index;
import java.util.Date;
import java.util.Set;

/**
 *@author 石少东
 *@date 2020-06-02 11:46
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(collection = "WebViewReportDO")
public class WebUvDO extends BaseEntity{

    private static final long serialVersionUID = -7371445144185722556L;

    @Indexed
    private String hostname;

    @Indexed
    private Date date;

    private Set<String> ips;

}
