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

public class ForemaInfoAdapter extends ArrayAdapter {


    Context mContext;
    int mResource;
    List<Info> mObjects;

    ImageView mImageView;
    TextView mTextView;


    public ForemaInfoAdapter(@NonNull Context context, int resource, @NonNull List<Info> objects) {

        super(context, resource, objects);

        mContext = context;
        mResource = resource;
        mObjects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View vView = LayoutInflater.from(mContext).inflate(mResource, null);

        mImageView = vView.findViewById(R.id.forema_info_icon);
        mTextView = vView.findViewById(R.id.forema_info_desc);

        mImageView.setImageDrawable(mContext.getResources().getDrawable(mObjects.get(position).getmResource()));
        mTextView.setText(mObjects.get(position).getmDescription());

        return vView;

    }
}
