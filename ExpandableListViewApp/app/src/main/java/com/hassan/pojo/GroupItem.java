package com.hassan.pojo;

import java.util.ArrayList;

public class GroupItem {

    private String name;
    private ArrayList<ChildItem> childItems = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildItem> getChildItems() {
        return childItems;
    }

    public void setChildItems(ArrayList<ChildItem> childItems) {
        this.childItems = childItems;
    }
}
