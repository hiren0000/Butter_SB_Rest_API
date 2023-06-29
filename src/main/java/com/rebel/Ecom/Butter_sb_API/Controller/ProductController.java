package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.Product;
import com.rebel.Ecom.Butter_sb_API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/butter/api/v1/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    //Adding
    @PostMapping("/adding-prod")
    public ResponseEntity<Product> addNewPro(@RequestBody Product product)
    {
        return new ResponseEntity<>(this.productService.addProduct(product), HttpStatus.OK );
    }

    //updating
    @PutMapping("/updating-prod")
    public ResponseEntity<Product> updatePro(@RequestBody Product product)
    {
        return new ResponseEntity<>(this.productService.updateProduct(product), HttpStatus.OK );
    }

    //Fetching List of Prod
    @GetMapping("/All-Products")
    public ResponseEntity<List<Product>> getALlPro()
    {
        return new ResponseEntity<>(this.productService.getAllProd(),HttpStatus.OK);
    }

    //Fetching Single  Prod
    @GetMapping("/{pId}")
    public ResponseEntity<Product> getSinglePro(@PathVariable Integer pId)
    {
        return new ResponseEntity<>(this.productService.getSingleProd(pId),HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/{pId}")
    public ResponseEntity<ApiResponse> deletePro(@PathVariable Integer pId)
    {
        this.productService.deleteProd(pId);
        return new ResponseEntity<>(new ApiResponse("Product successfully deleted !!"),HttpStatus.OK);
    }

    //Fetching list of Prod for specific category
    @GetMapping("/category/{catId}")
    public ResponseEntity<List<Product>> getListOfProByCate(@PathVariable Integer catId)
    {
        return new ResponseEntity<>(this.productService.getListOfProfForCat(catId),HttpStatus.OK);
    }

    //Fetching list of Prod for specific category
    @GetMapping("/subCategory/{scatId}")
    public ResponseEntity<List<Product>> getListOfProBySubCate(@PathVariable Integer scatId)
    {
        return new ResponseEntity<>(this.productService.getListOfProfForSubCat(scatId),HttpStatus.OK);
    }

    @GetMapping("/list-available-prods")
    public ResponseEntity<List<Product>> getListOfProByCate()
    {
        return new ResponseEntity<>(this.productService.getAvailable(),HttpStatus.OK);
    }


}
