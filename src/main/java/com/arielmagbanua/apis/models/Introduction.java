package com.arielmagbanua.apis.models;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.signature.qual.Identifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Introduction {
    private String id;
    private String about;
    private String headline;

    public Introduction(DocumentSnapshot documentSnapshot) {
        id = documentSnapshot.getId();
        about = documentSnapshot.getString("about");
        headline = documentSnapshot.getString("headline");
    }
}
