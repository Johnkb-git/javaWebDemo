package com.amazon.starter.repository;

import com.amazon.starter.domain.User;

import java.util.List;

/**
 * @author: John Zhang
 * @date: 1/17/20
 * @decription:
 **/

public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUsers();
}
