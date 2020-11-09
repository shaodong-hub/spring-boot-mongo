//package com.github.mongo.repository;
//
//import com.github.mongo.pojo.SimpleDataDO;
//import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.scheduling.annotation.Async;
//
//import java.util.concurrent.Future;
//
///**
// * <p>
// * 创建时间为 19:21 2019-05-20
// * 项目名称 spring-boot-mongo
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//public interface ISimpleDataRepository extends PagingAndSortingRepository<SimpleDataDO, String> {
//
//    /**
//     * 根据 ID 查询 SimpleDataDO
//     *
//     * @param id id
//     * @return Future
//     */
//    @Async
//    Future<SimpleDataDO> findSimpleDataDOById(String id);
//
//}
