package it.stockato.its.myniuko.Forema;

public class Contact {


    int mId;
    int mResource;
    String mDescription;
    String mValue;


    public Contact(int id, int resource, String description, String value) {
        mId = id;
        mResource = resource;
        mDescription = description;
        mValue = value;
    }

    public Contact(int id, int resource, String description) {
        mId = id;
        mResource = resource;
        mDescription = description;
        mValue = null;
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

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }
}
