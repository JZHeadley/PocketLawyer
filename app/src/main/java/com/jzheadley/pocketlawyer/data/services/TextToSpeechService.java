package com.jzheadley.pocketlawyer.data.services;

import android.os.AsyncTask;

import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.jzheadley.pocketlawyer.controller.Controller;
import com.jzheadley.pocketlawyer.data.singletons.TextToSpeechClient;

public class TextToSpeechService {
    private static final String TAG = "TextToSpeechService";

    public void speak(String sentence) {
        new SynthesisTask().execute(sentence);
    }

    private class SynthesisTask extends AsyncTask<String, Void, String> {
        private StreamPlayer player = new StreamPlayer();

        @Override
        protected String doInBackground(String... params) {
            player.playStream(TextToSpeechClient.getInstance().synthesize(params[0], Voice.EN_MICHAEL).execute());
            //Log.d(TAG, "doInBackground: Should call playComplete");
            Controller.getInstance().playComplete();
            return "Did synthesize";
        }
    }
}
