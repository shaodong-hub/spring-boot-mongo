package com.github.mongo.pojo.orm;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-05-27 22:18
 */

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7208314236815119914L;

    @Id
    private String id;

}
