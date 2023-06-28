package com.rebel.Ecom.Butter_sb_API.Repo;

import com.rebel.Ecom.Butter_sb_API.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{

}
