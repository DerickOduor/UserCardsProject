package com.derick.service.implemetation;

import com.derick.domain.User;
import com.derick.repository.UserRepository;
import com.derick.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findByUsername(String Username) {
        return userRepository.findByUsername(Username);
    }
}
