package com.example.innobles.internapp.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.innobles.internapp.Adapter.FullTimeAdapter;
import com.example.innobles.internapp.R;
import com.example.innobles.internapp.model.Datalist;

import java.util.ArrayList;

public class FullTimeJobs extends Fragment {
    private ListView listView;
    private FullTimeAdapter fullTimeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_time_jobs, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = getActivity().findViewById(R.id.full_time_list);
        ArrayList<Datalist> datalists = new ArrayList<>();

        datalists.add(new Datalist(getString(R.string.marketInter), getString(R.string.marketIntern_desc), getString(R.string.marketIntern_timing),
                R.mipmap.market_intern, R.mipmap.dots_vertical));
        datalists.add(new Datalist(getString(R.string.design_title), getString(R.string.design_desc), getString(R.string.design_timing),
                R.mipmap.design_inter, R.mipmap.dots_vertical));
        datalists.add(new Datalist(getString(R.string.fashion_title), getString(R.string.fashion_desc), getString(R.string.design_timing),
                R.mipmap.fashion_intern, R.mipmap.dots_vertical));
        datalists.add(new Datalist(getString(R.string.eng_title), getString(R.string.eng_desc), getString(R.string.eng_timing),
                R.mipmap.engineering_intern, R.mipmap.dots_vertical));

        fullTimeAdapter = new FullTimeAdapter(this.getActivity(), datalists);
        listView.setAdapter(fullTimeAdapter);
    }

}
