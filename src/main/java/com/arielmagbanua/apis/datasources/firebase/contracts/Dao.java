package com.arielmagbanua.apis.datasources.firebase.contracts;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface Dao <T> {
    Optional<T> get(String id) throws ExecutionException, InterruptedException;
}
