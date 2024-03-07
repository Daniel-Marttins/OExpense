package com.outbrick.OExpense.dtos;

import java.sql.Date;
import java.util.List;

public record UsersDTO(
        Long userDTOId,
        String userDTOName,
        String userDTOEmail,
        Date userDTOBirthday,
        String userDTOPassword,
        Byte[] userDTOImage,
        String userDTOPhone,
        Date userDTORegistration,
        List<TransactionsDTO> userDTOMovements
) {}
