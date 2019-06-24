package it.stockato.its.myniuko.Forema;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import it.stockato.its.myniuko.R;

public class ForemaContactsAdapter extends ArrayAdapter {


    Context mContext;
    int mResource;
    List<Contact> mObjects;

    ImageView mImageView;
    TextView mTextView;
    TextView mTextViewValue;


    public ForemaContactsAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {

        super(context, 0, objects);

        mContext = context;
        mResource = resource;
        mObjects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View vView;

        if (mObjects.get(position).getmValue() != null) {

            vView = LayoutInflater.from(mContext).inflate(R.layout.forema_contacts_cell_full, null);

            mImageView = vView.findViewById(R.id.forema_contacts_icon_full);
            mTextView = vView.findViewById(R.id.forema_contacts_desc_full);
            mTextViewValue = vView.findViewById(R.id.forema_contacts_value_full);

            mImageView.setImageDrawable(mContext.getResources().getDrawable(mObjects.get(position).getmResource()));
            mTextView.setText(mObjects.get(position).getmDescription());
            mTextViewValue.setText(mObjects.get(position).getmValue());

        }
        else {

            vView = LayoutInflater.from(mContext).inflate(R.layout.forema_contacts_cell, null);

            mImageView = vView.findViewById(R.id.forema_contacts_icon);
            mTextView = vView.findViewById(R.id.forema_contacts_desc);

            mImageView.setImageDrawable(mContext.getResources().getDrawable(mObjects.get(position).getmResource()));
            mTextView.setText(mObjects.get(position).getmDescription());

        }

        return vView;

    }
}
