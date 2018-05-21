package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.innobles.internapp.Adapter.PartTimeAdapter;
import com.example.innobles.internapp.R;
import com.example.innobles.internapp.model.Datalist;

import java.util.ArrayList;

public class PartTimeJobs extends Fragment {
    private ListView jobs;
    private PartTimeAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_part_time_jobs, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Datalist> dataList = new ArrayList<>();
        jobs = getActivity().findViewById(R.id.part_time_list);

        dataList.add(new Datalist(getString(R.string.data_analysis), getString(R.string.data_desc), getString(R.string.analysis_timing), R.mipmap.data_intern,R.mipmap.dots_vertical));
        dataList.add(new Datalist(getString(R.string.staff_title), getString(R.string.staff_desc), getString(R.string.analysis_timing), R.mipmap.staff_intern,R.mipmap.dots_vertical));
        dataList.add(new Datalist(getString(R.string.web_title), getString(R.string.web_desc), getString(R.string.design_timing), R.mipmap.webdeveloper_intern,R.mipmap.dots_vertical));
        adapter = new PartTimeAdapter(getContext(), dataList);
        jobs.setAdapter(adapter);


    }
}
