package com.rebel.Ecom.Butter_sb_API.Services;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
    //Create New User
    public User addUser(User user);

    //update user
    public User updateUser(User user);

    //Fetching all users
    public List<User> getAllUsers();

    //Fetching single user by id
    public User getSingleUserById(Integer id);

    //Deleting User
    public void deleteUser(Integer id);


}
