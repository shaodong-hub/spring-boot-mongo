package com.github.mongo.dao;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * <p>
 * 创建时间为 19:01 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class GridFsResourceRepository {

    @Resource
    private GridFsOperations operations;

    public List<String> getFileName() {
        GridFsResource[] resources = operations.getResources("*");
        return Lists.newArrayList(resources).stream()
                .map(GridFsResource::getFilename)
                .collect(Collectors.toList());
    }

    /**
     * 保存文件
     *
     * @param fileName    文件名称
     * @param inputStream 输入流
     * @return String
     */
    public String saveFile(String fileName, InputStream inputStream) {
        operations.store(inputStream, fileName);
        return fileName;
    }

    /**
     * 根据文件名获取输入流
     *
     * @param fileName 文件名称
     * @return InputStream
     */
    @SneakyThrows(IOException.class)
    public InputStream getByName(String fileName) {
        GridFsResource resource = operations.getResource(fileName);
        return resource.getInputStream();
    }

    /**
     * 删除文件
     *
     * @param fileName 文件名
     */
    public void delete(String fileName) {
        operations.delete(new Query(where("filename").is(fileName)));
    }


}
