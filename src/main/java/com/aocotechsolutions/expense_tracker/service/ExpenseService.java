package com.aocotechsolutions.expense_tracker.service;

import com.aocotechsolutions.expense_tracker.model.Expense;
import com.aocotechsolutions.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id, Expense expense) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            return expenseOptional.get();
        } else {
            throw new RuntimeException("Expense not found with id: " + id);
        }
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense expense) {
        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found with id: " + id);
        }

        expense.setId(id);

        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);

        if (expenseOptional.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Expense not found with id: " + id);
        }
    }

}
