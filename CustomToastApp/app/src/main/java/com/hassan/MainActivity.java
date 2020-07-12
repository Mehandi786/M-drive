package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LayoutInflater layoutInflater;
    View layoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutInflater = getLayoutInflater();
        layoutView = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.rootToastLayout));

    }

    public void showCustomToast(View view) {

        TextView textView = (TextView) layoutView.findViewById(R.id.displayTV);
        textView.setText("Welcome to android");
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        toast.setView(layoutView);
        toast.show();
    }
}