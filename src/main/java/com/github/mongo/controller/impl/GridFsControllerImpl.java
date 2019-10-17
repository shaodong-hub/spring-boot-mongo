package com.github.mongo.controller.impl;

import com.github.mongo.controller.IGridFsController;
import com.github.mongo.pojo.dto.ResultDTO;
import com.github.mongo.service.IGridFsService;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:27 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class GridFsControllerImpl implements IGridFsController {

    @Resource
    private IGridFsService service;

    @GetMapping("/files")
    @Override
    public ResultDTO<List<String>> fileNames() {
        return ResultDTO.<List<String>>builder().data(service.fileNames()).build();
    }

    @GetMapping("/file/{name}")
    @SneakyThrows(IOException.class)
    @Override
    public void download(@PathVariable String name, @NotNull HttpServletResponse response) {
        service.download(name, response);
    }

    @PostMapping("/file/{id}")
    @SneakyThrows(IOException.class)
    @Override
    public String upload(@PathVariable String id, @NotNull MultipartFile file) {
        return service.upload(id, file);
    }

}
