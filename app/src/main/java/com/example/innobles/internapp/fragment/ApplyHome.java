package com.example.innobles.internapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.innobles.internapp.R;

public class ApplyHome extends Fragment implements View.OnClickListener {
    Button details, education, experience, apply, cancel, yes, no;
    ImageView close;
    AlertDialog.Builder mBuilder;
    AlertDialog dialog, subDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.rl_replace, new Details())
                .addToBackStack("Apply")
                .commit();
        return inflater.inflate(R.layout.fragment_apply_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        education = (Button) getActivity().findViewById(R.id.btn_education);
        experience = (Button) getActivity().findViewById(R.id.btn_experience);
        details = (Button) getActivity().findViewById(R.id.btn_details);
        apply = (Button) getActivity().findViewById(R.id.btn_apply_1);
        cancel = (Button) getActivity().findViewById(R.id.btn_cancel);
        education.setOnClickListener(this);
        details.setOnClickListener(this);
        experience.setOnClickListener(this);
        apply.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    private void showPopupDialogue() {
        mBuilder = new AlertDialog.Builder(getContext());
        final View mView = getLayoutInflater().inflate(R.layout.dialog_application_status, null);
        yes = (Button) mView.findViewById(R.id.dialog_btn_yes);
        no = (Button) mView.findViewById(R.id.dialog_btn_no);
        close = (ImageView) mView.findViewById(R.id.close);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        close.setOnClickListener(this);
        disPlayDialog(mView);

    }

    private void showSuccessStatus() {
        mBuilder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.dialog_success_status, null);
        ImageView close_01 = (ImageView) mView.findViewById(R.id.close_01);
        close_01.setOnClickListener(this);
        disPlaySubDialog(mView);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apply_1:
                showPopupDialogue();
                break;
            case R.id.btn_cancel:
                getFragmentManager().beginTransaction().replace(R.id.container, new Apply()).commit();
                break;
            case R.id.btn_education:
                getFragmentManager().beginTransaction().replace(R.id.rl_replace, new EducationDetails()).commit();
                break;
            case R.id.btn_details:
                getFragmentManager().beginTransaction().replace(R.id.rl_replace, new Details()).commit();
                break;
            case R.id.btn_experience:
                getFragmentManager().beginTransaction().replace(R.id.rl_replace, new ExperienceDetails()).commit();
                break;
            case R.id.dialog_btn_yes:
                showSuccessStatus();
                dialog.dismiss();
                break;
            case R.id.dialog_btn_no:
                dialog.dismiss();
                break;
            case R.id.close:
                dialog.dismiss();
                break;
            case R.id.close_01:
                subDialog.dismiss();
                break;
        }

    }

    private void disPlayDialog(View v) {
        mBuilder.setView(v);
        dialog = mBuilder.show();

    }

    private void disPlaySubDialog(View v) {
        mBuilder.setView(v);
        subDialog = mBuilder.show();

    }
}
