package com.outbrick.OExpense.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryDescription;
    @OneToMany(mappedBy = "movementCategory")
    private List<Movements> categoryMovements = new ArrayList<>();
}
