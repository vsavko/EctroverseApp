package com.example.ectroverseapp.forums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ectroverseapp.R;

public class ForumsFragment extends Fragment {

    private ForumsViewModel forumsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        forumsViewModel =
                ViewModelProviders.of(this).get(ForumsViewModel.class);
        View root = inflater.inflate(R.layout.forums, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        final TextView heading = getActivity().findViewById(R.id.currentMenuSelectedMain);

       // final CollapsingToolbarLayout collapsingToolbar =
        //        (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapseBarLayout);


        forumsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                heading.setText(R.string.menu_forums);
                textView.setText(s);
                //collapsingToolbar.setTitle(s);
            }
        });
        return root;
    }
}