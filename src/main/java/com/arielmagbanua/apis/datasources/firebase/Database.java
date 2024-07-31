package com.arielmagbanua.apis.datasources.firebase;

import com.arielmagbanua.apis.datasources.firebase.contracts.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class Database implements FirebaseDatabase {
    protected Firestore db;

    public Database() {
        try (FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json")) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Firestore getDb() {
        return db;
    }

    public CollectionReference getCollection(String collection) {
        return db.collection(collection);
    }
}
