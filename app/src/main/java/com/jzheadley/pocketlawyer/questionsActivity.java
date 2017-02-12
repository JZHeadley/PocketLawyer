package com.jzheadley.pocketlawyer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class questionsActivity extends Activity {

    final Context context = this;
    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        button = (Button) findViewById(R.id.scenario1);

        //add button listener
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //custom dialog

            }
        });
    }

    private void displayDialog(String title, String text) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.scenario1);
        dialog.setTitle(title);

        TextView textView = (TextView) dialog.findViewById(R.id.text);
        textView.setText(text);

        Button dialogButton = (Button) dialog.findViewById(R.id.done_popup_button);

        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scenario1:
                displayDialog("Scenario1",getString(R.string.scenario1_text));
                break;
            case R.id.scenario2:
                displayDialog("Scenario2",getString(R.string.scenario2_text));
                break;
            case R.id.scenario3:
                displayDialog("Scenario3",getString(R.string.scenario3_text));
                break;
        }
    }
}
