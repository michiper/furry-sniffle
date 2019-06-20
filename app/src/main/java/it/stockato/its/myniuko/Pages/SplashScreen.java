package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
                    Intent openMainActivity = new Intent(SplashScreen.this, HomePage.class);
                    startActivity(openMainActivity );
                    SplashScreen.this.finish();
                }

            }
        };

        timer.start();

    }
}
