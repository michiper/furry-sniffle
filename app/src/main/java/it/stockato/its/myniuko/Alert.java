package it.stockato.its.myniuko;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Alert {

    String messagge;
    String title;
    int numButtons;
    Activity activity;


    public Alert(String messagge, String title, int numButtons, Activity activity) {
        this.messagge = messagge;
        this.title = title;
        this.numButtons = numButtons;
        this.activity = activity;


        AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
        builder1.setMessage("Non ci sono lezioni per te");
        builder1.setCancelable(true);



        if (numButtons==1){
            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

        }else{
            builder1.setPositiveButton(
                    "Si",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

        }
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void createDialog(Activity activity){

    }

}
