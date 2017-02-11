package com.jzheadley.pocketlawyer.model;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.HashMap;

/**
 * Created by pjhud on 2/11/2017.
 */

public class Interpreter {

    public HashMap<String, String> keyWordsToTriggers;

    public Interpreter(HashMap<String, String> keyWordsToTriggers) {
        this.keyWordsToTriggers = keyWordsToTriggers;
    }

    public void interpretResults(SpeechResults speechResults) {
        //speechResults.get
    }
}
