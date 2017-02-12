package com.jzheadley.pocketlawyer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.jzheadley.pocketlawyer.controller.Controller;

public class questionsActivity extends Activity implements View.OnClickListener {

    Dialog dialog = null;
    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

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

    @Override
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
                displayDialog("Scenario2",getString(R.string.scenario2_text), R.layout.scenario2);
                break;
            case R.id.scenario3:
                displayDialog("Scenario3",getString(R.string.scenario3_text), R.layout.scenario3);
                break;
        }
    }
}
