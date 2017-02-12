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




    private static Controller instance = new Controller();


    private Executive executive;

    private Interpreter interpreter;

    private Controller() {
        Log.i(TAG, "Controller: Constructor called");
        if (instance == null) {
            Log.i(TAG, "Controller: instance is null");
        }
        HashMap<String, Intervention> interventions = new HashMap<>();
        HashMap<String, String> keyWordsToTriggers = new HashMap<>();
        if (true) {
            interventions.put("search", new Intervention("search", "You don't have to consent to searches"));
            keyWordsToTriggers.put("trunk", "search");
            keyWordsToTriggers.put("open", "search");
            keyWordsToTriggers.put("search", "search");

            interventions.put("detained", new Intervention("detained", "Ask if you are free to go."));
            keyWordsToTriggers.put("questions", "detained");
        }
        if (true) {
            interventions.put("why", new Intervention("why", "You do not need to volunteer any information"));
            keyWordsToTriggers.put("do you know", "why");
            keyWordsToTriggers.put("why", "why");

            interventions.put("be_polite", new Intervention("be_polite", "Stay calm and be polite"));
            keyWordsToTriggers.put("screw you", "be_polite");
            interventions.put("cooperate", new Intervention("cooperate", "Stay calm and cooperate"));
            keyWordsToTriggers.put("step out", "cooperate");
            keyWordsToTriggers.put("get out", "cooperate");

        }


        this.executive = new Executive(interventions);
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

        interpreter.interpretResults(speechResults);
    }

    public String getTTSString() { //TODO -Not a real function - just a reminder
        return "Sample Text";
    } //TODO: Delete this

    public void playComplete() {
        executive.playComplete();
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
