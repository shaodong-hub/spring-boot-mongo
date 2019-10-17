package com.github.mongo.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 创建时间为 上午11:52 2019/10/17
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IGridFsService {

    /**
     * 获取所有的文件名
     *
     * @return List
     */
    List<String> fileNames();

    /**
     * 下载文件
     *
     * @param name     String
     * @param response HttpServletResponse
     */
    void download(@PathVariable String name, @NotNull HttpServletResponse response);

    /**
     * 上传文件
     *
     * @param id   String
     * @param file MultipartFile
     * @return String
     */
    String upload(@PathVariable String id, @NotNull MultipartFile file);

}
