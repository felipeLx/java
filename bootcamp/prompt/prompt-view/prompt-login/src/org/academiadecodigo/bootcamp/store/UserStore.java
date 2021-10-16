package org.academiadecodigo.bootcamp.store;

import org.academiadecodigo.bootcamp.domain.User;

public interface UserStore {

    boolean authenticate(String username, String password);

    void add(User user);

    User findByName(String username);

    int count();
}
