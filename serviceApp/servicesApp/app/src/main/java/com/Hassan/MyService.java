package com.Hassan;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
        Log.d(TAG, "Hello Service Initialized");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void processLogic(){
        startThread();
    }
    private void startThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    Log.d(TAG, "Hello Service:"+i);
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
                MyService.this.stopSelf();
            }
        }).start();

    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"In onStartCommond");
        processLogic();
        return START_NOT_STICKY;
    }
    @Override
    public void onCreate() {
        Log.d(TAG,"In onCreate Method");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"In onDestroy Method");
        super.onDestroy();
    }
}
