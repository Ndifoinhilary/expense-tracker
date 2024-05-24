package com.hilaryd.expense_track_app.services;

import com.hilaryd.expense_track_app.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Long id);
    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategory();

    void deleteCategory(Long id);
}
