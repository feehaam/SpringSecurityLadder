package com.feeham.security2.service;

import com.feeham.security2.entity.User;

import java.util.List;

public interface IUserService {
    User create (User user);
    User readById (Integer userId);
    User readByEmail (String email);
    List<User> readAll ();
    User update (Integer userId, User user);
    void delete (Integer userId);

}
