package com.outbrick.OExpense.services;

import com.outbrick.OExpense.dtos.CategoriesDTO;
import com.outbrick.OExpense.dtos.TransactionsDTO;
import com.outbrick.OExpense.dtos.UsersDTO;
import com.outbrick.OExpense.entities.Movements;
import com.outbrick.OExpense.entities.Profiles;
import com.outbrick.OExpense.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public UsersDTO addNewProfile(Profiles profile) {
        Profiles validExists = profileRepository.validExistsProfile(profile.getProfileEmail());
        if(validExists != null) return null;

        Profiles lastAdded = profileRepository.getLastAddedProfile();
        return new UsersDTO(
                lastAdded.getProfileId(),
                lastAdded.getProfileName(),
                lastAdded.getProfileEmail(),
                lastAdded.getProfileBirthday(),
                lastAdded.getProfilePassword(),
                lastAdded.getProfileImage(),
                lastAdded.getProfilePhone(),
                lastAdded.getProfileRegistration(),
                null // Neste caso será nulo pois o usuário ainda não tem movimentações;
        );
    }

    public UsersDTO getProfileById(Long profileId) {
        Optional<Profiles> existingProfile = profileRepository.findById(profileId);
        return existingProfile.map(profiles -> new UsersDTO(
                profiles.getProfileId(),
                profiles.getProfileName(),
                profiles.getProfileEmail(),
                profiles.getProfileBirthday(),
                profiles.getProfilePassword(),
                profiles.getProfileImage(),
                profiles.getProfilePhone(),
                profiles.getProfileRegistration(),
                convertMovementsListDtos(profiles.getProfileMovements())
        )).orElse(null);
    }

    public List<TransactionsDTO> convertMovementsListDtos(List<Movements> movementsList) {
        return movementsList.stream()
                .map(transactions -> {
                        return new TransactionsDTO(
                                transactions.getMovementId(),
                                transactions.getMovementDate(),
                                transactions.getMovementDueDate(),
                                transactions.getMovementHour(),
                                null,
                                transactions.getMovementType(),
                                transactions.getMovementValue(),
                                new CategoriesDTO(
                                        transactions.getMovementCategory().getCategoryId(),
                                        transactions.getMovementCategory().getCategoryDescription(),
                                        null
                                )
                        );
                    }
                ).collect(Collectors.toList());
    }


}
