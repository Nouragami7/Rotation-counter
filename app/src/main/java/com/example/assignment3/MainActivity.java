package com.example.assignment3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    static final String rotation_counter_key = "rotationCount";
    int counter = 0;
    TextView rotationCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotationCounterTextView = findViewById(R.id.rotationCounterTextView);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(rotation_counter_key);
            rotationCounterTextView.setText(String.valueOf(counter));
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ||
                newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            counter++;
            rotationCounterTextView.setText(String.valueOf(counter));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(rotation_counter_key, counter);
        super.onSaveInstanceState(outState);
    }
}
