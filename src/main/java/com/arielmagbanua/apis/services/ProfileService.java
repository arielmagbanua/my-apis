package com.arielmagbanua.apis.services;

import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.repositories.firebase.contracts.IntroductionRepository;
import com.arielmagbanua.apis.services.contracts.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The Profile service for any profile related data interaction and business logic.
 */
@Service
public class ProfileService implements IntroductionService {
    /**
     * The introduction repository.
     */
    private final IntroductionRepository introductionRepository;

    /**
     * Creates an instance of profile service.
     *
     * @param introductionRepository the introduction repository instance.
     */
    @Autowired
    public ProfileService(IntroductionRepository introductionRepository) {
        this.introductionRepository = introductionRepository;
    }

    /**
     * Retrieves introduction data.
     *
     * @return an Introduction object.
     */
    @Override
    public Introduction getIntroduction() {
        Optional<Introduction> intro = introductionRepository.getIntroduction();
        return intro.orElse(null);
    }
}
