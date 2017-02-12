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

import com.jzheadley.pocketlawyer.controller.Controller;

public class questionsActivity extends Activity implements View.OnClickListener {

    final Context context = this;
    boolean go = false;
    Dialog dialog = null;
    ImageButton micButton;
    ImageButton pauseButton;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        pauseButton = (ImageButton) findViewById(R.id.pauseButton);
        micButton = (ImageButton) findViewById(R.id.micButton);
        pauseButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v ){
              //  speechToTextService.pauseRecording();

            }
        });
        micButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
             //   SpeechToTextService.stopRecording();

                if (go) {
                    v.setBackgroundResource(R.drawable.ic_mic_2x);
                }
                else{
                    v.setBackgroundResource(R.drawable.ic_mic_none_2x);
                }
                go = !go;

                }

        });

    }

    private void displayDialog(String title, String text, int layoutID) {
        dialog = new Dialog(context);
        dialog.setContentView(layoutID);
        dialog.setTitle(title);
// TODO: Find out why title doesn't appear 
        TextView textView = (TextView) dialog.findViewById(R.id.text);
        textView.setText(text);

        Button dialogButton = (Button) dialog.findViewById(R.id.done_popup_button);

        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                dialog = null;
            }
        });
        dialog.show();
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scenario1:
                if(dialog!=null){
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("search");
                displayDialog("Scenario1",Controller.getInstance().getInterventionText("search"), R.layout.scenario1);
                break;
            case R.id.scenario2:
                if(dialog!=null){
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("detained");
                displayDialog("Scenario2",Controller.getInstance().getInterventionText("detained"), R.layout.scenario2);
                break;
            case R.id.scenario3:
                if(dialog!=null){
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("why");
                displayDialog("Scenario3",Controller.getInstance().getInterventionText("why"), R.layout.scenario3);
                break;
            case R.id.scenario4:
                if(dialog!=null){
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("cooperate");
                displayDialog("Scenario4",Controller.getInstance().getInterventionText("cooperate"), R.layout.scenario4);
                break;
        }

    }


}
