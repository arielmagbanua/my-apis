package com.arielmagbanua.apis.services;

import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.repositories.firebase.contracts.CanGetIntroduction;
import com.arielmagbanua.apis.services.contracts.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService implements IntroductionService {
    private final CanGetIntroduction canGetIntroduction;

    @Autowired
    public ProfileService(CanGetIntroduction canGetIntroduction) {
        this.canGetIntroduction = canGetIntroduction;
    }

    @Override
    public Introduction getIntroduction() {
        Optional<Introduction> intro = canGetIntroduction.getIntroduction();
        return intro.orElse(null);
    }
}
