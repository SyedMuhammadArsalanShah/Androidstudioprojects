package com.example.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
Button signupbt ,signinem;
    ImageView backimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();
        setanimiation();


    }
    private void init() {
        backimg = findViewById(R.id.back2);

    }

    private void setanimiation() {
        final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        backimg.setAnimation(zoomin);
        backimg.setAnimation(zoomout);
        zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                backimg.startAnimation(zoomin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                backimg.startAnimation(zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    public void signup(View view) {
        Intent intent=new Intent(MainMenu.this,One.class);
        intent.putExtra("email","Signup");
        startActivity(intent);

    }

    public void signin(View view) {
        Intent intent=new Intent(MainMenu.this,One.class);
        intent.putExtra("email","Email");
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
  }
