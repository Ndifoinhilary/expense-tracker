package com.hilaryd.expense_track_app.dto;

import com.hilaryd.expense_track_app.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(Long id, BigDecimal amount , LocalDate localDate, CategoryDto category) {
}
