package com.hassan;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyAudioService extends Service {

    PendingIntent previousIntent,playIntent,nextIntent;

    public MyAudioService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }
        Intent intent1 = new Intent(this,MyAudioService.class);
        intent1.setAction("previous");
        Intent intent2 = new Intent(this,MyAudioService.class);
        intent2.setAction("play");
        Intent intent3 = new Intent(this,MyAudioService.class);
        intent3.setAction("next");
        previousIntent = PendingIntent.getService(this,0,intent1,0);
        playIntent = PendingIntent.getService(this,0,intent2,0);
        nextIntent = PendingIntent.getService(this,0,intent3,0);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void createNotificationChannel() {
        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel("1","channel1", NotificationManager.IMPORTANCE_LOW);
        }
        NotificationManagerCompat.from(this).createNotificationChannel(notificationChannel);
    }

    private void createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1")
                .setContentTitle("Play Music")
                .setTicker("Music Player")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setOngoing(true)
                .addAction(R.drawable.previous,"Previous",previousIntent)
                .addAction(R.drawable.play,"Play",playIntent)
                .addAction(R.drawable.next,"Stop",nextIntent);

        startForeground(1,builder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotification();
        if(intent.getAction() != null) {
            if (intent.getAction().equals("previous")) {
                Log.d("MyAudioService", "Clicked on previous");
            } else if (intent.getAction().equals("play")) {
                Log.d("MyAudioService", "Clicked on play");
            } else if(intent.getAction().equals("next")){
                Log.d("MyAudioService", "Clicked on next");
            }else {
                stopForeground(true);
                stopSelf();
            }
        }
        return START_NOT_STICKY;
    }
}