package com.example.broadcastapp2;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CheckPower extends BroadcastReceiver {

    private static final String TAG = "CheckPower";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context,"Power connnected",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context,"Power disconnnected",Toast.LENGTH_LONG).show();
        }
    }
}
