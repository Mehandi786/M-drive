package com.example.listevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner firstSpinner,secondSpinner;
    HashMap<String, List<String>> modelList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateModelList();
        firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        secondSpinner = (Spinner) findViewById(R.id.secondSpinner);
        MyFirstSpinnerListener myFirstSpinnerListener = new MyFirstSpinnerListener();
        firstSpinner.setOnItemSelectedListener(myFirstSpinnerListener);
    }

    private void populateModelList() {
        modelList.put("LG", Arrays.asList("LG01","LG02","LG03"));
        modelList.put("Samsung",Arrays.asList("S01","S02","S03"));
        modelList.put("Motorola",Arrays.asList("M01","M02","M03"));
        modelList.put("MI",Arrays.asList("MI01","MI02","MI03"));
    }

    private class MyFirstSpinnerListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            TextView textView = (TextView) view;
            Toast.makeText(MainActivity.this, "Selected item: "+textView.getText(), Toast.LENGTH_SHORT).show();
            List<String> itemModelList = MainActivity.this.modelList.get(textView.getText());
            ArrayAdapter arrayAdapter = new ArrayAdapter
                    (MainActivity.this,android.R.layout.simple_list_item_1,itemModelList);
            MainActivity.this.secondSpinner.setAdapter(arrayAdapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}