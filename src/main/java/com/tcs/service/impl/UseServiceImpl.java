package com.tcs.service.impl;

import com.tcs.domain.model.User;
import com.tcs.domain.repository.UserRepository;
import com.tcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UseServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UseServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("Account number already exists");
        }
        return userRepository.save(user);
    }
}
