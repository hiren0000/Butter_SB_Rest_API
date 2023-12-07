package com.rebel.Ecom.Butter_sb_API.jwtCompo;

import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class CustomUserDetails implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceAccessException("User not found !!"));
        return user;
    }
}
