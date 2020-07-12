package com.hassan.dialog;



import android.app.Dialog;
import android.os.Bundle;

import com.hassan.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyAlertDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Alert");
        builder.setMessage("Welcome dialog box");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setPositiveButton("Ok",null);
        builder.setNegativeButton("Cancel",null);
        return builder.create();
    }
}