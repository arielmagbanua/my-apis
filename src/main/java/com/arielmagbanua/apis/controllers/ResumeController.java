package com.arielmagbanua.apis.controllers;

import com.arielmagbanua.apis.models.Introduction;
import com.arielmagbanua.apis.models.Links;
import com.arielmagbanua.apis.services.contracts.IntroductionService;
import com.arielmagbanua.apis.services.contracts.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    /**
     * The service for dealing with introduction related data.
     */
    private final IntroductionService introductionService;

    /**
     * The service for dealing with links related data.
     */
    private final LinksService linksService;

    /**
     * Creates a new instance of this controller.
     *
     * @param introductionService The injected instance of introduction service.
     */
    @Autowired
    public ResumeController(IntroductionService introductionService, LinksService linksService) {
        this.introductionService = introductionService;
        this.linksService = linksService;
    }

    /**
     * The GET API endpoint for introduction.
     *
     * @return the introduction response entity if there's any.
     */
    @GetMapping("/introduction")
    public ResponseEntity<Introduction> getIntroduction() {
        Introduction introduction = introductionService.getIntroduction();

        if (introduction != null) {
            return new ResponseEntity<>(introduction, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * The GET API endpoint for links.
     *
     * @return the introduction response entity if there's any.
     */
    @GetMapping("/links")
    public ResponseEntity<Links> getLinks() {
        Links links = linksService.getLinks();

        if (links != null) {
            return new ResponseEntity<>(links, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
