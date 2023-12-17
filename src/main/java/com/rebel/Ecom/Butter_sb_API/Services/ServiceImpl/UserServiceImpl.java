package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;


import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Models.UserRole;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRoleRepo;
import com.rebel.Ecom.Butter_sb_API.Services.UserService;
import com.rebel.Ecom.Butter_sb_API.playload.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    //Adding new User
    @Override
    public User addUser(User user)

    {
        //New user will always be saved as Normal User
        UserRole role = this.userRoleRepo.findById(Constants.NORMAL_USER).get();

        List<UserRole> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

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
