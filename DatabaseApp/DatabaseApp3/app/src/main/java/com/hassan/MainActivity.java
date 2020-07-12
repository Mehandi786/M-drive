package com.hassan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    FileWriter fileWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.et);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }else {
            setupFileInSDCard();
        }


    }

    private void checkPermission() {
        int status = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(status == PackageManager.PERMISSION_GRANTED) {
            setupFileInSDCard();
        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    private void setupFileInSDCard() {
        File externalStorage = Environment.getExternalStorageDirectory();
        File myFolder = new File(externalStorage,"MyFiles");
        myFolder.mkdir();
        try {
            fileWriter = new FileWriter(myFolder.getAbsolutePath() + "/myfile.txt");
        }catch (Exception e1) {e1.printStackTrace();}
    }

    public void saveClicked(View view) {
        String data = editText.getText().toString();
        try {
            fileWriter.write(data);
            fileWriter.close();
            editText.setText("");
            Toast.makeText(this,"Data saved",Toast.LENGTH_LONG).show();
        }catch (Exception e1) { e1.printStackTrace();}
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupFileInSDCard();
        }
    }
}