package com.arielmagbanua.apis.datasources.firestore.contracts;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * The DAO interface for retrieving any records from firestore.
 *
 * @param <T>
 */
public interface Dao<T> {
    Optional<T> get(String id) throws ExecutionException, InterruptedException;
}
