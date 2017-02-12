package com.jzheadley.pocketlawyer.data.singletons;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;

public class TextToSpeechClient {
    private static TextToSpeech service = new TextToSpeech("f47ff4a4-6cab-4996-9902-f9fa987f0ba3", "1rLOXX3geKel");

    private TextToSpeechClient() {
    }

    public static TextToSpeech getInstance() {
        return service;
    }

}
