package com.arielmagbanua.apis.repositories.firebase;

import com.arielmagbanua.apis.datasources.firestore.contracts.Dao;
import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.repositories.firebase.contracts.IntroductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * The repository for all profile related data.
 */
@Repository
public class ProfileRepository implements IntroductionRepository {
    /**
     * The Introduction data access object.
     */
    private final Dao<Introduction> introductionDao;

    /**
     * Creates an instance of this repository.
     *
     * @param introductionDao an instance of Introduction data access object.
     */
    @Autowired
    public ProfileRepository(Dao<Introduction> introductionDao) {
        this.introductionDao = introductionDao;
    }

    /**
     * Retrieves introduction data.
     *
     * @return an optional Introduction object.
     */
    @Override
    public Optional<Introduction> getIntroduction() {
        try {
            return introductionDao.get("introduction");
        } catch (ExecutionException | InterruptedException e) {
            return Optional.empty();
        }
    }
}
