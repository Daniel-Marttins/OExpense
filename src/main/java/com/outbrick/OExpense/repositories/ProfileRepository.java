package com.outbrick.OExpense.repositories;

import com.outbrick.OExpense.entities.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profiles, Long> {

    @Query(value = "SELECT * FROM PROFILES WHERE PROFILE_EMAIL = :EMAIL", nativeQuery = true)
    public Profiles validExistsProfile(@Param(value = "EMAIL") String profileEmail);

    @Query(value = "SELECT TOP 1 * FROM PROFILES ORDER BY PROFILE_ID DESC", nativeQuery = true)
    public Profiles getLastAddedProfile();

}
