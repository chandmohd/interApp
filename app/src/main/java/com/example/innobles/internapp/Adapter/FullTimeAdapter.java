package com.example.innobles.internapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.innobles.internapp.R;
import com.example.innobles.internapp.fragment.Apply;
import com.example.innobles.internapp.fragment.FullTimeJobs;
import com.example.innobles.internapp.model.Datalist;

import java.util.ArrayList;
import java.util.List;

public class FullTimeAdapter extends ArrayAdapter<Datalist> {
    private Context mContext;
    private FullTimeJobs mFragment;
    private List<Datalist> datalists = new ArrayList<>();

    public FullTimeAdapter(@NonNull Context context, ArrayList<Datalist> list) {
        super(context, 0, list);
        this.mContext = context;
        this.datalists = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(mContext).inflate(R.layout.full_time_datalist, parent, false);
        }
        Datalist currentJob = datalists.get(position);

        ImageView ivImage = listView.findViewById(R.id.part_img);
        ivImage.setImageResource(currentJob.getJobImg());

        final ImageView ivDots = listView.findViewById(R.id.dot_img);
        ivDots.setImageResource(currentJob.getIcon());

        TextView tvJobTitle = listView.findViewById(R.id.part_text_title);
        tvJobTitle.setText(currentJob.getJobTitle());

        TextView tvJobSubTitle = listView.findViewById(R.id.part_text_sub_title);
        tvJobSubTitle.setText(currentJob.getJobDesc());

        TextView tvJobTiming = listView.findViewById(R.id.job_timing);
        tvJobTiming.setText(currentJob.getJobTiming());


        ivDots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popup = new PopupMenu(mContext, ivDots);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        return (id == R.id.share || id == R.id.addtowishlist || id == R.id.report) ? true : true;
                    }
                });
            }
        });

        Button btnApply = listView.findViewById(R.id.part_btn_apply);
        btnApply.setText("Apply");
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Apply());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return listView;

    }
}
