package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView userList;
    Customadapter adapter;
    String[] name = {"arsalan", "mehrab", "raza"};
    int[] image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = findViewById(R.id.customList);
        adapter = new Customadapter(MainActivity.this, name, image);
        userList.setAdapter(adapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String namei = name[position];
                int imagei = image[position];
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name",namei);
                intent.putExtra("image",imagei);
                startActivity(intent);
            }
        });


    }
}
