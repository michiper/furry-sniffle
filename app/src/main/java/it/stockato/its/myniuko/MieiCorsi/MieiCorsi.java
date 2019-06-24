package it.stockato.its.myniuko.MieiCorsi;

import java.util.ArrayList;

public class MieiCorsi {


    String mName;
    int mProgress;

    ArrayList<String> mModules;

    public MieiCorsi(String aName, int aProgress, String[] aModules) {

        this.mName = aName;
        this.mProgress = aProgress;

        mModules = new ArrayList<>();

        for (int i=0; i<aModules.length; i++) {
            this.mModules.add(aModules[i]);
        }

    }

    public String getName() {
        return mName;
    }

    public void setName(String aName) {
        this.mName = aName;
    }


    public int getProgress() {
        return mProgress;
    }

}
