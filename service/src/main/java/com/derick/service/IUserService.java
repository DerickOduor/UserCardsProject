package com.derick.service;

import com.derick.domain.User;

public interface IUserService {
    User findByUsername(String Username);
}
