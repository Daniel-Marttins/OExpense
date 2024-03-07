package com.outbrick.OExpense.dtos;

import com.outbrick.OExpense.entities.Categories;
import com.outbrick.OExpense.entities.Profiles;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.sql.Timestamp;

public record TransactionsDTO(
        Long transactionId,
        Date transactionDate,
        Date transactionDueDate,
        Timestamp transactionHour,
        UsersDTO transactionUser,
        String transactionType,
        Double transactionValue,
        CategoriesDTO transactionCategory
) {}
