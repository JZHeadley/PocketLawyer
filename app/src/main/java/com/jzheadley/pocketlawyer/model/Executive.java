package com.jzheadley.pocketlawyer.model;

import java.util.HashMap;

/**
 * Created by pjhud on 2/11/2017.
 */

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
