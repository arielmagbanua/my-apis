package com.arielmagbanua.apis.datasources.firebase;

import com.arielmagbanua.apis.datasources.firebase.contracts.Dao;
import com.arielmagbanua.apis.datasources.firebase.contracts.FirebaseDatabase;
import com.arielmagbanua.apis.models.Introduction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class IntroductionDao implements Dao<Introduction> {
    private final FirebaseDatabase database;

    @Autowired
    public IntroductionDao(FirebaseDatabase firebaseDatabase) {
        database = firebaseDatabase;
    }

    @Override
    public Optional<Introduction> get(String id) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> doc =  database.getCollection("profile")
                .document("introduction")
                .get();

        // this is blocked so probably handle this using callback
        DocumentSnapshot snapshot = doc.get();

        return Optional.of(new Introduction(snapshot));
    }
}
