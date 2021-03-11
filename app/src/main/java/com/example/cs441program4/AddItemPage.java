package com.example.cs441program4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class AddItemPage extends AppCompatActivity {

    private DataStorage data = DataStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_page);
    }

    public void closeAddItemPage(View view){
        TextInputLayout input = findViewById(R.id.textInputLayout);
        String itemName = input.getEditText().getText().toString();
        data.addItem(itemName);
        finish();
    }
}