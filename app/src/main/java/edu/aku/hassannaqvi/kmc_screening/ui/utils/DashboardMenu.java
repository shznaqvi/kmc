package edu.aku.hassannaqvi.kmc_screening.ui.utils;

public class DashboardMenu {
    private int imageSrc;
    private String lbl;

    public DashboardMenu(int imageSrc, String lbl) {
        this.imageSrc = imageSrc;
        this.lbl = lbl;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public String getLbl() {
        return lbl;
    }
}
