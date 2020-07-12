package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class theatre extends AppCompatActivity {

    HashMap<String, List<String>> theatreMap = new HashMap<>();

    ListView theatreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);
        populateTheatresForMovies();
        theatreListView = (ListView) findViewById(R.id.theatreList);
        String movieName = getIntent().getStringExtra("MovieName");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,theatreMap.get(movieName));
        theatreListView.setAdapter(arrayAdapter);
    }

    private void populateTheatresForMovies() {
        theatreMap.put("Movie1", Arrays.asList("Theatre-1","Theatre-2"));
        theatreMap.put("Movie2", Arrays.asList("Theatre-2","Theatre-4","Theatre-5","Theatre-6"));
        theatreMap.put("Movie3", Arrays.asList("Theatre-8"));
    }
}