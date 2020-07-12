package com.hassan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hassan.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyCustomAdapter extends RecyclerView.Adapter {

    ArrayList<String> mobileList;
    Context context;

    public MyCustomAdapter(Context context, ArrayList<String> mobileList) {
        this.context = context;
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Log.d("Recycler: ","In onCreateViewHolder");
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.mobileName.setText(mobileList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, mobileList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("Recycler: ","In onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mobileName;

        public MyViewHolder(View view) {
            super(view);
            mobileName = (TextView) view.findViewById(R.id.displayTV);
        }
    }
}