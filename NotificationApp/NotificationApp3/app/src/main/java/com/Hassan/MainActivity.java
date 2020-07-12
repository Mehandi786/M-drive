package com.Hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;
    Notification.BubbleMetadata bubbleMetadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        createNotificationChannel();
        createBubbleMetaData();
    }
    private void createNotificationChannel(){
        NotificationChannel notificationChannel = new NotificationChannel("1","channel1",NotificationManager.IMPORTANCE_LOW);
        notificationChannel.setAllowBubbles(true);
        notificationManager.createNotificationChannel(notificationChannel);
    }
    private void createBubbleMetaData(){
        Intent intent = new Intent(this,Bubble.class);
        bubbleMetadata = new Notification.BubbleMetadata.Builder()
                .setDesiredHeight(600)
                .setIcon(Icon.createWithResource(this,R.drawable.ic_launcher_background))
                .setIntent(PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT))
                .setAutoExpandBubble(true)
                .setSuppressNotification(true)
                .build();
    }
    public void Show4(View view){
        Person person = new Person.Builder()
                .setBot(true)
                .setName("person")
                .setImportant(true)
                .build();
        Notification.Builder builder = new Notification.Builder(this,"1")
                .setContentTitle("Bubble Notification")
                .setContentText("Bubble notification demo")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setBubbleMetadata(bubbleMetadata)
                .setAutoCancel(true)
                .addPerson(person);
        notificationManager.notify(1,builder.build());
    }
}
