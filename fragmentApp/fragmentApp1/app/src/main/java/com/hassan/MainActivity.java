package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hassan.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"In onCreate() of Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"In onStart() of Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"In onStop() of Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"In onDestroy() of Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"In onPause() of Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"In onResume() of Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"In onRestart() of Activity");
    }
}