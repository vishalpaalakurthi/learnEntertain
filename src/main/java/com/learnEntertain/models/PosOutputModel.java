package com.learnEntertain.models;

import java.util.Map;

public class PosOutputModel {

    String sentence;
    Map<String,String> posInputMap;
    Map<String,String> posOutputMap;
    boolean successFlag;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Map<String, String> getPosInputMap() {
        return posInputMap;
    }

    public void setPosInputMap(Map<String, String> posInputMap) {
        this.posInputMap = posInputMap;
    }

    public Map<String, String> getPosOutputMap() {
        return posOutputMap;
    }

    public void setPosOutputMap(Map<String, String> posOutputMap) {
        this.posOutputMap = posOutputMap;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }
}
