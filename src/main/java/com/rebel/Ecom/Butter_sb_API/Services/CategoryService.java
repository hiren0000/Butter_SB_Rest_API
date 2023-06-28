package com.rebel.Ecom.Butter_sb_API.Services;

import com.rebel.Ecom.Butter_sb_API.Models.Category;

import java.util.List;

public interface CategoryService
{
    //creating service
    public Category addCategory(Category category);

    //update category
    public Category updateCate(Category category);

    //list of categories
    public List<Category> getAllCate();

    //get single category
    public Category getSingleCate(Integer catId);

    //delete Cate
    public void deleteCat(Integer catId);
}
