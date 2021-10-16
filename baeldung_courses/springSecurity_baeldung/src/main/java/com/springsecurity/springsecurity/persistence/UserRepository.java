package com.springsecurity.springsecurity.persistence;

import com.springsecurity.springsecurity.web.model.User;

public interface UserRepository {

    Iterable<User> findAll();
    User save(User user);
    User findUser(Long id);
    void deleteUser(Long id);
}
