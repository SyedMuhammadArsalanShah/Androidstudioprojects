package com.example.foodieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodieapp.SendNotification.Token;
import com.example.foodieapp.customerFoodPanel.CustomerCartFragment;
import com.example.foodieapp.customerFoodPanel.CustomerHomeFragment;
import com.example.foodieapp.customerFoodPanel.CustomerOrdersFragment;
import com.example.foodieapp.customerFoodPanel.CustomerProfileFragment;
import com.example.foodieapp.customerFoodPanel.CustomerTrackFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;


public class CustBNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_bnavigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name = getIntent().getStringExtra("PAGE");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (name != null) {
            if (name.equalsIgnoreCase("Homepage")) {
                loadFragment(new CustomerHomeFragment());
            } else if (name.equalsIgnoreCase("Preparingpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("Preparedpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("DeliverOrderpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("ThankYoupage")) {
                loadFragment(new CustomerHomeFragment());
            }
        } else {
            loadFragment(new CustomerHomeFragment());
        }
    }

    private void UpdateToken() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Token token = new Token(refreshToken);
        FirebaseDatabase.getInstance().getReference("Tokens").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.cust_Home:
                fragment = new CustomerHomeFragment();
                break;


            case R.id.cart:
                fragment = new CustomerCartFragment();
                break;

            case R.id.Cust_order:
                fragment = new CustomerOrdersFragment();
                break;

            case R.id.track:
                fragment = new CustomerTrackFragment();
                break;

            case R.id.cust_profile:
                fragment = new CustomerProfileFragment();
                break;

        }
        return loadFragment(fragment);
    }
}
