package com.hilaryd.expense_track_app.services.impl;

import com.hilaryd.expense_track_app.dto.CategoryDto;
import com.hilaryd.expense_track_app.entity.Category;
import com.hilaryd.expense_track_app.exception.ResouceNotFoundException;
import com.hilaryd.expense_track_app.mapper.CategoryMapper;
import com.hilaryd.expense_track_app.repository.CategoryRepository;
import com.hilaryd.expense_track_app.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        var category = modelMapper.map(categoryDto, Category.class);
        var saveCategory = categoryRepository.save(category);

        return modelMapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Not Found"));
        category.setName(category.getName());
        var savecategory = categoryRepository.save(category);


        return modelMapper.map(savecategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        var getcategory = categoryRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Category not found"));

        return modelMapper.map(getcategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        var getAll = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return getAll;
    }

    @Override
    public void deleteCategory(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }
}
