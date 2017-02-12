package com.jzheadley.pocketlawyer.controller;

import android.location.Location;
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
    private static final String[] cities = {"Washington, DC", "Richmond, VA", "Alexandria, VA", "Baltimore, MD"};


    private int interactionID = 0;
    private String location = null;
    private Location coordinates = null;


    private SpeechToTextService speechToText;
    private HashMap<String, String> keyWordsToTriggers;


    public Interpreter(HashMap<String, String> keyWordsToTriggers) {
        this.keyWordsToTriggers = keyWordsToTriggers;
    }


    public void startSTT() {
        Log.d(TAG, "startSTT: Called");
        Random rand = new Random(System.currentTimeMillis());
        interactionID = rand.nextInt();
        location = cities[rand.nextInt(4)];
        coordinates = new Location("GPS");
        coordinates.setLongitude(38.0 + 2.0 * rand.nextDouble());
        coordinates.setLatitude(76.0 + 2.0 * rand.nextDouble());


        speechToText = new SpeechToTextService();
        ArrayList<String> keywords = new ArrayList<String>(keyWordsToTriggers.keySet());
        speechToText.setKeywords(keywords);
        speechToText.startRecording();
    }

    public void stopSTT() {
        try {
            speechToText.stopRecording();
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

            if (transcript.getKeywordsResult() != null) {
                keywordsFound = transcript.getKeywordsResult().keySet();

            }
        } catch (Exception ex) {
            Log.e(TAG, "interpretResults: caught", ex);
        }
        Log.d(TAG, "interpretResults: Keywords: " + keywordsFound);
        //TODO listen for yes/no seperately;

        Report report = new Report();
        report.setReportID((interactionID * 10000) + speechResults.getResultIndex());
        report.setInteractionID(String.valueOf(interactionID));
        report.setResultIndex(speechResults.getResultIndex());
        //location = "Washington, DC";
        //coordinates.setLongitude(38.904862);
        //coordinates.setLatitude(-77.033642);

        report.setSpeechResults(speechResults);
        report.setTranscript(text);

        report.setLocation(location);
        // report.setCoordinates(coordinates);

        report.setUserIsFemale(false);
        report.setUserEthnicity("White");

        for (String keyword : keywordsFound) {   //HACK : this picks a keyword at random
            report.setTags(keywordsFound);
            Controller.getInstance().trigger(keyWordsToTriggers.get(keyword));
            break;
        }

        DynamoMapperClient.getMapper().save(report);

        Controller.getInstance().getExecutive().pauseDetected();
    }

}
