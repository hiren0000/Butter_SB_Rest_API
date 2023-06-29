package com.rebel.Ecom.Butter_sb_API.Repo;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.Product;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
    //Fetching list of products by category
    public List<Product> findByCategory(Category category);

    //Fetching list of products by SubCategory
    public List<Product> findBySubCategory(SubCategory subCategory);

    //check if Product is available or disable
    public List<Product> findByAvailable(Boolean b);
}
