package com.jzheadley.pocketlawyer.controller;

import android.util.Log;

import com.jzheadley.pocketlawyer.data.model.Intervention;
import com.jzheadley.pocketlawyer.data.services.TextToSpeechService;

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
    private static final String TAG = "Executive";

    private int situationState;
    private int interventionState;
    private HashMap<String, Intervention> interventions; //Maps triggers to interventions
    private Intervention curentIntervention = null;

    public Executive(HashMap<String, Intervention> interventions) {
        this.interventions = interventions;
    }

    public void startWaiting() {
        this.situationState = SIT_WAITING;
        Controller.getInstance().getInterpreter().stopSTT();
    }

    public void startInteraction() {
        this.situationState = SIT_INTERACTING;
        Controller.getInstance().getInterpreter().startSTT();
    }

    /*public void pauseInteraction() throws InterruptedException {
        Controller.getInstance().getInterpreter().pauseSTT();
    }

    public void stopInteraction() {
        Controller.getInstance().getInterpreter().stopSTT();
    }*/

    public void startQuestions() {

    }

    public void trigger(String triggerName) {
        Log.d(TAG, "trigger: triggerName: " + triggerName + " intervState: " + interventionState);
        if (triggerName == null) {
            return;
        }

        if (triggerName == "yes") {
            if (interventionState == INTERV_YES_NO) {
                interventionState = INTERV_NONE;
                trigger(curentIntervention.getYesTrigger());
            }
        } else if (triggerName == "no") {
            if (interventionState == INTERV_YES_NO) {
                interventionState = INTERV_NONE;
                trigger(curentIntervention.getNoTrigger());
            }
        } else {
            if (interventionState == INTERV_NONE) {
                curentIntervention = interventions.get(triggerName);
                if (curentIntervention != null) {
                    interventionState = INTERV_WAITING_FOR_PAUSE;
                }
            }
        }
    }

    public void pauseDetected() {
        if (interventionState == INTERV_WAITING_FOR_PAUSE) {
            interventionState = INTERV_PLAYING;
            TextToSpeechService textToSpeech = new TextToSpeechService();
            textToSpeech.speak(curentIntervention.getPromptText());
        }

    }

    public void playComplete() {
        Log.d(TAG, "playComplete: Called, intervState" + interventionState);
        if (interventionState == INTERV_PLAYING) {
            interventionState = INTERV_NONE;
        }
        //TODO : Handle yes/no and record

    }

    public int getSituationState() {
        return situationState;
    }


}
