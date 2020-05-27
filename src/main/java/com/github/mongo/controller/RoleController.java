package com.github.mongo.controller;

import com.github.mongo.pojo.vo.IRoleVO;
import com.github.mongo.pojo.vo.IUserVO;
import com.github.mongo.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-05-27 22:18
 */

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final IRoleRepository repository;

    @GetMapping("/roles")
    public Page<IRoleVO> findAll(Pageable pageable) {
        return repository.findAllBy(pageable, IRoleVO.class);
    }


}
