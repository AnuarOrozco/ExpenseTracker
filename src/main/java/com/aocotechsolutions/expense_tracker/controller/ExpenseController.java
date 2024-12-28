package com.aocotechsolutions.expense_tracker.controller;

import com.aocotechsolutions.expense_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String showDashboard() {
        return "Dashboard";
    }

}
