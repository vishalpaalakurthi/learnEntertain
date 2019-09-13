package com.learnEntertain.models;

import java.util.Map;

public class PosInputModel {

    String inputSentence;

    Map<String,String> posData;

    public String getInputSentence() {
        return inputSentence;
    }

    public void setInputSentence(String inputSentence) {
        this.inputSentence = inputSentence;
    }

    public Map<String, String> getPosData() {
        return posData;
    }

    public void setPosData(Map<String, String> posData) {
        this.posData = posData;
    }
}
