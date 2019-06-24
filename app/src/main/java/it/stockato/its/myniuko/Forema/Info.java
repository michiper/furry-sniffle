package it.stockato.its.myniuko.Forema;

public class Info {


    int mId;
    int mResource;
    String mDescription;

    public Info(int id, int resource, String description) {
        this.mId = id;
        this.mResource = resource;
        this.mDescription = description;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmResource() {
        return mResource;
    }

    public void setmResource(int mResource) {
        this.mResource = mResource;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
