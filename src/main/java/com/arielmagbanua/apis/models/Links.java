package com.arielmagbanua.apis.models;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
    /**
     * The id of the introduction document.
     */
    private String id;

    /**
     * The GitHub link.
     */
    private String github;

    /**
     * The linkedIn link.
     */
    private String linkedin;

    /**
     * The medium link.
     */
    private String medium;

    /**
     * The threads link.
     */
    private String threads;

    /**
     * The website link.
     */
    private String website;

    /**
     * The xTwitter link.
     */
    private String xTwitter;

    /**
     * Creates model instance by Firestore document snapshot.
     *
     * @param documentSnapshot a Firestore document snapshot object.
     */
    public Links(DocumentSnapshot documentSnapshot) {
        id = documentSnapshot.getId();
        github = documentSnapshot.getString("github");
        linkedin = documentSnapshot.getString("linkedin");
        medium = documentSnapshot.getString("medium");
        threads = documentSnapshot.getString("threads");
        website = documentSnapshot.getString("website");
        xTwitter = documentSnapshot.getString("xtwitter");
    }
}
