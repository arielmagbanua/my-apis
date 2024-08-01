package com.arielmagbanua.apis.datasources.firestore;

import com.arielmagbanua.apis.datasources.firestore.contracts.Dao;
import com.arielmagbanua.apis.datasources.firestore.contracts.FirestoreDatabase;
import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.models.Links;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class LinksDao implements Dao<Links> {
    /**
     * The Firestore database instance.
     */
    private final FirestoreDatabase database;

    /**
     * Creates an instance of this data access object.
     *
     * @param firestoreDatabase the instance of Firestore database object.
     */
    @Autowired
    public LinksDao(FirestoreDatabase firestoreDatabase) {
        database = firestoreDatabase;
    }

    /**
     * Retrieves introduction data.
     *
     * @param id The id of the document.
     * @return an instance of Introduction object.
     */
    @Override
    public Optional<Links> get(String id) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> doc = database.getFutureDoc(
                "profile",
                id.isBlank() || id.isEmpty() ? "links" : id
        );

        // this is blocked so probably handle this using callback
        DocumentSnapshot snapshot = doc.get();

        return Optional.of(new Links(snapshot));
    }
}
