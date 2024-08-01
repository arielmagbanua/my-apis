package com.arielmagbanua.apis.datasources.firestore.contracts;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

/**
 * The interface for interacting (querying so far) data from a Firestore database.
 */
public interface FirestoreDatabase {
    /**
     * Sets the Firestore database instance.
     *
     * @param db the Firestore database instance.
     */
    void setDb(Firestore db);

    /**
     * Retrieves the Firestore database instance.
     *
     * @return the instance of Firestore database.
     */
    Firestore getDb();

    /**
     * Retrieves the Firestore collection object with the given collection name.
     *
     * @param name the name of the collection.
     * @return a collection reference object.
     */
    CollectionReference getCollection(String name);

    /**
     * Retrieves get future document snapshot object.
     *
     * @param collectionName the name of the collection.
     * @param docId the doc id.
     * @return an future document snapshot.
     */
    ApiFuture<DocumentSnapshot> getFutureDoc(String collectionName, String docId);
}
