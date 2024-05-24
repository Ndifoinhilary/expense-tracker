package com.hilaryd.expense_track_app.controllers;


import com.hilaryd.expense_track_app.dto.ExpenseDto;
import com.hilaryd.expense_track_app.services.ExpenseServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseServices expenseServices;


    @PostMapping("/expense-create/")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        var create = expenseServices.create(expenseDto);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }


    @GetMapping("/all-expense/")
    public ResponseEntity<List<ExpenseDto>> allExpense(){
        List<ExpenseDto> expenseDtoList = expenseServices.getAllExpense();

        return ResponseEntity.ok(expenseDtoList);

    }


    @GetMapping("/{id}/expense")
    public  ResponseEntity<ExpenseDto> getEpxenseById(@PathVariable("id") Long expense_id){
        var expense = expenseServices.getExpenseById(expense_id);

        return ResponseEntity.ok(expense);
    }

    @PutMapping("/{id}/update/")
    public ResponseEntity<ExpenseDto> updateExpense(@RequestBody ExpenseDto expenseDto,@PathVariable("id") Long expenseId){
        var expense = expenseServices.updateExpense(expenseDto, expenseId);
        return ResponseEntity.ok(expense);
    }


    @DeleteMapping("/{id}/delete/")
    public  ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseServices.deleteExpense(expenseId);

        return ResponseEntity.ok("Deleted successfully");
    }

}
