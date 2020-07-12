package com.hassan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hassan.R;
import com.hassan.pojo.ChildItem;
import com.hassan.pojo.GroupItem;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<GroupItem> groupItems;

    private static final String TAG = "MyCustomAdapter";

    public MyCustomAdapter(Context context,ArrayList<GroupItem> groupItems) {
        this.context = context;
        this.groupItems = groupItems;
    }

    @Override
    public int getGroupCount() {
        Log.d(TAG,"In getGroupCount");
        return groupItems.size();
    }

    @Override
    public int getChildrenCount(int i) {

        Log.d(TAG, "In getChildrenCount");
        return groupItems.get(i).getChildItems().size();
    }

    @Override
    public Object getGroup(int i) {

        Log.d(TAG,"In getGroup");
        return groupItems.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Log.d(TAG, "In getChild");
        return groupItems.get(groupPosition).getChildItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {

        Log.d(TAG,"In getGroupId");
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        Log.d(TAG,"In getChildId");
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        Log.d(TAG,"In hasStableId");
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        Log.d(TAG,"In getGroupView");
        GroupItem groupItem = (GroupItem) getGroup(groupPosition);
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.group_items, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.groupItem);
        textView.setText(groupItem.getName());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        Log.d(TAG, "In getChildView");
        ChildItem childItem= (ChildItem) getChild(groupPosition,childPosition);
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_items, null);
        }
        TextView snoTV = (TextView) view.findViewById(R.id.sNo);
        snoTV.setText(childItem.getSerialNo());
        TextView contentTV= (TextView) view.findViewById(R.id.childItem);
        contentTV.setText(childItem.getName());

        return view;



    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        Log.d(TAG,"isChildSelectable");
        return true;
    }
}
