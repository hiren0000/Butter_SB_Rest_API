package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.Product;
import com.rebel.Ecom.Butter_sb_API.Repo.CategoryRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.ProductRepo;
import com.rebel.Ecom.Butter_sb_API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    //Add or Update
    @Override
    public Product addProduct(Product product)
    {
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

    //Fetching which are only available
    @Override
    public List<Product> getAvailable()
    {
        return this.productRepo.findByAvailable(true);
    }
}
