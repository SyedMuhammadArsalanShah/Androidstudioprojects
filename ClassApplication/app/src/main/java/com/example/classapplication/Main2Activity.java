package com.example.classapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView email;
    TextView pas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

    }

    private void init() {
        email=findViewById(R.id.fnametv);
        pas=findViewById(R.id.lnametv);
        Bundle bundle=getIntent().getExtras();

        String mail=bundle.getString("mail");
        String pass=bundle.getString("pass");

        email.setText(mail);
        pas.setText(pass);

    }



}
