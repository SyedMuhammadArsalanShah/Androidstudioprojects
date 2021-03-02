package com.example.classapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText pass;
    TextInputLayout emailEt;
    TextInputLayout passEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {

        email = findViewById(R.id.emailEt);
        pass = findViewById(R.id.password);
        emailEt=findViewById(R.id.emailTv);
        passEt=findViewById(R.id.passTv);
    }

    public void login(View view) {

        getdetails();

    }

    private void getdetails() {

        String mail = email.getText().toString();
        String pas = pass.getText().toString();

        if (mail.isEmpty()){
            emailEt.setError("email required");
        }else if(pas.isEmpty()){
            passEt.setError("pass required");

        }
        else {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);

            intent.putExtra("mail",mail);
            intent.putExtra("pass",pas);
            startActivity(intent);


        }


    }

    public void signup(View view) {


        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);


    }

    public void google(View view) {

        Toast.makeText(this, "google", Toast.LENGTH_SHORT).show();
    }

    public void twitter(View view) {



        Toast.makeText(this, "twitter", Toast.LENGTH_SHORT).show();
    }

    public void facebbook(View view) {



        Toast.makeText(this, "facebook", Toast.LENGTH_SHORT).show();


    }
}
