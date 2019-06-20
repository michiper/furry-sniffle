package it.stockato.its.myniuko;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;


@SuppressLint("ValidFragment")
public class DialogFragment extends android.app.DialogFragment {

    IDialogFragment mListener;//riferimento all'interfaccia che poi servirà da riferimento all'activity
    String mTitle, mMessage;
    int numberButtons;

    public interface IDialogFragment {
        public void onResponse(boolean response);
    }

    public DialogFragment(String aTitle, String aMessage, int numberButtons) {
        mTitle = aTitle;
        mMessage = aMessage;
        this.numberButtons = numberButtons;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder vDialog = new AlertDialog.Builder(getActivity());
        vDialog.setTitle(mTitle);
        vDialog.setMessage(mMessage);

        if (numberButtons == 1) {
            vDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mListener.onResponse(true);
                }
            });
        } else{

            vDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mListener.onResponse(true);
                }
            });
            vDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onResponse(false);

            }
        });

    }
        return vDialog.create();
    }

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof IDialogFragment) {
            mListener = (IDialogFragment) activity;
        } else {
            mListener = null;
        }
        super.onAttach(activity);
    }
}
