package com.example.broadcastapp2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CheckPower checkPower;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPower = new CheckPower();
    }

    public void registerReciever(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(checkPower,intentFilter);
        Log.d(TAG,"Reciever registered....!");
    }

    public void unRegisterReciever(View view) {
        unregisterReceiver(checkPower);
        Log.d(TAG,"Reciever unregistered....!");
    }
}
