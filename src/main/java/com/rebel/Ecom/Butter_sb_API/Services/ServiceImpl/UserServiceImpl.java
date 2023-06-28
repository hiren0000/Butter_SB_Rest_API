package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;


import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRepo;
import com.rebel.Ecom.Butter_sb_API.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    //Adding new User
    @Override
    public User addUser(User user)
    {
        return this.userRepo.save(user);
    }

    //Update user
    @Override
    public User updateUser(User user)
    {
        return this.userRepo.save(user);
    }

    //Fetching all users
    @Override
    public List<User> getAllUsers()
    {
       List<User> users = this.userRepo.findAll();
       return users;
    }

    //Fetching single user
    @Override
    public User getSingleUserById(Integer id)
    {
        return this.userRepo.getById(id);
    }

    //Delete user
    @Override
    public void deleteUser(Integer id)
    {
       this.userRepo.deleteById(id);
    }
}
