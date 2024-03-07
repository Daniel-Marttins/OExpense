package com.outbrick.OExpense.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String profileName;
    private String profileEmail;
    private Date profileBirthday;
    private String profilePassword;
    @Lob
    private Byte[] profileImage;
    private String profilePhone;
    private Date profileRegistration;
    @OneToMany(mappedBy = "movementProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movements> profileMovements = new ArrayList<>();
}
