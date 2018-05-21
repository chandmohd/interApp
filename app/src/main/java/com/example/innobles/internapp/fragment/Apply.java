package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.innobles.internapp.R;

public class Apply extends Fragment {
    public static final String TAG = "Apply";
    Button applyNow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Apply");
        return inflater.inflate(R.layout.fragment_apply, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        applyNow = (Button) getActivity().findViewById(R.id.apply_now);
        applyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ApplyHome();
                if (fragment != null) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.container, fragment);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });
    }
}
