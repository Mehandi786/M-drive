package com.Hassa;



import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ArithmeticService arithmeticService;
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(getApplicationContext(), ArithmeticService.class);
        intent.putExtra("op1",100);
        intent.putExtra("op2",200);
    }

    public void bindWithService(View view) {
        startService(intent);
        bindService(intent,mService,BIND_AUTO_CREATE);
    }

    public void unBindWithService(View view) {
        unbindService(mService);
        stopService(intent);
    }

    public void doLogin(View view) {
        if(status) {
            arithmeticService.checkLogin();
        }else {
            Log.d("MainActivity","Cannot login, service not connected");
        }
    }

    private ServiceConnection mService = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ArithmeticService.ArithmeticBinderService arithmeticBinderService = (ArithmeticService.ArithmeticBinderService) iBinder;
            arithmeticService = arithmeticBinderService.getService();
            status=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("MainActivity","service disconnected");
            status=false;
        }


    };
}
