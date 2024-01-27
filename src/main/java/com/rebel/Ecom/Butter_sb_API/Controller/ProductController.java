package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.ImageModel;
import com.rebel.Ecom.Butter_sb_API.Models.Product;
import com.rebel.Ecom.Butter_sb_API.Services.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/butter/api/v1/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/category/adding-prod", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> addNewProforCat(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile[] file)
    {

        try
        {
            Set<ImageModel> productImages = this.uploadImage(file);
            product.setProductImages(productImages);
            return new ResponseEntity<>(this.productService.addNewProd(product), HttpStatus.OK );

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }


    //Adding product for subcategory for product
    @PostMapping("/category/subcategory/adding-prod")
    public ResponseEntity<Product> addNewPro(@RequestBody Product product)
    {
        return new ResponseEntity<>(this.productService.addProduct(product), HttpStatus.OK );
    }

    //Receiving Multi part file === and then fetching image details
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException
    {
        Set<ImageModel> imageModels = new HashSet<>();

        for(MultipartFile file : multipartFiles)
        {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }

        return imageModels;
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
