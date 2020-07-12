package com.hassan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        createNotificationChannel();

    }
    private void createNotificationChannel(){
        NotificationChannel notificationChannel = new NotificationChannel("1","channel1", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManagerCompat.createNotificationChannel(notificationChannel);
    }
    public void Show1(View view){
        Notification.Builder builder = new Notification.Builder(this,"1")
                .setContentText("Notification badge demo")
                .setContentTitle("Notification Badge")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL);

        notificationManagerCompat.notify(1,builder.build());
    }
}
