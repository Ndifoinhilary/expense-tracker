package com.hilaryd.expense_track_app.services.impl;

import com.hilaryd.expense_track_app.dto.ExpenseDto;
import com.hilaryd.expense_track_app.entity.Category;
import com.hilaryd.expense_track_app.entity.Expense;
import com.hilaryd.expense_track_app.exception.ResouceNotFoundException;
import com.hilaryd.expense_track_app.repository.CategoryRepository;
import com.hilaryd.expense_track_app.repository.ExpenseRepository;
import com.hilaryd.expense_track_app.services.ExpenseServices;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseServices {
    private ModelMapper modelMapper;
    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    @Override
    public ExpenseDto create(ExpenseDto expenseDto) {

        var expense = modelMapper.map(expenseDto, Expense.class);
//        create and expense
        var createExpense = expenseRepository.save(expense);

//        convert the created expense to expensedto



        return modelMapper.map(createExpense, ExpenseDto.class);
    }

    @Override
    public List<ExpenseDto> getAllExpense() {
        List<Expense> expense = expenseRepository.findAll();
        return expense.stream().map(expenseDto ->modelMapper.map(expenseDto, ExpenseDto.class) ).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto getExpenseById(Long expense_id) {
        var expense = expenseRepository.findById(expense_id).orElseThrow(() -> new ResouceNotFoundException("The expense does not exitst"));

        return modelMapper.map(expense, ExpenseDto.class);
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto expenseDto, Long id) {
//        getting the expense
        var expense = expenseRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("The expense does not exitst"));

        expense.setAmount(expenseDto.amount());
        expense.setLocalDateTime(expenseDto.localDate());
//       first check if category is not null

        if (expenseDto.category() != null){
//            get the category id

            var category = categoryRepository.findById(expenseDto.category().id())
                    .orElseThrow(() -> new ResouceNotFoundException("The category does not exitst"));

//            update the expense cateogry now

            expense.setCategory(category)
            ;
        }

        var saveExpense =  expenseRepository.save(expense);
        return modelMapper.map(saveExpense, ExpenseDto.class);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        var expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResouceNotFoundException("The expense does not exitst"));
        expenseRepository.delete(expense);
    }
}
