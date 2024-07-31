package com.arielmagbanua.apis.datasources.firebase.contracts;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

public interface FirebaseDatabase {
    Firestore getDb();
    CollectionReference getCollection(String collection);
}
