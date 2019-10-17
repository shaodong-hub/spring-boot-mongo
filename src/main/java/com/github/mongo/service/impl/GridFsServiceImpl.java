package com.github.mongo.service.impl;

import com.github.mongo.repository.IGridFsResourceRepository;
import com.github.mongo.service.IGridFsService;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

@Service
public class GridFsServiceImpl implements IGridFsService {

    @Resource
    private IGridFsResourceRepository repository;

    @Override
    public List<String> fileNames() {
        return repository.getFileName();
    }

    @SneakyThrows(IOException.class)
    @Override
    public void download(String name, @NotNull HttpServletResponse response) {
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/x-download");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=test.txt");
        InputStream inputStream = repository.getFileByName(name);
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }

    @SneakyThrows(IOException.class)
    @Override
    public String upload(String id, @NotNull MultipartFile file) {
        InputStream inputStream = file.getInputStream();
        return repository.saveFile(id, inputStream);

    }
}
