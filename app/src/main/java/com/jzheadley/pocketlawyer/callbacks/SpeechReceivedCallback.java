package com.jzheadley.pocketlawyer.callbacks;

import android.util.Log;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
import com.jzheadley.pocketlawyer.controller.Controller;

public class SpeechReceivedCallback implements RecognizeCallback {

    private static final String TAG = "MicrophoneRecognizeDele";

    /**
     * Speech has been received.
     */
    @Override
    public void onTranscription(SpeechResults speechResults) {
        Log.d(TAG, "onTranscription: got results");
        Controller.getInstance().interpretResults(speechResults);
    }

    @Override
    public void onConnected() {
        Log.d(TAG, "Connected to watson");
    }

    @Override
    public void onError(Exception exception) {
        System.err.println(exception);
    }

    @Override
    public void onDisconnected() {
        Log.d(TAG, "onDisconnected: Disconnected from watson");
    }
}