package com.github.mongo.controller;

import com.github.mongo.pojo.vo.IUserVO;
import com.github.mongo.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-05-27 22:17
 */

@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserRepository repository;

    @GetMapping("/users")
    public Page<IUserVO> findAll(Pageable pageable) {
        return repository.findAllBy(pageable, IUserVO.class);
    }


}
