package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.Product;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;
import com.rebel.Ecom.Butter_sb_API.Repo.CategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.ProductRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.SubCategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    //Add new product only for cat
    @Override
    public Product addNewProd(Product product)
    {
         Category category = this.categoryRepo.findById(product.getCategory().getCatId()).
                    orElseThrow(() -> new ResourceAccessException("Category does not exist !!"));

         return this.productRepo.save(product);
    }

    //Add product for subCategory
    @Override
    public Product addProduct(Product product)

    {
        Category category = this.categoryRepo.findById(product.getCategory().getCatId()).
                orElseThrow(() -> new ResourceAccessException("Category does not exists !!"));

        SubCategory subCategory = this.subCategoryRepo.findById(product.getSubCategory().getScatId()).
                orElseThrow(() -> new ResourceAccessException("SubCategory does not exists !!"));

        return this.productRepo.save(product);
    }

    //Update Prod
    @Override
    public Product updateProduct(Product product)
    {
        return this.productRepo.save(product);
    }

    //Fetching ALl
    @Override
    public List<Product> getAllProd()
    {
        return this.productRepo.findAll();
    }

    //Fetching Single
    @Override
    public Product getSingleProd(Integer pId)
    {
        return this.productRepo.getById(pId);
    }

    //Delete
    @Override
    public void deleteProd(Integer pId)
    {
        this.productRepo.deleteById(pId);
    }

    //Fetching for Category
    @Override
    public List<Product> getListOfProfForCat(Integer catId)
    {

        Category category = this.categoryRepo.getById(catId);

        return this.productRepo.findByCategory(category);
    }

    //Fetching for SubCategory
    @Override
    public List<Product> getListOfProfForSubCat(Integer scatId)
    {

        SubCategory subCategory = this.subCategoryRepo.getById(scatId);

        return this.productRepo.findBySubCategory(subCategory);
    }


    //Fetching which are only available
    @Override
    public List<Product> getAvailable()
    {
        return this.productRepo.findByAvailable(true);
    }
}
