package com.learnEntertain.utility;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.InputStream;

public class CommonUtility {

    static CommonUtility commonUtility = null;
    POSTaggerME posTaggerME;

    public static CommonUtility getInstance() {
        if (commonUtility == null) {
            commonUtility = new CommonUtility();
            commonUtility.init();
        }
        return commonUtility;
    }

    private void init() {
        loadPosTaggerME();
    }

    private void loadPosTaggerME() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("OpenNLP_models/en-pos-maxent.bin");
            POSModel posModel = new POSModel(inputStream);
            posTaggerME = new POSTaggerME(posModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public POSTaggerME getPosTagggerME(){
        return this.posTaggerME;
    }

}
