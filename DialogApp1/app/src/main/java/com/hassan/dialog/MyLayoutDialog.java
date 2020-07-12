package com.hassan.dialog;

import android.app.Dialog;
import android.os.Bundle;

import com.hassan.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyLayoutDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Authentication");
        builder.setView(R.layout.login_layout);
        return builder.create();
    }
}