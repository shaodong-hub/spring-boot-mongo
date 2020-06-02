package com.github.mongo.controller;/**
 * @author shao
 * @date 2020/6/2 11:48 上午
 * @version 1.0
 */

import com.github.mongo.pojo.dto.UvDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-02 11:48
 */

@RestController
@RequiredArgsConstructor
public class WebViewReportController {

    @GetMapping("/uv")
    public void uv(UvDTO uv) {



    }

}
