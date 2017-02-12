package com.jzheadley.pocketlawyer.controller;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.HashMap;


public class Interpreter {

    private HashMap<String, String> keyWordsToTriggers;

    public Interpreter(HashMap<String, String> keyWordsToTriggers) {
        this.keyWordsToTriggers = keyWordsToTriggers;
    }

    private void interpretResults(SpeechResults speechResults) {
        //speechResults.get
    }
}
