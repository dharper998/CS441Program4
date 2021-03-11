package com.example.cs441program4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataStorage data = DataStorage.getInstance();
    private boolean removing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.addItem("Horse");
        data.addItem("Cow");
        data.addItem("Camel");
        data.addItem("Sheep");
        data.addItem("Goat");

        recyclerView = findViewById(R.id.rview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter adapter = new CustomAdapter(data.getItems());
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CustomAdapter adapter = (CustomAdapter) recyclerView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    public void addItem(View view) {
        Intent addItemActivity = new Intent(getApplicationContext(), AddItemPage.class);
        startActivity(addItemActivity);
    }

    public void removeItems(View view){
        if(removing == false){
            removing = true;
            CustomAdapter adapter = (CustomAdapter) recyclerView.getAdapter();
            adapter.setRemoving(true);
        } else{
            removing = false;
            CustomAdapter adapter = (CustomAdapter) recyclerView.getAdapter();
            adapter.setRemoving(false);
        }

        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        if(removing == false){
            addButton.setVisibility(View.VISIBLE);
        } else{
            addButton.setVisibility(View.INVISIBLE);
        }
        int size = data.getItems().size();
        for(int i = 0; i<size; i++){
            View row = recyclerView.getLayoutManager().findViewByPosition(i);
            FloatingActionButton button = row.findViewById(R.id.floatingActionButton3);
            if(removing == true){
                button.setVisibility(View.VISIBLE);
            } else{
                button.setVisibility(View.INVISIBLE);
            }
        }
    }
}