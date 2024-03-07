package com.outbrick.OExpense.dtos;

import java.util.List;

public record CategoriesDTO(
        Long categoryId,
        String categoryDescription,
        List<TransactionsDTO> categoryTransactions
)
{}
