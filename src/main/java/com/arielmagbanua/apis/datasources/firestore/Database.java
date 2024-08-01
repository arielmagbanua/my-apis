package com.arielmagbanua.apis.datasources.firestore;

import com.arielmagbanua.apis.datasources.firestore.contracts.FirestoreDatabase;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

/**
 * The wrapper class for accessing Firestore database.
 */
@Getter
@Setter
@Component
public class Database implements FirestoreDatabase {
    /**
     * The firestore database instance.
     */
    protected Firestore db;

    /**
     * Initializes Firebase SDK and creates and instance of Firestore database wrapper.
     */
    public Database() {
        // load the service account key
        try (FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json")) {
            // create an option object for initialization
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Initialize app
            FirebaseApp.initializeApp(options);

            // set the Firestore database object
            setDb(FirestoreClient.getFirestore());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the Firestore collection object with the given collection name.
     *
     * @param name the name of the collection.
     * @return a collection reference object.
     */
    public CollectionReference getCollection(String name) {
        return getDb().collection(name);
    }

    /**
     * Retrieves get future document snapshot object.
     *
     * @param collectionName the name of the collection.
     * @param docId the doc id.
     * @return an future document snapshot.
     */
    @Override
    public ApiFuture<DocumentSnapshot> getFutureDoc(String collectionName, String docId) {
        return getCollection(collectionName)
                .document(docId)
                .get();
    }
}
