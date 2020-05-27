package com.github.mongo.pojo.vo;

import java.util.Set;

/**
 * @author shao
 */
public interface IUserVO {

    /**
     * @return String
     */
    String getUsername();

    /**
     * @return Integer
     */
    Integer getAge();

    /**
     * @return Set
     */
    Set<IRoleVO> getRoles();

}
