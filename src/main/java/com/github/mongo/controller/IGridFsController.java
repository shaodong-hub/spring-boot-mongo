package com.github.mongo.controller;

import com.github.mongo.pojo.dto.ResultDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:25 2019/10/16
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IGridFsController {

    /**
     * 获取所有的文件名
     *
     * @return 文件名
     */
    ResultDTO<List<String>> fileNames();

    /**
     * 下载文件
     *
     * @param name     文件名称
     * @param response HttpServletResponse
     */
    void download(@PathVariable String name, HttpServletResponse response);


    /**
     * 上传文件
     *
     * @param id   文件ID
     * @param file MultipartFile
     * @return String 文件名
     */
    String upload(@PathVariable String id, @NotNull MultipartFile file);

}
