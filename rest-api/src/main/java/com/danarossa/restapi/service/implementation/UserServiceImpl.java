package com.danarossa.restapi.service.implementation;

import com.danarossa.restapi.data.User;
import com.danarossa.restapi.repository.UserRepository;
import com.danarossa.restapi.service.ServiceException;
import com.danarossa.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<User> all() {
        return userRepository.findAll();
    }

    @Override
    public Integer add(User newUser) {
        if (!userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            userRepository.save(newUser);
            return newUser.getUserId();
        } else throw new ServiceException("User not found");

    }

    @Override
    public User byId(Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            return byId.get();
        } else throw new ServiceException("User not found");
    }

    @Override
    public void edit(User userToEdit) {
        userRepository.save(userToEdit);
    }


    @Override
    public void delete(Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            userRepository.delete(byId.get());
        } else {
            throw new ServiceException("user doesnt exist");
        }
    }
}
