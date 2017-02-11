package com.jzheadley.pocketlawyer.model;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.util.List;

/**
 * Initializes the executive and the interpreter with hard-coded interventions/keywords
 * <p>
 * Provides all interfaces necessary for model;
 */

public class Model {

    private Executive executive;

    private Interpreter interpreter;

    public Model() {
        //Initialize all the hard-coded stuff;
    }

    /* Used by ViewControllers */
    public void startWaiting() {

    }

    public void startInteraction() {

    }

    public void startQuestions() {

    }

    public void trigger(String triggerName) {

    }

    public String getDisplayedText() { //TODO - Not a real function - just a reminder
        return "Sample Text";
    }

    public boolean questionsDone() {  //TODO-Not a real function - just a reminder
        return false;
    }


    /* Used by Watson/Backend */

    public List<String> getKeywords() { //TODO -Not a real function - just a reminder
        return null;
    }

    public void interpretResults(SpeechResults speechResults) {

    }

    public String getTTSString() { //TODO -Not a real function - just a reminder
        return "Sample Text";
    }

    public void playComplete() {

    }

    public Report getReport() {  //TODO - Not a real function - just a reminder
        return null;
    }


}
