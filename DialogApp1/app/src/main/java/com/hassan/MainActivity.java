package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hassan.dialog.MyAlertDialog;
import com.hassan.dialog.MyLayoutDialog;
import com.hassan.dialog.MyListDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog1(View view) {
        MyAlertDialog dialog = new MyAlertDialog();
        dialog.show(getSupportFragmentManager(),"MyDialog1");
    }

    public void showDialog2(View view) {
        MyListDialog dialog = new MyListDialog();
        dialog.show(getSupportFragmentManager(),"MyDialog2");
    }

    public void showDialog3(View view) {
        MyLayoutDialog dialog = new MyLayoutDialog();
        dialog.show(getSupportFragmentManager(),"MyDialog3");
    }
}