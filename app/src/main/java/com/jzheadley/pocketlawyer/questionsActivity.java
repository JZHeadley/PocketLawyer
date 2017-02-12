package com.jzheadley.pocketlawyer;

        import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

public class questionsActivity extends Activity{

    final Context context = this;
    private Button button;
    private ImageButton pauseButton;
    private ImageButton micButton;
    private SpeechToTextService speechToTextService;
    public boolean go = false;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        button = (Button) findViewById(R.id.scenario1);

        //add button listener
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.scenario1);
                dialog.setTitle("Scenario1");

                //custom dialog settings
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("Scenario 1 works!");
                //ImageView image = (ImageView) dialog.findViewById(R.id.image);
                //image.setImageResource(R.drawable.);

                Button dialogButton = (Button) dialog.findViewById(R.id.done_popup_button);

                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            dialog.show();
            }
        });

        pauseButton = (ImageButton) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //undo when method exists            speechToTextService.pauseRecording();

            }
        });

        micButton = (ImageButton) findViewById(R.id.micButton);
        micButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             /* test if this works please  try {
                    speechToTextService.stopRecording();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } */
                if (go){
                    v.setBackgroundResource(R.drawable.ic_mic_none_2x);
                }
                else {
                    v.setBackgroundResource(R.drawable.ic_mic_2x);
                }
                go = !go;// reverse
            }
        });
    }


}
