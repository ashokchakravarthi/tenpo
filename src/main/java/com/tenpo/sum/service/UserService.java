package com.tenpo.sum.service;

import com.tenpo.sum.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
