package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Repo.CategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Services.CategoryService;
import com.rebel.Ecom.Butter_sb_API.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepo categoryRepo;

    //Add new Category
    @Override
    public Category addCategory(Category category)
    {

        return this.categoryRepo.save(category);
    }

    //update Category
    @Override
    public Category updateCate(Category category)
    {
        return this.categoryRepo.save(category);
    }

    //List of all categories
    @Override
    public List<Category> getAllCate() {

        List<Category> categories = this.categoryRepo.findAll();

        return categories;
    }

    // get Single Category
    @Override
    public Category getSingleCate(Integer catId)
    {


        return this.categoryRepo.getById(catId);
    }

    //Delete Category with Id
    @Override
    public void deleteCat(Integer catId)
    {
        this.categoryRepo.deleteById(catId);

    }

}
