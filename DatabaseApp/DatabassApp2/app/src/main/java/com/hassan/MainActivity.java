package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et);
        try {
            fileOutputStream = openFileOutput("userdata", MODE_PRIVATE);
        }catch (Exception e1){
            Log.d("MainActivity",e1.getMessage());
        }

    }
    public void  saveClicked(View view){
        String data = editText.getText().toString();
        try {
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this,"Data Saved....!",Toast.LENGTH_LONG).show();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}