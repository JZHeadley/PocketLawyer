package com.jzheadley.pocketlawyer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SettingsActivity extends BaseActivity {
    private static final String TAG = "SettingsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences preferences = getSharedPreferences("PocketLawyer", MODE_PRIVATE);
        ((EditText) findViewById(R.id.ethnicity_et)).setText(preferences.getString("ethnicity", ""));
        ((EditText) findViewById(R.id.username_et)).setText(preferences.getString("username", ""));
        if (preferences.getBoolean("isFemale", true)) {
            ((RadioGroup) findViewById(R.id.gender_radio_group)).getChildAt(1).setActivated(true);
        } else {
            ((RadioGroup) findViewById(R.id.gender_radio_group)).getChildAt(0).setActivated(true);

        }
    }

    public void onClick(View v) {
        SharedPreferences preferences = getSharedPreferences("PocketLawyer", MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        String ethnicity = ((EditText) findViewById(R.id.ethnicity_et)).getText().toString();
        String username = ((EditText) findViewById(R.id.username_et)).getText().toString();
        boolean gender = (((RadioGroup) findViewById(R.id.gender_radio_group)).getCheckedRadioButtonId() == R.id.female);
        Log.d(TAG, "onClick: Gender:" + gender);
        edit.putBoolean("isFemale", gender);
        edit.putString("ethnicity", ethnicity);
        edit.putString("username", username);
        edit.apply();
        finish();
    }
}
