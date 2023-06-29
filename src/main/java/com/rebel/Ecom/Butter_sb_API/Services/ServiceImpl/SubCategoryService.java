package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;

import java.util.List;

public interface SubCategoryService
{
    //creating sub-category
    public SubCategory addCategory(SubCategory subCategory);

    //update sub-category
    public SubCategory updateCate(SubCategory subCategory);

    //list of sub-categories
    public List<SubCategory> getAllCate();

    //get single sub-category
    public SubCategory getSingleCate(Integer scatId);

    //delete sub-Cate
    public void deleteCat(Integer scatId);

    //Fetch list of sub-categories for specific Category
    public List<SubCategory> getListOfSubforCate(Integer catId);
}
