package it.stockato.its.myniuko.Pages;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;

import android.util.Log;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import it.stockato.its.myniuko.Calendario.CalendarioCorso;
import it.stockato.its.myniuko.Calendario.Lezione;
import it.stockato.its.myniuko.Calendario.ModuloCorso;
import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.Fragment.CalendarioFragment;
import it.stockato.its.myniuko.Fragment.EmailFragment;
import it.stockato.its.myniuko.Forema.ForemaFragment;
import it.stockato.its.myniuko.Fragment.MieiCorsiFragment;
import it.stockato.its.myniuko.Fragment.UtenteFragment;
import it.stockato.its.myniuko.R;
import it.stockato.its.myniuko.Utente.Utente;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomePage extends AppCompatActivity
        implements DialogFragment.IDialogFragment,
        NavigationView.OnNavigationItemSelectedListener,
        CalendarioFragment.OnFragmentInteractionListener,
        //ForemaFragment.OnFragmentInteractionListener,
        MieiCorsiFragment.OnFragmentInteractionListener,
        EmailFragment.OnFragmentInteractionListener,
        UtenteFragment.OnFragmentInteractionListener{

    FragmentManager manager;
    public static Utente userLogged;
    public static Activity activity = null;
    private String mUserID;
    FragmentManager fragmentManager;
    ArrayList<CalendarioCorso> listCalendarioCorso;
    ArrayList<ModuloCorso> listModuloCorso;
    public static  ArrayList<Lezione> listLezioni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calendario");

        activity = this;
        getSupportActionBar().setTitle("Calendario");

        fragmentManager = getSupportFragmentManager();
        listCalendarioCorso = new ArrayList<>();
        listModuloCorso = new ArrayList<>();
        listLezioni = new ArrayList<>();

        if(getIntent().getExtras() != null) {
            mUserID = getIntent().getExtras().getString("id");
            userLogged = new Utente();
            //Log.d("id", "     " + mUserID);
        }

        //chiamate
        chiamataCorso();
       // chiamataModulo();
        chiamataDatiUtente();


        //per far apparire il fragment
        manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

        final CalendarioFragment fragment = new CalendarioFragment();
        //replace perchè alrimenti si sovrappone
        transaction.replace(R.id.container, fragment);
        transaction.commit();



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
                        getSupportActionBar().setTitle("Calendario");
                        break;

                    case R.id.miei_corsi:
                        manager = getSupportFragmentManager();
                        final FragmentTransaction transaction2 = manager.beginTransaction();
                        final MieiCorsiFragment fragmentMC = new MieiCorsiFragment();
                        //replace perchè alrimenti si sovrappone
                        transaction2.replace(R.id.container, fragmentMC);
                        transaction2.commit();
                        getSupportActionBar().setTitle("I miei corsi");
                        break;

                    case R.id.profilo:
                       //Toast.makeText(HomePage.this, "Niuko", Toast.LENGTH_SHORT).show();
                        manager = getSupportFragmentManager();
                        final FragmentTransaction transaction4 = manager.beginTransaction();
                        final UtenteFragment fragmentP = new UtenteFragment();
                        //replace perchè alrimenti si sovrappone
                        transaction4.replace(R.id.container, fragmentP);
                        transaction4.commit();
                        getSupportActionBar().setTitle("Profilo");
                        break;

                    case R.id.email:
                        manager = getSupportFragmentManager();
                        final FragmentTransaction transaction3 = manager.beginTransaction();
                        final EmailFragment fragmentE = new EmailFragment();
                        //replace perchè alrimenti si sovrappone
                        transaction3.replace(R.id.container, fragmentE);
                        transaction3.commit();
                        getSupportActionBar().setTitle("Email");
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
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.btn_pofilo){
            //per far apparire il fragment
            manager = getSupportFragmentManager();

            final FragmentTransaction transaction = manager.beginTransaction();
            final ForemaFragment fragmentN = new ForemaFragment();
            //replace perchè alrimenti si sovrappone
            transaction.replace(R.id.container, fragmentN);
            transaction.commit();
            getSupportActionBar().setTitle("Informazioni");
        }

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

    public static void terminaSessione(){
        activity.finish();
    }




    //per le chiamate

    public void chiamataDatiUtente(){

        OkHttpClient vClient = new OkHttpClient();
        final String url = "http://kennedysql.altervista.org/api_kennedy/getUser.php";
        RequestBody vBody = new FormBody.Builder().add("ID",mUserID).build();
        Request vRequest = new Request.Builder().url(url).post(vBody).build();
        vClient.newCall(vRequest).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                if(response.isSuccessful())
                {
                    final String myResponse = response.body().string();
                    HomePage.this.runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                JSONObject json = new JSONObject(myResponse);

                                userLogged = new Utente(
                                        json.getString("ID"),
                                        json.getString("TipoUtente"),
                                        json.getString("Nome"),
                                        json.getString("Cognome"),
                                        json.getString("Email"),
                                        json.getString("Pwd"),
                                        json.getString("PwdChange"),
                                        json.getString("CF"),
                                        json.getString("ImgProfilo")
                                );
                            }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }



    public void chiamataCorso(){
        Log.d("CORSO", "chiamata");
        OkHttpClient vClient = new OkHttpClient();
        String url = "http://kennedysql.altervista.org/api_kennedy/userCalendar.php";
        RequestBody vBody = new FormBody.Builder().add("ID", "1").build(); //devo mandare l'id dell'utente (mario rossi =1)
        Request vRequest = new Request.Builder().url(url).post(vBody).build();
        vClient.newCall(vRequest).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Log.d("CORSO", "fail ");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                Log.d("CORSO", "response");
                if(response.isSuccessful())
                {
                    Log.d("CORSO", "response success");
                    final String myResponse = response.body().string();
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                JSONArray jsonArray = new JSONArray(myResponse);
                                Log.d("CORSO", "response "+myResponse);

                                ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());

                                if(myResponse==null){

                                    DialogFragment wrongData = new DialogFragment("Attenzione", "Non ci sono lezioni per te", 1);
                                    wrongData.show(getFragmentManager(), "dialog");

                                }else{
                                    String id,idCorso,idModulo,dataGiorno,oreInizio,oreFine;
                                    String autla,ore, statoGiorno,codiceCorso,titoloCorso;
                                    String descrizioneCorso,totOreCorso,QRCorso,oreMin;
                                    String dataInizioAtt,dataFineAtt,statoCorso,nomeAule;

                                    for(int i=0;i < jsonArray.length();i++){
                                        arrayList.add(jsonArray.getJSONObject(i));
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        id = jsonObject.getString("ID");
                                        idCorso = jsonObject.getString("IDCorso");
                                        idModulo = jsonObject.getString("IDModulo");
                                        dataGiorno = jsonObject.getString("DataGiorno");
                                        oreInizio = jsonObject.getString("OreInizio");
                                        oreFine = jsonObject.getString("OreFine");
                                        autla = jsonObject.getString("Aula");
                                        ore = jsonObject.getString("Ore");
                                        statoGiorno = jsonObject.getString("StatoGiorno");
                                        codiceCorso = jsonObject.getString("CodiceCorso");
                                        titoloCorso = jsonObject.getString("TitoloCorso");
                                        descrizioneCorso = jsonObject.getString("TitoloCorso");
                                        totOreCorso = jsonObject.getString("TotOreCorso");
                                        QRCorso = jsonObject.getString("QRCorso");
                                        oreMin = jsonObject.getString("OreMin");
                                        dataInizioAtt = jsonObject.getString("DataInizioAtt");
                                        dataFineAtt = jsonObject.getString("DataFineAtt");
                                        statoCorso = jsonObject.getString("StatoCorso");
                                        nomeAule = jsonObject.getString("NomeAule");

                                        CalendarioCorso calendarioCorso = new CalendarioCorso(id, idCorso,idModulo,dataGiorno,oreInizio,
                                                oreFine,autla,ore, statoGiorno,codiceCorso,titoloCorso,
                                                descrizioneCorso,totOreCorso,QRCorso,oreMin,dataInizioAtt,dataFineAtt,
                                                statoCorso,nomeAule);

                                        listCalendarioCorso.add(calendarioCorso);
                                        listLezioni.add(new Lezione(idCorso,idModulo,dataGiorno,oreInizio,oreFine));

                                    }

                                }


                            }
                            catch (JSONException e)
                            {
                                Log.d("CORSO", "exception: "+e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }


    public void chiamataModulo(){
        Log.d("MODULO", "chiamata");
        OkHttpClient vClient = new OkHttpClient();
        String url = "http://kennedysql.altervista.org/api_kennedy/courseModules.php";
        RequestBody vBody = new FormBody.Builder().add("ID", "1").build(); //devo mandare l'id dell'utente (mario rossi =1)
        Request vRequest = new Request.Builder().url(url).post(vBody).build();
        vClient.newCall(vRequest).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Log.d("MODULO", "fail ");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                Log.d("MODULO", "response");
                if(response.isSuccessful())
                {
                    Log.d("MODULO", "response success");
                    final String myResponse = response.body().string();
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                JSONArray jsonArray = new JSONArray(myResponse);
                                Log.d("MODULO", "response "+myResponse);

                                ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());

                                if(myResponse==null){

                                    DialogFragment wrongData = new DialogFragment("Attenzione", "Non ci sono lezioni per te 2", 1);
                                    wrongData.show(getFragmentManager(), "dialog");

                                }else{
                                    String id,CodiceCorso,TitoloCorso,DescrizioneCorso,TotOreCorso,QRCorso;
                                    String oreMin, dataInizioAtt, dataFineAtt, StatoCorso, CodiceModulo;
                                    String TitoloModulo, DescrizioneModulo, TotOreModulo, IDCorso;

                                    for(int i=0;i < jsonArray.length();i++){
                                        arrayList.add(jsonArray.getJSONObject(i));
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        id = jsonObject.getString("ID");
                                        CodiceCorso = jsonObject.getString("CodiceCorso");
                                        TitoloCorso = jsonObject.getString("TitoloCorso");
                                        DescrizioneCorso = jsonObject.getString("DescrizioneCorso");
                                        TotOreCorso = jsonObject.getString("TotOreCorso");
                                        QRCorso = jsonObject.getString("QRCorso");
                                        oreMin = jsonObject.getString("OreMin");
                                        dataInizioAtt = jsonObject.getString("DataInizioAtt");
                                        dataFineAtt = jsonObject.getString("DataFineAtt");
                                        StatoCorso = jsonObject.getString("StatoCorso");
                                        CodiceModulo = jsonObject.getString("CodiceModulo");
                                        TitoloModulo = jsonObject.getString("TitoloModulo");
                                        DescrizioneModulo = jsonObject.getString("DescrizioneModulo");
                                        TotOreModulo = jsonObject.getString("TotOreModulo");
                                        IDCorso = jsonObject.getString("IDCorso");


                                        ModuloCorso moduloCorso = new ModuloCorso(id, CodiceCorso,TitoloCorso,DescrizioneCorso,TotOreCorso,
                                                QRCorso,oreMin, dataInizioAtt,dataFineAtt,StatoCorso,
                                                CodiceModulo,TitoloModulo,DescrizioneModulo,TotOreModulo,IDCorso);

                                        listModuloCorso.add(moduloCorso);

                                    }

                                }


                            }
                            catch (JSONException e)
                            {
                                Log.d("MODULO", "exception: "+e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onResponse(boolean response) {

    }
}
