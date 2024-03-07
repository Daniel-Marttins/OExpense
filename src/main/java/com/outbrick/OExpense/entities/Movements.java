package com.outbrick.OExpense.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;
    private Date movementDate;
    private Date movementDueDate;
    private Timestamp movementHour;
    @ManyToOne
    @JoinColumn(name = "movementProfile")
    private Profiles movementProfile;
    private String movementType;
    private Double movementValue;
    @ManyToOne
    @JoinColumn(name = "movementCategory")
    private Categories movementCategory;

}
