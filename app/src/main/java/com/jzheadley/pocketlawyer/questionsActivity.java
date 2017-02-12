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

public class questionsActivity extends Activity{

    final Context context = this;
    private Button button;

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
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_launcher);

            }
        });
    }


}
