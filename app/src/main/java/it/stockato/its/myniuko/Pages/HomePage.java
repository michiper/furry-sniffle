package it.stockato.its.myniuko.Pages;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import it.stockato.its.myniuko.Fragment.CalendarioFragment;
import it.stockato.its.myniuko.Fragment.NiukoFragment;
import it.stockato.its.myniuko.R;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CalendarioFragment.OnFragmentInteractionListener, NiukoFragment.OnFragmentInteractionListener {

    android.support.v4.app.FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //per far apparire il fragment
        manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

        final CalendarioFragment fragment = new CalendarioFragment();
        //replace perchè alrimenti si sovrappone
        transaction.replace(R.id.container, fragment);
        transaction.commit();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.calendario:
                        //Toast.makeText(HomePage.this, "Calendario", Toast.LENGTH_SHORT).show();
                        manager = getSupportFragmentManager();
                        final FragmentTransaction transaction1 = manager.beginTransaction();

                        final CalendarioFragment fragmentC = new CalendarioFragment();
                        //replace perchè alrimenti si sovrappone
                        transaction1.replace(R.id.container, fragmentC);
                        transaction1.commit();
                        break;

                    case R.id.miei_corsi:
                        Toast.makeText(HomePage.this, "Miei corsi", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.niuko:
                       //Toast.makeText(HomePage.this, "Niuko", Toast.LENGTH_SHORT).show();
                        //per far apparire il fragment
                        manager = getSupportFragmentManager();
                        final FragmentTransaction transaction = manager.beginTransaction();

                        final NiukoFragment fragmentN = new NiukoFragment();
                        //replace perchè alrimenti si sovrappone
                        transaction.replace(R.id.container, fragmentN);
                        transaction.commit();
                        break;

                    case R.id.email:
                        Toast.makeText(HomePage.this, "Email", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
