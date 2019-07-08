package com.kgisl.springxml.service;

import com.kgisl.springxml.dao.UserDao;
import com.kgisl.springxml.model.Login;
import com.kgisl.springxml.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
