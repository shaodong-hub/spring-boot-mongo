package com.github.mongo.pojo.dto;/**
 * @author shao
 * @date 2020/6/2 11:51 上午
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 *@author 石少东
 *@date 2020-06-02 11:51
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UvDTO {

    private Date start;

    private Date end;

}
