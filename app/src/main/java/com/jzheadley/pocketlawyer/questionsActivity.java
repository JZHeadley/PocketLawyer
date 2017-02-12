package com.jzheadley.pocketlawyer;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jzheadley.pocketlawyer.controller.Controller;
import com.jzheadley.pocketlawyer.data.services.SpeechToTextService;

public class questionsActivity extends AppCompatActivity {

    final Context context = this;
    boolean go = false;
    Dialog dialog = null;
    ImageButton micButton;
    ImageButton pausePlayButton;
    private SpeechToTextService speechToTextService;
    private Controller controller;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        pausePlayButton = (ImageButton) findViewById(R.id.pauseButton);
        speechToTextService = new SpeechToTextService();
        controller = Controller.getInstance();
        controller.startInteraction();
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scenario1:
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("search");
                displayDialog("Scenario1", Controller.getInstance().getInterventionText("search"), R.layout.scenario1);
                break;
            case R.id.scenario2:
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("detained");
                displayDialog("Scenario2", Controller.getInstance().getInterventionText("detained"), R.layout.scenario2);
                break;
            case R.id.scenario3:
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("ticket");
                displayDialog("Scenario3", Controller.getInstance().getInterventionText("ticket"), R.layout.scenario3);
                break;
            /*case R.id.scenario4:
                if(dialog!=null){
                    dialog.dismiss();
                    dialog = null;
                }
                Controller.getInstance().trigger("cooperate");
                displayDialog("Scenario4",Controller.getInstance().getInterventionText("cooperate"), R.layout.scenario4);
                break;*/
            // displayDialog("Scenario4", Controller.getInstance().getInterventionText("cooperate"), R.layout.scenario4);
            // break;
            case R.id.pauseButton:
                boolean paused = false;
                if (!paused) {
                    view.setBackground(getDrawable(R.drawable.ic_pause));
                    try {
                        controller.getExecutive().pauseInteraction();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    view.setBackground(getDrawable(R.drawable.ic_play_arrow));
                    try {
                        controller.getExecutive().pauseInteraction();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }

    }


}
