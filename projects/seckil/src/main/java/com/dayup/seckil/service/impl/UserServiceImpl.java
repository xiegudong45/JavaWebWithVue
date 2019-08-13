package com.dayup.seckil.service.impl;

import com.dayup.seckil.model.User;
import com.dayup.seckil.repository.UserRepository;
import com.dayup.seckil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  public UserRepository userRepository;

  @Override
  public User regist(User user) {
    return userRepository.saveAndFlush(user);
  }

}
