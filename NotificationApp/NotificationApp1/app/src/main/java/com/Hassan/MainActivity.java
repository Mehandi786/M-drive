package com.Hassan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        NotificationChannel notificationChannel = new NotificationChannel("1","channel",NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("it content new related ");
        notificationManagerCompat.createNotificationChannel(notificationChannel);
        }
    }
    public void Show1(View view){

        PendingIntent pendingIntent;
        pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,gift.class),PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"c1")
                        .setTicker("Hello from notification")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification")
                .setContentIntent(pendingIntent)
                .setContentText("Click here");

               notificationManagerCompat.notify(1,builder.build());
    }
     public void Show2(View view){
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"c2")
                .setTicker("Hello from notification")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Progress")
                .setContentText("Click Here");
         //    Thread t1 = new Thread(new Runnable() {
          //       @Override
        //         public void run() {
        //             for (int i=10;i<=100;i+=1){
        //                 builder.setProgress(100,i,false);
       //                  if (i==100){
       //                      builder.setContentText("Progress completed");
        //                     builder.setProgress(0,0,false);
       //                      {
       //                          try {
       //                              Thread.sleep(2000);
       //                          }catch (InterruptedException e){}
       //                          notificationManagerCompat.notify(1,builder.build());

//
       //                      }
       //                  }
        //             }
        //         }
        //     })   ;
        //     t1.start();



     }

    }
