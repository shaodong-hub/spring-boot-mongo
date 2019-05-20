package com.github.mongo.controller;

import com.github.mongo.dao.GridFsResourceDao;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 * 创建时间为 19:38 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class GridFsResourceController {

    @Resource
    private GridFsResourceDao resourceDao;

    /**
     * 下载文件
     *
     * @param id       文件的ID
     * @param response HttpServletResponse
     */
    @GetMapping("/file/{id}")
    @SneakyThrows(IOException.class)
    public void download(@PathVariable String id, HttpServletResponse response) {
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/x-download");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=test.txt");
        InputStream inputStream = resourceDao.getByName(id);
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }

    /**
     * 上传文件
     *
     * @param id   文件ID
     * @param file MultipartFile
     * @return String 文件名
     */
    @PostMapping("/file/{id}")
    @SneakyThrows(IOException.class)
    public String upload(@PathVariable String id, MultipartFile file) {
        InputStream inputStream = file.getInputStream();
        return resourceDao.saveFile(id, inputStream);
    }

}
