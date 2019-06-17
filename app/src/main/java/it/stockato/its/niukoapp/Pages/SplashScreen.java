package it.stockato.its.niukoapp.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.stockato.its.niukoapp.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }
}
