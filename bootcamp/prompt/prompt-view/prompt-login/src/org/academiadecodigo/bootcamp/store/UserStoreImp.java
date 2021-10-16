package org.academiadecodigo.bootcamp.store;

import org.academiadecodigo.bootcamp.domain.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.HashMap;
import java.util.Map;

public class UserStoreImp implements UserStore {

    private Map<String, User> users;

    public UserStoreImp() {
        users = new HashMap<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) &&
                users.get(username).getPassword().equals(Security.getHash(password));
    }

    @Override
    public void add(User user) {
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);
        }
    }

    @Override
    public User findByName(String username) {
        return users.get(username);
    }

    @Override
    public int count() {
        return users.size();
    }
}
