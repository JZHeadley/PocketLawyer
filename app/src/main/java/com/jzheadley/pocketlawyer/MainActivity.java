package com.jzheadley.pocketlawyer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button recordButton;
    private SpeechToTextService speechToTextService;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordButton = (Button) findViewById(R.id.btn_record);
        nextButton = (Button) findViewById(R.id.btn_next);
        speechToTextService = new SpeechToTextService();
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechToTextService.startRecording();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    speechToTextService.stopRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}