package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;
import com.rebel.Ecom.Butter_sb_API.Repo.CategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.SubCategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService
{
    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    //Add new Category
    @Override
    public SubCategory addCategory(SubCategory subCategory)
    {

        return this.subCategoryRepo.save(subCategory);
    }

    //update Category
    @Override
    public SubCategory updateCate(SubCategory subCategory)
    {
        return this.subCategoryRepo.save(subCategory);
    }

    //List of all categories
    @Override
    public List<SubCategory> getAllCate() {

        List<SubCategory> subCategories = this.subCategoryRepo.findAll();

        return subCategories;
    }

    // get Single Category
    @Override
    public SubCategory getSingleCate(Integer scatId)
    {
        return this.subCategoryRepo.getById(scatId);
    }

    //Delete Category with Id
    @Override
    public void deleteCat(Integer scatId)
    {
        this.subCategoryRepo.deleteById(scatId);

    }

    //Sub categories for specific cat
    @Override
    public List<SubCategory> getListOfSubforCate(Integer catId)
    {
        Category category = this.categoryRepo.getById(catId);

        return this.subCategoryRepo.findByCategory(category);
    }
}
