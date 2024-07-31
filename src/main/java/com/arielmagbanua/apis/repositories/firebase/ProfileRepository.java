package com.arielmagbanua.apis.repositories.firebase;

import com.arielmagbanua.apis.datasources.firebase.contracts.Dao;
import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.repositories.firebase.contracts.CanGetIntroduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Repository
public class ProfileRepository implements CanGetIntroduction {
    private final Dao<Introduction> introductionDao;

    @Autowired
    public ProfileRepository(Dao<Introduction> introductionDao) {
        this.introductionDao = introductionDao;
    }

    @Override
    public Optional<Introduction> getIntroduction() {
        try {
            return introductionDao.get("introduction");
        } catch (ExecutionException | InterruptedException e) {
            return Optional.empty();
        }
    }
}
