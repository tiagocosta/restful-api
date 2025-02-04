package com.tcs.service;

import com.tcs.domain.model.User;

public interface UserService extends CrudService<Long, User> {

    User findById(Long id);

    User create(User user);
}
