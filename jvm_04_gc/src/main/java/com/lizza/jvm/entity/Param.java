package com.lizza.jvm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Param {

    private String name;
    private Integer age;
    private Map<String, String> props;
}
