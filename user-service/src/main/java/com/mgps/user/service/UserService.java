package com.mgps.user.service;

import com.mgps.user.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String uid);
}
