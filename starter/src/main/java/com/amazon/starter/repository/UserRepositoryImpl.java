package com.amazon.starter.repository;

import com.amazon.starter.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: John Zhang
 * @date: 1/17/20
 * @decription:
 **/

@Service
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private dbRepository dbRepository;
    private static AtomicLong counter = new AtomicLong();
//    private List<User> userList = new ArrayList<>();
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();//线程安全

    @PostConstruct
    public void getDataFromMysql() throws NullPointerException{
        List<User> userList = dbRepository.findAll();
        for (User user:userList){
            userMap.put(user.getId(),user);
        }
        counter = new AtomicLong((long)userList.get(userList.size()-1).getId());
    }

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id==null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        userMap.put(id,user);
        dbRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        dbRepository.deleteById(id);
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = dbRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> listUsers() {
        return dbRepository.findAll();
    }
}
