package com.example.dilogboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LayoutInflater layoutInflater;
    View layoutview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutInflater = getLayoutInflater();
        layoutview = layoutInflater.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.rootToastLayout));
    }
    public void  showCustomToast(View view){
        TextView textView = (TextView) layoutview.findViewById(R.id.displayTV);
        textView.setText("Welcome to Android");
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT,0,0);
        toast.setView(layoutview);
        toast.show();
    }

}
