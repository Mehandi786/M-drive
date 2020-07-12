package com.hassan;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hassan.R;


public class color extends Fragment {

    private static final String TAG = "ColorFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"In onAttach() of Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"In onCreateView() of Fragment");
        return inflater.inflate(R.layout.fragment_color,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"In onActivityCreated() of Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"In onStart() of Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"In onResume() of Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"In onPause() of Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"In onStop() of Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"In onDestroyView() of Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"In onDestroy() of Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"In onDetach() of Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"In onCreate() of Fragment");
    }
}