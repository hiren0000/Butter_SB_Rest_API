package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.GeneralResponse.ApiResponse;
import com.rebel.Ecom.Butter_sb_API.Models.Category;
import com.rebel.Ecom.Butter_sb_API.Models.SubCategory;
import com.rebel.Ecom.Butter_sb_API.Services.CategoryService;
import com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/butter/api/v1/subCategory")
public class SubCategoryController
{
    @Autowired
    private SubCategoryService subCategoryService;

    //Adding new sub-category
    @PostMapping("/category/{catId}/")
    public ResponseEntity<SubCategory> addCategory(@RequestBody SubCategory subCategory, @PathVariable Integer catId)
    {
       SubCategory addedCate = this.subCategoryService.addSubCategory(subCategory, catId);
        return ResponseEntity.ok(addedCate);
    }

    //update sub-category
    @PutMapping("/")
    public ResponseEntity<SubCategory> updateCategory(@RequestBody SubCategory subCategory)
    {
        SubCategory updatedCate = this.subCategoryService.updateCate(subCategory);

        return ResponseEntity.ok(updatedCate);

    }

    //get list of sub-categories
    @GetMapping("/list")
    public ResponseEntity<List<SubCategory>> getListOfCategory()
    {
        return ResponseEntity.ok(this.subCategoryService.getAllCate());
    }


    //get single sub-category by id
    @GetMapping("/{scatId}")
    public ResponseEntity<SubCategory> getCategory(@PathVariable Integer scatId)
    {
        return new ResponseEntity<>(this.subCategoryService.getSingleCate(scatId), HttpStatus.OK);
    }



    //Delete sub-Category
    @DeleteMapping("/{scatId}")
    public ResponseEntity<ApiResponse> deleteCate(@PathVariable Integer scatId)
    {
        this.subCategoryService.deleteCat(scatId);
        return new ResponseEntity<>(new ApiResponse("SubCategory successfully deleted !!"), HttpStatus.OK);
    }

    //list of sub categories for specific category
    @GetMapping("/category/{catId}")
    public ResponseEntity<List<SubCategory>> getListOfSubCategory(@PathVariable Integer catId)
    {
        return new ResponseEntity<>(this.subCategoryService.getListOfSubforCate(catId), HttpStatus.OK);
    }

}
