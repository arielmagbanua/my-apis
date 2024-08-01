package com.arielmagbanua.apis.models;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The data class for introduction.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Introduction {
    /**
     * The id of the introduction document.
     */
    private String id;

    /**
     * The about data.
     */
    private String about;

    /**
     * The headline data.
     */
    private String headline;

    /**
     * Creates model instance by Firestore document snapshot.
     *
     * @param documentSnapshot a Firestore document snapshot object.
     */
    public Introduction(DocumentSnapshot documentSnapshot) {
        id = documentSnapshot.getId();
        about = documentSnapshot.getString("about");
        headline = documentSnapshot.getString("headline");
    }
}
