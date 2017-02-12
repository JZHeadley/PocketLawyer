package com.jzheadley.pocketlawyer.controller;

import com.jzheadley.pocketlawyer.data.model.Intervention;

import java.util.HashMap;

public class Executive {

    public static final int SIT_WAITING = 0;
    public static final int SIT_INTERACTING = 1;
    public static final int SIT_QUESTIONS = 2;

    public static final int INTERV_NONE = 0;
    public static final int INTERV_WAITING_FOR_PAUSE = 1;
    public static final int INTERV_PLAYING = 2;
    public static final int INTERV_YES_NO = 3;
    public static final int INTERV_RECORD_RESPONSE = 4;

    private int situationState;
    private int interventionState;
    private HashMap<String, Intervention> interventions; //Maps triggers to interventions
    private Intervention curentIntervention = null;

    public void startWaiting() {

    }

    public void startInteraction() {

    }

    public void startQuestions() {

    }

    public void pauseDetected() {

    }

    public void playComplete() {

    }

    public void trigger(String triggerName) {

    }
}
