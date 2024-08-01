package com.arielmagbanua.apis.repositories.firebase;

import com.arielmagbanua.apis.datasources.firestore.contracts.Dao;
import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.models.Links;
import com.arielmagbanua.apis.repositories.firebase.contracts.IntroductionRepository;
import com.arielmagbanua.apis.repositories.firebase.contracts.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * The repository for all profile related data.
 */
@Repository
public class ProfileRepository implements IntroductionRepository, LinksRepository {
    /**
     * The Introduction data access object.
     */
    private final Dao<Introduction> introductionDao;

    /**
     * The Links data access object.
     */
    private final Dao<Links> linksDao;

    /**
     * Creates an instance of this repository.
     *
     * @param introductionDao an instance of Introduction data access object.
     * @param linksDao an instance of Links data access object.
     */
    @Autowired
    public ProfileRepository(
            Dao<Introduction> introductionDao,
            Dao<Links> linksDao
    ) {
        this.introductionDao = introductionDao;
        this.linksDao = linksDao;
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

    /**
     * Retrieves links data.
     *
     * @return an optional Links object.
     */
    @Override
    public Optional<Links> getLinks() {
        try {
            return linksDao.get("links");
        } catch (ExecutionException | InterruptedException e) {
            return Optional.empty();
        }
    }
}
