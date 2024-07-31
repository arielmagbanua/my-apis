package com.arielmagbanua.apis.repositories.firebase.contracts;

import com.arielmagbanua.apis.models.Introduction;

import java.util.Optional;

public interface CanGetIntroduction {
    Optional<Introduction> getIntroduction();
}
