package com.rebel.Ecom.Butter_sb_API.Repo;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>
{

}
