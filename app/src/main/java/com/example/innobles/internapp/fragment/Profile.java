package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.innobles.internapp.R;

public class Profile extends Fragment {
    Button education, exp, skill;
    boolean check = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.edu_infoContainer, new Education());
        ft.commit();
        return inflater.inflate(R.layout.fragment_profile, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.Title_profile));
        education = getActivity().findViewById(R.id.education);
        exp = getActivity().findViewById(R.id.exp);
        skill = getActivity().findViewById(R.id.skill);

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Education educationFragment = new Education();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.edu_infoContainer, educationFragment);
                ft.commit();
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Experiance experiance = new Experiance();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.edu_infoContainer, experiance);
                ft.commit();

            }
        });
        skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skills skills = new Skills();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.edu_infoContainer, skills);
                ft.commit();
            }
        });

    }

}

