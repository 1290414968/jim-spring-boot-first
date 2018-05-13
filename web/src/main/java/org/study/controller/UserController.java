package org.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.domain.User;
import org.study.repository.UserRepository;

/**
 * 用户 控制器
 *
 **/
@RestController
public class UserController {
    // 保存使用 Spring Web MVC
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/user/save")
    public User user(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
