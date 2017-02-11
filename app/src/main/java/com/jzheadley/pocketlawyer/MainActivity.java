package com.jzheadley.pocketlawyer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;

public class MainActivity extends AppCompatActivity {
    private SpeechToText speechService;
    private MicrophoneInputStream capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speechService = initSpeechToTextService();


        capture = new MicrophoneInputStream(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    speechService.recognizeUsingWebSocket(capture, getRecognizeOptions(), new MicrophoneRecognizeDelegate());
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    private SpeechToText initSpeechToTextService() {
        SpeechToText service = new SpeechToText();
        String username = getString(R.string.watson_username);
        String password = getString(R.string.watson_password);
        service.setUsernameAndPassword(username, password);
        service.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
        return service;
    }

    private RecognizeOptions getRecognizeOptions() {
        return new RecognizeOptions.Builder()
            .continuous(true)
            // .keywords()
            .contentType(ContentType.OPUS.toString())
            .model("en-US_BroadbandModel")
            .interimResults(true)
            .inactivityTimeout(2000)
            .build();
    }


    private void showError(final Exception e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }

    private class MicrophoneRecognizeDelegate implements RecognizeCallback {

        @Override
        public void onTranscription(SpeechResults speechResults) {
            System.out.println(speechResults);
            String text = speechResults.getResults().get(0).getAlternatives().get(0).getTranscript();
        }

        @Override
        public void onConnected() {

        }

        @Override
        public void onError(Exception e) {
            showError(e);
        }

        @Override
        public void onDisconnected() {
        }
    }
}