package com.jzheadley.pocketlawyer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jzheadley.pocketlawyer.controller.Controller;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button recordButton, nextButton;
    private SpeechToTextService speechToTextService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = (Button) findViewById(R.id.btn_next);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechToTextService.startRecording();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, questionsActivity.class);
                intent.putExtra("STTService", (Parcelable) speechToTextService);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        try {
            speechToTextService.stopRecording();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onStop();
    }


}