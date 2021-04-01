package com.example.livingseeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.livingseeds.ui.mainlocation.MainLocationFragment;

public class MainLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_location_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainLocationFragment.newInstance())
                    .commitNow();
        }
    }
}
