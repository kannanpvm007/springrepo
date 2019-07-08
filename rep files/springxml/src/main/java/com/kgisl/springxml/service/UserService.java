package com.kgisl.springxml.service;

import com.kgisl.springxml.model.Login;
import com.kgisl.springxml.model.User;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
}