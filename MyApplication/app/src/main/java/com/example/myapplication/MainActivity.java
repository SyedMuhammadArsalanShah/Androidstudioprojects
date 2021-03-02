package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText ftname;
 EditText ltname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           ftname=findViewById(R.id.fname);
           ltname=findViewById(R.id.lname);

    }

    public void Login(View view) {
        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }


    public void signup(View view) {
        String fname =ftname.getText().toString();
        String lname =ltname.getText().toString();
        Toast.makeText(this, (fname+lname), Toast.LENGTH_SHORT).show();

    }
}
