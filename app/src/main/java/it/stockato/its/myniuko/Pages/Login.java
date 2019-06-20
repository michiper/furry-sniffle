package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.R;

public class Login extends AppCompatActivity implements DialogFragment.IDialogFragment {
    EditText ed_username, ed_password;
    Button btn_login;
    CheckBox ricordaCredenziali;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        ricordaCredenziali = findViewById(R.id.ricorda_credenziali);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = ed_username.getText().toString();
                password = ed_password.getText().toString();

                if(username.isEmpty() || password.isEmpty()){
                    DialogFragment vDialog = new DialogFragment("Attenzione","Uno o più campi vuoti", 1);
                    vDialog.show(getFragmentManager(), "dialog");
                }else{
/*
                    if(username.equals("niuko") && password.equals("psw")){
                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    }else {

                        DialogFragment vDialog = new DialogFragment("Attenzione","Email o password sbagliata", 1);
                        vDialog.show(getFragmentManager(), "dialog");
                    }
                    */
                    //Intent intent = new Intent(Login.this, HomePage.class);
                    //startActivity(intent);
                }


            }
        });


    }

    //metodo del dialog fragment
    @Override
    public void onResponse(boolean response) {

    }
}
