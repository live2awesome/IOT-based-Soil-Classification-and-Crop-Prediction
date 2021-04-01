package com.example.livingseeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.livingseeds.ui.mainrest.MainRestFragment;

public class MainRest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_rest_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainRestFragment.newInstance())
                    .commitNow();
        }
    }
}
