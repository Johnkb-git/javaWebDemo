package com.amazon.starter.repository;

import com.amazon.starter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: John Zhang
 * @date: 1/17/20
 * @decription:
 **/
@Repository
public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUsers();
}
