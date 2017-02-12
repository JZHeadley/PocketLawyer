package com.jzheadley.pocketlawyer.controller;

import com.jzheadley.pocketlawyer.data.model.Intervention;

import java.util.HashMap;

public class Executive {

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
