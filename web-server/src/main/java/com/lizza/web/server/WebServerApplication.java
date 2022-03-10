package com.lizza.web.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 模拟 HTTP 请求参数 key 为 uuid 导致 oom
 * -Xms50m
 * -Xmx50m
 * -Xmn20m
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/lizza/Desktop/heap.hprof
 */
@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }

}
