package com.danarossa.restapi.service;

import com.danarossa.restapi.data.User;

public interface UserService {
    Iterable<User> all();

    Integer add(User newUser);

    User byId(Integer userId);

    void edit(User userToEdit);

    void delete(Integer userId);
}
