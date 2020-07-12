package com.Hassan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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
    public void Show3(View view){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1");
        builder.setContentTitle("Title1");
        builder.setContentText("welcome Md");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManagerCompat.notify(1,builder.build());

    }
    public void Show4(View view){
       NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1");
       builder.setContentTitle("Title2");
     builder.setContentText("How are You Md");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setStyle(new NotificationCompat.BigTextStyle()
        .bigText("fufuudytderwrwxykuoiughfncvbcfgfsrqzutiyyicuryrcwtewt"));

      //  builder.setStyle(new NotificationCompat.InboxStyle()
                        //  .addLine("Welcome to Android")
                         //  .addLine("hello")
                          //  .addLine("hi"));



        notificationManagerCompat.notify(2,builder.build());
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("1","channel1",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("It Contains news related notification");
            notificationManagerCompat.createNotificationChannel(notificationChannel);
        }
    }
}
