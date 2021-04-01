package com.example.livingseeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.livingseeds.ui.mainpubsub.MainPubSubFragment;

public class MainPubSub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pub_sub_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainPubSubFragment.newInstance())
                    .commitNow();
        }
    }
}
