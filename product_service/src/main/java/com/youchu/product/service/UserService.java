package com.youchu.product.service;

import com.youchu.product.entity.User;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}
