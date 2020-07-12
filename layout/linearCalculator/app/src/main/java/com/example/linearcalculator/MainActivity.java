package com.example.linearcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("In onCreate()......");
    }
    @Override
    protected void onStart(){
        super.onStart();
        System.out.println("In onStart()......");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        System.out.println("In onRestart()......");
    }
    @Override
    protected void onResume(){
        super.onResume();
        System.out.println("In onResume()......");
    }
    @Override
    protected void onPause(){
        super.onPause();
        System.out.println("In onPause()......");
}
    @Override
    protected void onStop(){
        super.onStop();
        System.out.println("In onStop()......");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.out.println("In onDestroy()......");
    }
}
