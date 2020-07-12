package com.hassan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayText;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = (TextView) findViewById(R.id.displayTV);
        if(savedInstanceState != null) {
            int currentCount = savedInstanceState.getInt("Count");
            count = currentCount;
            displayText.setText(""+currentCount);
        }

        Log.d("MainActivity","onCreate() of MainActivity");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count",count);
    }

    public void incrementValue(View view) {
        count++;
        displayText.setText(""+count);
    }
}