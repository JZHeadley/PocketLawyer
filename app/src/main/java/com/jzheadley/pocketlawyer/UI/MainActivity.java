package com.jzheadley.pocketlawyer.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.jzheadley.pocketlawyer.R;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SpeechToText speechService;
    private MicrophoneInputStream capture;
    private Button recordButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordButton = (Button) findViewById(R.id.btn_record);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new SpeechToTextService()).startRecording();
            }
        });

    }


}