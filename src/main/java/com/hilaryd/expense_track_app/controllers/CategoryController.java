package com.hilaryd.expense_track_app.controllers;

import com.hilaryd.expense_track_app.dto.CategoryDto;
import com.hilaryd.expense_track_app.entity.Category;
import com.hilaryd.expense_track_app.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("/create/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        var category = categoryService.createCategory(categoryDto);
        return  new ResponseEntity<>(category, HttpStatusCode.valueOf(200));
    }


    @GetMapping("/{id}/")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long category_id){
        var getCagetory = categoryService.getCategoryById(category_id);
        return ResponseEntity.ok(getCagetory);
    }

    @GetMapping("/all-category/")
    public ResponseEntity<List<CategoryDto>> allCategory(){
       List<CategoryDto> category= categoryService.getAllCategory();
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}/update/")
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto, Long categoryId){
        var category = categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(category,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/delete/")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
      categoryService.deleteCategory(categoryId);
      return ResponseEntity.ok("Deleted successfully ");

    }
}


