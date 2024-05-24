package com.hilaryd.expense_track_app.repository;

import com.hilaryd.expense_track_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
