package com.example.livingseeds.ui.mainpubsub;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.livingseeds.R;

public class MainPubSubFragment extends Fragment {

    private MainPubSubViewModel mViewModel;

    public static MainPubSubFragment newInstance() {
        return new MainPubSubFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_pub_sub_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainPubSubViewModel.class);
        // TODO: Use the ViewModel
    }

}
