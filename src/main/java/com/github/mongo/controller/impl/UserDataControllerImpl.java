package com.github.mongo.controller.impl;

import com.github.mongo.controller.IUserDataController;
import com.github.mongo.pojo.doo.UserDataDO;
import com.github.mongo.pojo.dto.ResultDTO;
import com.github.mongo.repository.IUserDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 19:20 2019-05-20
 * 项目名称 spring-boot-mongo
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserDataControllerImpl implements IUserDataController {

    @Resource
    private IUserDataRepository repository;

    @GetMapping("/user/name/{name}")
    @Override
    public ResultDTO<UserDataDO> findByName(@PathVariable("name") UserDataDO userDataDO) {
        return ResultDTO.<UserDataDO>builder().data(userDataDO).build();
    }

    /**
     * SimpleDataDO
     *
     * @param pageable 分页信息
     * @return Page
     */
    @GetMapping("/users")
    @Override
    public ResultDTO<Page<UserDataDO>> findAll(@PageableDefault(size = 4, page = 1, sort = "id", direction = Sort.Direction.ASC)
                                                       Pageable pageable) {
        Page<UserDataDO> page = repository.findAll(pageable);
        return ResultDTO.<Page<UserDataDO>>builder().data(page).build();
    }

    @PostMapping("/user")
    @Override
    public ResultDTO<UserDataDO> create(@RequestBody UserDataDO userDataDO) {
        return ResultDTO.<UserDataDO>builder().data(repository.save(userDataDO)).build();
    }

    @PutMapping("/user")
    @Override
    public ResultDTO<UserDataDO> update(UserDataDO userDataDO) {
        return ResultDTO.<UserDataDO>builder().data(repository.save(userDataDO)).build();
    }

    @DeleteMapping("/user/{name}")
    @Override
    public ResultDTO<Void> deleteByName(@PathVariable String name) {
        repository.deleteByNameEquals(name);
        return ResultDTO.<Void>builder().build();
    }

}
