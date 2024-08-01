package com.arielmagbanua.apis.repositories.firebase.contracts;


import com.arielmagbanua.apis.models.Links;

import java.util.Optional;

/**
 * A repository interface for links data.
 */
public interface LinksRepository {
    /**
     * Retrieves links data.
     *
     * @return an optional Links object.
     */
    Optional<Links> getLinks();
}
