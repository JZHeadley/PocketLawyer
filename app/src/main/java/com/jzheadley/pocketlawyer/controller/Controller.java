package com.jzheadley.pocketlawyer.controller;

import android.util.Log;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.jzheadley.pocketlawyer.data.model.Intervention;
import com.jzheadley.pocketlawyer.data.model.Report;

import java.util.HashMap;
import java.util.List;

/**
 * Initializes the executive and the interpreter with hard-coded interventions/keywords
 * <p>
 * Provides all interfaces necessary for model;
 */

public class Controller {

    private static final String TAG = "Controller";

    private static final Intervention whyIntervention = new Intervention("why", "I don't know, officer.");
    private static final Intervention searchIntervention = new Intervention("search", "I don't know, officer.");


    private static Controller instance = new Controller();


    private Executive executive;

    private Interpreter interpreter;

    private Controller() {
        Log.i(TAG, "Controller: Constructor called");
        if (instance == null) {
            Log.i(TAG, "Controller: instance is null");
        }
        HashMap<String, Intervention> interventions = new HashMap<>();
        interventions.put("why", new Intervention("why", "I don't know, officer."));
        interventions.put("search", new Intervention("search", "I don't know, officer."));
        this.executive = new Executive(interventions);

        HashMap<String, String> keyWordsToTriggers = new HashMap<>();
        keyWordsToTriggers.put("trunk", "search");
        keyWordsToTriggers.put("open", "search");
        keyWordsToTriggers.put("why", "why");
        this.interpreter = new Interpreter(keyWordsToTriggers);
    }

    public static Controller getInstance() {
        return instance;
    }

    /* Used by ViewControllers */


    public void startWaiting() {
        executive.startWaiting();
    }

    public void startInteraction() {
        executive.startInteraction();
    }

    public void startQuestions() {
        //TODO: Delete this
    }

    public void trigger(String triggerName) {
        executive.trigger(triggerName);
    }

    public String getDisplayedText() { //TODO - Not a real function - just a reminder
        return "Sample Text";
    }  //TODO: Delete this

    public boolean questionsDone() {  //TODO-Not a real function - just a reminder
        return false;
    } //TODO: Delete this


    /* Used by Watson/Backend */

    public List<String> getKeywords() { //TODO -Not a real function - just a reminder
        return null;
    } //TODO: Delete this

    public void interpretResults(SpeechResults speechResults) {
        Log.d(TAG, "interpretResults() called with: speechResults = [" + speechResults + "]");
        interpreter.interpretResults(speechResults);
    }

    public String getTTSString() { //TODO -Not a real function - just a reminder
        return "Sample Text";
    } //TODO: Delete this

    public void playComplete() {

    }

    public Report getReport() {  //TODO - Not a real function - just a reminder
        return null;
    } //TODO: Delete this


    public Interpreter getInterpreter() {
        return interpreter;
    }

    public Executive getExecutive() {
        return executive;
    }
}
