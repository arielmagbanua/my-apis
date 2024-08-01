package com.arielmagbanua.apis.repositories.firebase.contracts;

import com.arielmagbanua.apis.models.Introduction;

import java.util.Optional;

/**
 * A repository interface for introduction data.
 */
public interface IntroductionRepository {
    /**
     * Retrieves introduction data.
     *
     * @return an optional Introduction object.
     */
    Optional<Introduction> getIntroduction();
}
