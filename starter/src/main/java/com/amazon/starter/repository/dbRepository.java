package com.amazon.starter.repository;

import com.amazon.starter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: John Zhang
 * @date: 1/23/20
 * @decription:
 **/
@Repository
public interface dbRepository extends JpaRepository<User,Long> {
}
