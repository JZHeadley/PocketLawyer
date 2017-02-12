package com.jzheadley.pocketlawyer.data.singletons;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

public class SpeechToTextClient {
    private static SpeechToText service = new SpeechToText("539b5b54-ed9e-4b69-b230-5e9d87168c19", "eR3ZouirbNdT");

    private SpeechToTextClient() {
    }

    public static SpeechToText getInstance() {
        return service;
    }

}
