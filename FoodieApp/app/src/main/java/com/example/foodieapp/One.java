package com.example.foodieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.invoke.ConstantCallSite;

public class One extends AppCompatActivity {

    ConstraintLayout bgimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        init();
        animation();
        Bundle bundle = getIntent().getExtras();

    }

    private void animation() {

        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
    }

    private void init() {
        bgimage = findViewById(R.id.back3);

    }


    public void chef(View view) {
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("email");
        if (type.equals("Email")) {
            Intent log = new Intent(One.this, Cheflogin.class);
            startActivity(log);

        }

        if (type.equals("Signup")) {
            Intent Reg = new Intent(One.this, Chefreg.class);
            startActivity(Reg);
        }

    }


    public void cust(View view) {


        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("email");
        if (type.equals("Email")) {
            Intent log = new Intent(One.this,Login.class);
            startActivity(log);

        }

        if (type.equals("Signup")) {
            Intent Reg = new Intent(One.this,Registration.class);
            startActivity(Reg);
        }

    }

    public void deli(View view) {

        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("email");
        if (type.equals("Email")) {
            Intent log = new Intent(One.this, Dellogin.class);
            startActivity(log);

        }

        if (type.equals("Signup")) {
            Intent Reg = new Intent(One.this, DelRegistration.class);
            startActivity(Reg);
        }
    }

}
