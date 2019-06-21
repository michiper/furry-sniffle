package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import it.stockato.its.myniuko.R;

public class SplashScreen extends AppCompatActivity {


    private static final long LOADING_TIME = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        Thread timer = new Thread() {
            public void run() {

                try {
                    sleep(LOADING_TIME);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                } finally {
                    Intent openLoginActivity = new Intent(SplashScreen.this, Login.class);
                    startActivity(openLoginActivity );
                    SplashScreen.this.finish();
                }

            }
        };

        timer.start();

    }
}
