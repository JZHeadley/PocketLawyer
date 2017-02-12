package com.jzheadley.pocketlawyer.controller;

import android.util.Log;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.jzheadley.pocketlawyer.data.model.Report;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;
import com.jzheadley.pocketlawyer.data.singletons.DynamoMapperClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Interpreter {

    private static final String TAG = "Interpreter";
    private static String interactionID = null;
    private SpeechToTextService speechToText;
    private HashMap<String, String> keyWordsToTriggers;


    public Interpreter(HashMap<String, String> keyWordsToTriggers) {
        this.keyWordsToTriggers = keyWordsToTriggers;
    }


    public void startSTT() {
        Log.d(TAG, "startSTT: Called");
        interactionID = String.valueOf(new Random(System.currentTimeMillis()).nextInt());


        speechToText = new SpeechToTextService();
        ArrayList<String> keywords = new ArrayList<String>(keyWordsToTriggers.keySet());
        speechToText.setKeywords(keywords);
        speechToText.startRecording();
    }

    public void stopSTT() {
        try {
            speechToText.stopRecording();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void interpretResults(SpeechResults speechResults) {
        Log.d(TAG, "interpretResults() called with: speechResults = [" + speechResults + "]");
        String text = "";
        Set<String> keywordsFound = new HashSet<>();

        try {
            Transcript transcript = speechResults.getResults().get(0);
            Log.d(TAG, "interpretResults: transcript: " + transcript);
            text = transcript.getAlternatives().get(0).getTranscript();

            keywordsFound = transcript.getKeywordsResult().keySet();
        } catch (Exception ex) {
            Log.e(TAG, "interpretResults: caught", ex);
        }
        Log.d(TAG, "interpretResults: Keywords: " + keywordsFound);
        //TODO listen for yes/no seperately;


        Report report = new Report();
        report.setInteractionID(interactionID);
        report.setLocation("Richmond");
        report.setTags(new ArrayList<String>(keywordsFound));
        report.setUserIsFemale(false);
        report.setUserEthnicity("White");

        DynamoMapperClient.getMapper().save(report);

        for (String keyword : keywordsFound) {   //HACK : this picks a keyword at random
            Controller.getInstance().trigger(keyWordsToTriggers.get(keyword));
            break;
        }

        Controller.getInstance().getExecutive().pauseDetected();
    }

}
