package com.lizza.web.server.entity;

import lombok.Data;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-24
 */
@Data
public class Param {

    private String name;
    private Integer age;
    private Map<String, String> props;
}
