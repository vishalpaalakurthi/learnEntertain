package com.learnEntertain.controller;

import com.learnEntertain.common.SentencesLibrary;
import com.learnEntertain.models.PosInputModel;
import com.learnEntertain.models.PosOutputModel;
import com.learnEntertain.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolveDailyChallenge {

    @Autowired
    SentenceService sentenceService;

    @GetMapping(value = "dailySentence")
    public String getDailySentence() {
        String sentence = SentencesLibrary.getInstance().getRandomStmt();
        return sentence;
    }

    @PostMapping(value = "validateSentence", consumes = "application/json", produces = "application/json")
    public PosOutputModel getValidatedOutput(@RequestBody PosInputModel posInputModel) {
        return sentenceService.validatePosSentence(posInputModel);
    }

}
