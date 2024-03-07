package com.outbrick.OExpense.services;

import com.outbrick.OExpense.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;
}
