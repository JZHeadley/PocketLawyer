package com.jzheadley.pocketlawyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.jzheadley.pocketlawyer.controller.Controller;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;
import com.jzheadley.pocketlawyer.data.services.TextToSpeechService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button recordButton, nextButton;
    private SpeechToTextService speechToTextService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
            getApplicationContext(),    /* get the context for the application */
            "us-east-1:a48cc8e1-1d83-4b08-b07f-de46cc8c717e",    /* Identity Pool ID */
            Regions.US_EAST_1           /* Region for your identity pool--US_EAST_1 or EU_WEST_1*/
        );
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);

        recordButton = (Button) findViewById(R.id.btn_record);
        nextButton = (Button) findViewById(R.id.btn_next);
        speechToTextService = new SpeechToTextService();
        final TextToSpeechService textToSpeechService = new TextToSpeechService();
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speechToTextService.startRecording();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, questionsActivity.class));
            }
        });
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textToSpeechService.speak("Hi i'm watson");
                Controller controller = Controller.getInstance();
                controller.startInteraction();


            }
        });
    }


}