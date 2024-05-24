package com.hilaryd.expense_track_app.repository;

import com.hilaryd.expense_track_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
