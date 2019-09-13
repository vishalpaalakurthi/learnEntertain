package com.learnEntertain.config;

import java.util.HashMap;
import java.util.Map;

public class PosConfig {

    static PosConfig posConfig = null;
    Map<String, String> posMap = new HashMap<String, String>();

    public static PosConfig getInstance() {
        if(posConfig == null){
            posConfig = new PosConfig();
            posConfig.loadPosMeanings();
        }
        return posConfig;
    }

    public void loadPosMeanings() {
        posMap.put("NN" , PosConstants.NN);
        posMap.put("DT", PosConstants.DT);
        posMap.put("VB", PosConstants.VB);
        posMap.put("VBD", PosConstants.VBD);
        posMap.put("VBZ", PosConstants.VBZ);
        posMap.put("IN", PosConstants.IN);
        posMap.put("NNP", PosConstants.NNP);
        posMap.put("TO", PosConstants.TO);
        posMap.put("JJ", PosConstants.JJ);
    }

    public String getPosMeaningByKey(String key){
        return this.posMap.get(key.toUpperCase());
    }
}
