package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Play,Pause,Stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Play = (Button)findViewById(R.id.play);
        Pause = (Button)findViewById(R.id.pause);
        Stop = (Button)findViewById(R.id.stop);

        ButtonListener buttonListener = new ButtonListener();
        Play.setOnClickListener(buttonListener);
        Pause.setOnClickListener(buttonListener);
        Stop.setOnClickListener(buttonListener);
        mediaPlayer = MediaPlayer.create(this,R.raw.sea);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view.getId() == Play.getId()){
              mediaPlayer.start();
            }else if (view.getId() == Pause.getId()){
             mediaPlayer.pause();
            }else{
             mediaPlayer.stop();
            }
        }
    }
}
