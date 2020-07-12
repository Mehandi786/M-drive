package com.hassan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this,MyAudioService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(this,MyAudioService.class);
        intent.setAction("stop");
        startService(intent);
    }
}