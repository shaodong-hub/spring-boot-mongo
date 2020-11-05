package com.github.mongo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @author 石少东
 * @date 2020-11-04 12:27
 * @since 1.0
 */

@Data
@ToString
public class OutputTypeVO {

    private String userAgent;

    private Long sum;
}
