package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/butter/api/v1/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    //Adding new category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category addedCate = this.categoryService.addCategory(category);
        return ResponseEntity.ok(addedCate);
    }

    //update category
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        Category updatedCate = this.categoryService.updateCate(category);

        return ResponseEntity.ok(updatedCate);

    }

    //get list of categories
    @GetMapping("/")
    public ResponseEntity<?> getListOfCategory()
    {
        return ResponseEntity.ok(this.categoryService.getAllCate());
    }


    //get single category by id
    @GetMapping("/{catId}")
    public Category getCategory(@PathVariable Integer catId)
    {
        return this.categoryService.getSingleCate(catId);
    }



    //Delete Category
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCate(@PathVariable Integer catId)
    {
        this.categoryService.deleteCat(catId);
        return new ResponseEntity<>(new ApiResponse("Category successfully deleted !!"), HttpStatus.OK);
    }

}
