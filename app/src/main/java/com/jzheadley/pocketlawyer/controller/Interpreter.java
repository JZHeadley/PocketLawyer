package com.jzheadley.pocketlawyer.controller;

import android.util.Log;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Interpreter {

    private static final String TAG = "Interpreter";

    private Executive executive;

    private HashMap<String, String> keyWordsToTriggers;


    public Interpreter(HashMap<String, String> keyWordsToTriggers) {
        this.executive = Controller.getInstance().getExecutive();
        this.keyWordsToTriggers = keyWordsToTriggers;
    }


    public void startSTT() {
        Log.i(TAG, "startSTT: Called");
        SpeechToTextService speechToText = new SpeechToTextService();
        ArrayList<String> keywords = new ArrayList<String>(keyWordsToTriggers.keySet());
        speechToText.setKeywords(keywords);
        speechToText.startRecording();
    }

    public void stopSTT() {
        //TODO
    }


    public void interpretResults(SpeechResults speechResults) {
        Log.d(TAG, "interpretResults: Called");
        String text = "";
        Set<String> keywordsFound = new HashSet<>();

        try {
            Transcript transcript = speechResults.getResults().get(0);
            text = transcript.getAlternatives().get(0).getTranscript();
            keywordsFound = transcript.getKeywordsResult().keySet();
        } catch (Exception ex) {

        }

        //TODO listen for yes/no seperately;

        for (String keyword : keywordsFound) {   //HACK : this picks a keyword at random
            executive.trigger(keyWordsToTriggers.get(keyword));
            break;
        }

        executive.pauseDetected();
    }

}
