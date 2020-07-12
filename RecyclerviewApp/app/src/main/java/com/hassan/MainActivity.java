package com.hassan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hassan.adapter.MyCustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mobileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(getApplicationContext(),mobileList);
        recyclerView.setAdapter(myCustomAdapter);
    }

    private void loadData() {
        mobileList.add("LGX01");
        mobileList.add("MIA1");
        mobileList.add("SamsungA1");
        mobileList.add("OneX01");
        mobileList.add("VUA1");
        mobileList.add("SamsungA2");
    }
}