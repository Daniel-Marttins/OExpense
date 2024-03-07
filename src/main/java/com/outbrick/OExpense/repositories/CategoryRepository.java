package com.outbrick.OExpense.repositories;

import com.outbrick.OExpense.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {}
