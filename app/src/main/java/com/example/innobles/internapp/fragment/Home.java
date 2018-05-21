package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.innobles.internapp.R;

public class Home extends Fragment implements View.OnClickListener {
    Button fullTime, partTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getFragmentManager().beginTransaction().replace(R.id.home_container, new FullTimeJobs()).commit();
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.Title_home));
        fullTime = getActivity().findViewById(R.id.btn_full_time);
        partTime = getActivity().findViewById(R.id.btn_part_time);
        fullTime.setOnClickListener(this);
        partTime.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_full_time:
                getFragmentManager().beginTransaction().replace(R.id.home_container, new FullTimeJobs()).commit();
                break;
            case R.id.btn_part_time:
                getFragmentManager().beginTransaction().replace(R.id.home_container, new PartTimeJobs()).commit();
                break;
        }

    }
}
