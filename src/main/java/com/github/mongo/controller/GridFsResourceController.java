package com.github.mongo.controller;

import com.github.mongo.dao.GridFsResourceRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jetbrains.annotations.NotNull;
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
import java.util.List;

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
    private GridFsResourceRepository resourceDao;

    /**
     * 获取所有的文件名
     *
     * @return 文件名
     */
    @GetMapping("/files")
    public List<String> files() {
        return resourceDao.getFileName();
    }


    /**
     * 下载文件
     *
     * @param id       文件的ID
     * @param response HttpServletResponse
     */
    @GetMapping("/file/{id}")
    public void download(@PathVariable String id, @NotNull HttpServletResponse response) throws IOException {
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
    public String upload(@PathVariable String id, @NotNull MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        return resourceDao.saveFile(id, inputStream);
    }

}
