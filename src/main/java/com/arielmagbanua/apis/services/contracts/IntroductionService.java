package com.arielmagbanua.apis.services.contracts;

import com.arielmagbanua.apis.models.Introduction;

/**
 * The interface for introduction service.
 */
public interface IntroductionService {
    /**
     * Retrieves introduction data.
     *
     * @return an Introduction object.
     */
    Introduction getIntroduction();
}
