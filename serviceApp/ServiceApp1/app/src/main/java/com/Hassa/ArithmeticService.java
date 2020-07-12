package com.Hassa;



import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ArithmeticService extends Service {

    private static final String TAG = "ArithmeticService";

    public ArithmeticService() {
        Log.d(TAG,"ArithmeticService instantiated");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ArithmeticBinderService();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"In onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int op1 = intent.getIntExtra("op1",0);
        int op2 = intent.getIntExtra("op2",0);
        int result = op1 + op2;
        Log.d(TAG,"Sum is:"+result);
        return START_NOT_STICKY;
    }

    public void checkLogin() {
        Log.d(TAG,"In checkLogin()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"In onDestroy()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"In onunBind()");
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG,"In onRebind()");
    }

    public class ArithmeticBinderService extends Binder {
        ArithmeticService getService() {
            return ArithmeticService.this;
        }
    }
}
