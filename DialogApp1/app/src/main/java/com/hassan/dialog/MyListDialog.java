package com.hassan.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hassan.R;


import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyListDialog extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("List Dialog");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setItems(R.array.mobileBrands,(dialogInterface,index) -> {
            //Log.d("MyListDialog","Item clicked");
            Toast.makeText(getContext(),"Item Clicked",Toast.LENGTH_LONG).show();
        });
        //builder.setItems(R.array.mobileBrands, null);
        return builder.create();
    }
}
