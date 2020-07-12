package com.hassan;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReciever";

    public MyReceiver() {
        Log.d(TAG, "MyReciever instantiated");
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onRecieved() invoked");
    }
}
