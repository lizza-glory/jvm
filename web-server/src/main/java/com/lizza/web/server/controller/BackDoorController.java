package com.lizza.web.server.controller;

import cn.hutool.json.JSONUtil;
import com.lizza.web.server.entity.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-24
 */
@Slf4j
@RequestMapping
@RestController
public class BackDoorController {

    @GetMapping("hello")
    public String hello() {
        return "hello web server!";
    }

    @PostMapping("handle")
    public String handle(@RequestBody Param param) {
        log.info(">>> request: {}", param);
        return "success";
    }
}
