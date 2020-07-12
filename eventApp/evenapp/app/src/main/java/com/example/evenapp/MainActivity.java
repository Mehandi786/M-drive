package com.example.evenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox androidCB,javaCB,iosCB;
    RadioButton maleRB,femaleRB;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidCB = (CheckBox) findViewById(R.id.androidCB);
        javaCB = (CheckBox) findViewById(R.id.javaCB);
        iosCB = (CheckBox) findViewById(R.id.iosCB);
        displayText = (TextView) findViewById(R.id.displayTV);
        maleRB = (RadioButton) findViewById(R.id.maleRB);
        femaleRB = (RadioButton) findViewById(R.id.femaleRB);
    }

    public void submitClicked(View view) {

        displayText.setText("");
        if(androidCB.isChecked()) {
            displayText.append("Android Selected \n");
            androidCB.setChecked(false);
        }
        if(javaCB.isChecked()) {
            displayText.append("Java Selected \n");
            javaCB.setChecked(false);
        }
        if(iosCB.isChecked()) {
            displayText.append("IOS Selected \n");
            iosCB.setChecked(false);
        }
        if(maleRB.isChecked()){
            displayText.append("Male Selected \n");
            maleRB.setChecked(false);
        }
        if(femaleRB.isChecked()){
            displayText.append("Female Selected \n");
            femaleRB.setChecked(false);
        }
    }
}