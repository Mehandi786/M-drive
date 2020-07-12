package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesList = (ListView) findViewById(R.id.moviesList);
        MyMoviesListListener myMoviesListListener = new MyMoviesListListener();
        moviesList.setOnItemClickListener(myMoviesListListener);
    }

    public void itemSelected(View view) {
        Toast.makeText(this, "Item selected", Toast.LENGTH_SHORT).show();
    }

    private class MyMoviesListListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, "Item selected", Toast.LENGTH_SHORT).show();
            TextView textView = (TextView) view;
            Intent intent = new Intent(MainActivity.this,theatre.class);
            intent.putExtra("MovieName",textView.getText());
            startActivity(intent);
        }
    }
}