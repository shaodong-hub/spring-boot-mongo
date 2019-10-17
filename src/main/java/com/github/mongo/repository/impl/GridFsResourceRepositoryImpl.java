package com.github.mongo.repository.impl;

import com.github.mongo.repository.IGridFsResourceRepository;
import com.google.common.collect.Lists;
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
 * 创建时间为 上午11:34 2019/10/8
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public class GridFsResourceRepositoryImpl implements IGridFsResourceRepository {

    @Resource
    private GridFsOperations operations;

    @Override
    public List<String> getFileName() {
        GridFsResource[] resources = operations.getResources("*");
        return Lists.newArrayList(resources).stream()
                .map(GridFsResource::getFilename)
                .collect(Collectors.toList());
    }

    @Override
    public String saveFile(String fileName, InputStream inputStream) {
        operations.store(inputStream, fileName);
        return fileName;
    }

    @Override
    public InputStream getFileByName(String fileName) throws IOException {
        GridFsResource resource = operations.getResource(fileName);
        return resource.getInputStream();
    }

    @Override
    public void deleteByName(String fileName) {
        operations.delete(new Query(where("filename").is(fileName)));
    }

}
