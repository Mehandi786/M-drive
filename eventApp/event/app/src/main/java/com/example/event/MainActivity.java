package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button clickButton,exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       clickButton = (Button) findViewById(R.id.ClickBtn);
       exitButton = (Button) findViewById(R.id.ExitBtn);
        MyButtonListener myButtonListener = new MyButtonListener();
       clickButton.setOnClickListener(myButtonListener);
       exitButton.setOnClickListener(myButtonListener);
    }
  private class MyButtonListener implements View.OnClickListener{ //if you click on "click Me" button
      @Override
      public void onClick(View View) {
          if (View.getId() == R.id.ClickBtn){
              clickButton.setEnabled(false);
              exitButton.setEnabled(true);

          }else {// if you click on "Exit" button
              finish();// to destroy activity

          }

      }
  }
}
