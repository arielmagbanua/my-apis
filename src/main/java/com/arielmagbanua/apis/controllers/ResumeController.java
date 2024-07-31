package com.arielmagbanua.apis.controllers;

import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.services.contracts.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    private final IntroductionService introductionService;

    @Autowired
    public ResumeController(IntroductionService introductionService) {
        this.introductionService = introductionService;
    }

    @GetMapping("/introduction")
    public ResponseEntity<Introduction> getIntroduction() {
        Introduction introduction = introductionService.getIntroduction();

        if (introduction != null) {
            return new ResponseEntity<>(introduction, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
