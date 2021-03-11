package com.example.cs441program4;

import java.util.ArrayList;

public class DataStorage {
    private ArrayList<String> items = new ArrayList<String>();
    private static final DataStorage data = new DataStorage();
    private DataStorage(){};
    public static DataStorage getInstance() {
        return data;
    }

    public void addItem(String name){
        this.items.add(name);
    }

    public void removeItem(int pos){
        items.remove(pos);
    }

    public ArrayList<String> getItems(){
        return items;
    }
}
