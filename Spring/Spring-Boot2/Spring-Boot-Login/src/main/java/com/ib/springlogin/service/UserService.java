package com.ib.springlogin.service;

import com.ib.springlogin.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
