package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView nameTv;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameTv=findViewById(R.id.nameTv);
        imageView=findViewById(R.id.imageView);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int image=bundle.getInt("image");
        nameTv.setText(name);
        imageView.setImageResource(image);

    }
}
