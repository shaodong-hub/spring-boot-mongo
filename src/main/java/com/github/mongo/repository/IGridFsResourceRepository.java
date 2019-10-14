package com.github.mongo.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 创建时间为 上午11:33 2019/10/8
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IGridFsResourceRepository {

    /**
     * 获取所有的文件名
     *
     * @return List
     */
    List<String> getFileName();

    /**
     * 保存文件
     *
     * @param fileName    文件名称
     * @param inputStream 输入流
     * @return String
     */
    String saveFile(String fileName, InputStream inputStream);

    /**
     * 根据文件名获取输入流
     *
     * @param fileName 文件名称
     * @return InputStream
     * @throws IOException IOException
     */
    InputStream getFileByName(String fileName) throws IOException;

    /**
     * 删除文件
     *
     * @param fileName 文件名
     */
    void deleteByName(String fileName);

}
