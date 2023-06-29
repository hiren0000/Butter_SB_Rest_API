package com.rebel.Ecom.Butter_sb_API.Repo;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer>
{
    //Fetching list of sub categories for specific category
    public List<SubCategory> findByCategory(Category category);

}
