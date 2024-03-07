package com.outbrick.OExpense.repositories;

import com.outbrick.OExpense.entities.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movements, Long> {}
