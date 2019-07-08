package com.kgisl.springxml.dao;

import com.kgisl.springxml.model.Login;
import com.kgisl.springxml.model.User;

public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}