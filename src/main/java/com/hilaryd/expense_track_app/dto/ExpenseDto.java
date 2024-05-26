package com.hilaryd.expense_track_app.dto;

import com.hilaryd.expense_track_app.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto{
    private Long id;
    private BigDecimal amount;
    private LocalDate localDateTime;

    private CategoryDto category;
}
