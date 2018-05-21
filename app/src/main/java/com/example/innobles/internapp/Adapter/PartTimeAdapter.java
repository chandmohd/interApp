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
import com.example.innobles.internapp.model.Datalist;

import java.util.ArrayList;
import java.util.List;

public class PartTimeAdapter extends ArrayAdapter<Datalist> {
    private Context mcontext;
    private List<Datalist> datalist = new ArrayList<>();

    public PartTimeAdapter(@NonNull Context context, ArrayList<Datalist> list) {
        super(context, 0, list);
        this.mcontext = context;
        this.datalist = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mView = convertView;
        if (mView == null) {
            mView = LayoutInflater.from(mcontext).inflate(R.layout.part_time_datalist, parent, false);
        }
        Datalist currentJob = datalist.get(position);

        ImageView ivImage = mView.findViewById(R.id.part_img);
        ivImage.setImageResource(currentJob.getJobImg());

        final ImageView ivDots = mView.findViewById(R.id.part_dot_img);
        ivDots.setImageResource(currentJob.getIcon());

        ivDots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(mcontext, ivDots);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        return (id == R.id.addtowishlist || id == R.id.share || id == R.id.report) ? true : true;
                    }
                });
            }
        });

        TextView tvTitle = mView.findViewById(R.id.part_text_title);
        tvTitle.setText(currentJob.getJobTitle());

        TextView tvDesc = mView.findViewById(R.id.part_text_sub_title);
        tvDesc.setText(currentJob.getJobDesc());

        TextView tvTiming = mView.findViewById(R.id.part_job_timing);
        tvTiming.setText(currentJob.getJobTiming());

        Button tvApply = mView.findViewById(R.id.part_btn_apply);
        tvApply.setText("Apply");
        tvApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = ((AppCompatActivity) mcontext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Apply());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return mView;
    }
}
