package com.hassan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReciever extends BroadcastReceiver {

    private static final String TAG = "CallReciever";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String state = bundle.getString(TelephonyManager.EXTRA_STATE);
        Log.d(TAG,state);
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String phonenumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.d(TAG,"Incoming call......"+phonenumber);
        }
    }
}