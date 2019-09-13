package com.learnEntertain.service;

import com.learnEntertain.config.PosConfig;
import com.learnEntertain.models.PosInputModel;
import com.learnEntertain.models.PosOutputModel;
import com.learnEntertain.utility.CommonUtility;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    public PosOutputModel validatePosSentence(PosInputModel posInputModel){
        String sentence = posInputModel.getInputSentence().replaceAll("[.?!,]"," ");
        WhitespaceTokenizer tokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(sentence);

        POSTaggerME posTaggerME = CommonUtility.getInstance().getPosTagggerME();
        String[] tags = posTaggerME.tag(tokens);

        POSSample posSample = new POSSample(tokens, tags);

        for (int i=0 ; i< posSample.getTags().length ; i++){
            System.out.println(posSample.getSentence()[i] +" >> " +posSample.getTags()[i]
                    + " >> "+ PosConfig.getInstance().getPosMeaningByKey(posSample.getTags()[i]));
        }

        return null;
    }

}
