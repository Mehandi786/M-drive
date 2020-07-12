package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.hassan.adapter.MyCustomAdapter;
import com.hassan.pojo.ChildItem;
import com.hassan.pojo.GroupItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyCustomAdapter myCustomAdapter;
    private ExpandableListView expandableListView;
    private ArrayList<GroupItem> groupItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        expandableListView = (ExpandableListView) findViewById(R.id.myELView);
        myCustomAdapter = new MyCustomAdapter(this,groupItems);
        expandableListView.setAdapter(myCustomAdapter);
    }

    private void loadData() {
        GroupItem groupItem = new GroupItem();
        groupItem.setName("Technology");

        ChildItem item1 = new ChildItem();
        item1.setSerialNo("1");
        item1.setName("Java");

        ChildItem item2 = new ChildItem();
        item2.setSerialNo("2");
        item2.setName(".Net");

        ChildItem item3 = new ChildItem();
        item3.setSerialNo("3");
        item3.setName("Android");

        ArrayList<ChildItem> childItems = new ArrayList<>();
        childItems.add(item1);
        childItems.add(item2);
        childItems.add(item3);

        groupItem.setChildItems(childItems);

        GroupItem groupItem2 = new GroupItem();
        groupItem2.setName("Hobbies");

        ChildItem myitem1 = new ChildItem();
        myitem1.setSerialNo("1");
        myitem1.setName("Dance");

        ChildItem myitem2 = new ChildItem();
        myitem2.setSerialNo("2");
        myitem2.setName("Singing");


        ArrayList<ChildItem> myChildItems = new ArrayList<>();
        myChildItems.add(myitem1);
        myChildItems.add(myitem2);

        groupItem2.setChildItems(myChildItems);

        groupItems.add(groupItem);
        groupItems.add(groupItem2);

    }
}