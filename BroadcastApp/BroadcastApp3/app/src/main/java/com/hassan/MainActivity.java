package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_NAME = "SAI_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doBroadCast(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_NAME);
        sendBroadcast(intent);
        Log.d("MainActivity","Broadcasting done");
    }

    public void registerReciever(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_NAME);
        registerReceiver(new MyCustomReciever(),intentFilter);
        Log.d("MainActivity","Reciever registered");
    }
}