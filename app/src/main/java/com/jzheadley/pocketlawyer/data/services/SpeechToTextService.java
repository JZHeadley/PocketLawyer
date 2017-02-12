package com.jzheadley.pocketlawyer.data.services;

import android.util.Log;

import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.jzheadley.pocketlawyer.callbacks.SpeechReceivedCallback;
import com.jzheadley.pocketlawyer.data.singletons.SpeechToTextClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpeechToTextService {

    private static final String TAG = "SpeechToTextService";
    private List<String> keywords;
    private SpeechCaptureThread thread;

    public SpeechToTextService() {
        keywords = new ArrayList<>();
    }

    public void startRecording() {
        thread = new SpeechCaptureThread();
        thread.run();
    }

    public void stopRecording() throws InterruptedException, IOException {
        Log.d(TAG, "stopRecording: Stop listening Watson");
        thread.end();
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    private RecognizeOptions getRecognizeOptions() {
        RecognizeOptions.Builder options = new RecognizeOptions.Builder()
            .continuous(true)
            .contentType(ContentType.OPUS.toString())
            .model("en-US_BroadbandModel")
            .interimResults(true)
            .profanityFilter(false)
            .inactivityTimeout(2000);
        if (keywords.size() > 0) {
            String[] keywordArr = keywords.toArray(new String[0]);
            options.keywords(keywordArr);
        }
        return options.build();
    }

    private class SpeechCaptureThread extends Thread {
        private MicrophoneInputStream capture;

        public SpeechCaptureThread() {
            capture = new MicrophoneInputStream(true);
        }

        @Override
        public void run() {
            SpeechToTextClient.getInstance().recognizeUsingWebSocket(capture, getRecognizeOptions(), new SpeechReceivedCallback());
        }

        public void end() throws IOException {
            capture.close();
            Log.d(TAG, "end: Trying to stop the recorder");
        }
    }
}
