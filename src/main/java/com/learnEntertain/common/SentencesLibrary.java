package com.learnEntertain.common;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SentencesLibrary {

    static SentencesLibrary library = null;

    public static List<String> sentencesList = new LinkedList<>();

    public static SentencesLibrary getInstance() {
        if(library == null){
            library = new SentencesLibrary();
            init();
        }

        return library;
    }

    private static void init() {
        library.loadSentences();
    }

    private void loadSentences() {
        try {
            File file = new File("files/sentences/en-sentences.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st =br.readLine()) != null){
                sentencesList.add(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRandomStmt(){
        Random random = new Random();
        return sentencesList.get(random.nextInt(sentencesList.size()));
    }


}
