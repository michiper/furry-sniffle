package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import it.stockato.its.myniuko.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        try {
            //set time in mili
            Thread.sleep(3000);
            Intent intent = new Intent(SplashScreen.this,Login.class);
            startActivity(intent);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
