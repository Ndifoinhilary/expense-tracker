package com.hilaryd.expense_track_app.services;

import com.hilaryd.expense_track_app.dto.ExpenseDto;

import java.util.List;

public interface ExpenseServices {
     ExpenseDto create(ExpenseDto expenseDto);
     List<ExpenseDto> getAllExpense();

     ExpenseDto getExpenseById(Long expense_id);

     ExpenseDto updateExpense(ExpenseDto expenseDto, Long id);

     void deleteExpense(Long expenseId);
}
