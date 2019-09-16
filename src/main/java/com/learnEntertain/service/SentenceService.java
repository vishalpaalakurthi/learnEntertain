package com.learnEntertain.service;

import com.learnEntertain.config.PosConfig;
import com.learnEntertain.models.PosInputModel;
import com.learnEntertain.models.PosOutputModel;
import com.learnEntertain.utility.CommonUtility;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class SentenceService {

    private Map<String,String> posOutMap = new LinkedHashMap<>();

    public PosOutputModel validatePosSentence(PosInputModel posInputModel){
        String sentence = posInputModel.getInputSentence().replaceAll("[.?!,]"," ");
        WhitespaceTokenizer tokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(sentence);

        POSTaggerME posTaggerME = CommonUtility.getInstance().getPosTagggerME();
        String[] tags = posTaggerME.tag(tokens);

        POSSample posSample = new POSSample(tokens, tags);

        for (int i=0 ; i< posSample.getTags().length ; i++){
            posOutMap.put(posSample.getSentence()[i],posSample.getTags()[i]);
            System.out.println(posSample.getSentence()[i] +" >> " +posSample.getTags()[i]
                    + " >> "+ PosConfig.getInstance().getPosMeaningByKey(posSample.getTags()[i]));
        }

        PosOutputModel outputModel = new PosOutputModel();

        outputModel.setSentence(posInputModel.getInputSentence());
        outputModel.setPosInputMap(posInputModel.getPosData());
        outputModel.setPosOutputMap(posOutMap);

        if(outputModel.getPosInputMap().toString().equalsIgnoreCase(outputModel.getPosOutputMap().toString())){
            outputModel.setSuccessFlag(true);
        }else{
            outputModel.setSuccessFlag(false);
        }

        return outputModel;
    }

}
