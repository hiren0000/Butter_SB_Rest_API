package com.rebel.Ecom.Butter_sb_API.Services;


import com.rebel.Ecom.Butter_sb_API.Models.Product;

import java.util.List;

public interface ProductService
{
    //Add New Product or update existing
    public Product addProduct(Product product);

    //update existing
    public Product updateProduct(Product product);

    //Fetching all the Products
    public List<Product> getAllProd();

    //Fetching single product
    public Product getSingleProd(Integer pId);

    //Delete Product
    public void deleteProd(Integer pId);

    //get Products for specific category
    public List<Product> getListOfProfForCat(Integer catId);

    //get Products for specific category
    public List<Product> getListOfProfForSubCat(Integer scatId);

    //Fetch products only which are in available state
    public List<Product> getAvailable();
}
