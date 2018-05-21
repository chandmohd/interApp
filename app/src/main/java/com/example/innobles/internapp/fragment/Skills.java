package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.innobles.internapp.R;

import java.util.ArrayList;
import java.util.List;

public class Skills extends Fragment {
    TextView lang, experiance, lan, lan_yr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skill, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lang = getActivity().findViewById(R.id.languages);
        experiance = getActivity().findViewById(R.id.experiance);
        lan = getActivity().findViewById(R.id.lan);
        lan_yr = getActivity().findViewById(R.id.lan_yr);
        List<String> languages = new ArrayList<>();
        List<String> exp = new ArrayList<>();

        //adding languages dynamically
        languages.add("C");
        languages.add("J2ee");
        languages.add("Spring");
        languages.add("Struts2");
        languages.add("HTML");
        languages.add("CSS");
        languages.add("javaScript");
        languages.add("Jquery");

        //adding languages expericance dynamically
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");
        exp.add("1yr 6mon");

        for (String item : languages) {
            lan.setText(lan.getText() + "\n" + item);
        }
        for (String item : exp) {
            lan_yr.setText(lan_yr.getText() + "\n" + item);
        }
    }
}
