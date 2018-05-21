package com.example.innobles.internapp.model;

public class Datalist {
    private String jobTitle;
    private String jobDesc;
    private String jobTiming;
    private int jobImg;
    private int icon;

    public Datalist(String jobTitle, String jobDesc, String jobTiming, int jobImg,int icon) {
        this.jobTitle = jobTitle;
        this.jobDesc = jobDesc;
        this.jobTiming = jobTiming;
        this.jobImg = jobImg;
        this.icon = icon;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobTiming() {
        return jobTiming;
    }

    public void setJobTiming(String jobTiming) {
        this.jobTiming = jobTiming;
    }

    public int getJobImg() {
        return jobImg;
    }

    public void setJobImg(int jobImg) {
        this.jobImg = jobImg;
    }

    public int getIcon() {
        return icon;
    }
}
