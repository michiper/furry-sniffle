package it.stockato.its.myniuko.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.stockato.its.myniuko.Alert;
import it.stockato.its.myniuko.Calendario.CalendarioCorso;
import it.stockato.its.myniuko.Calendario.Lezioni;
import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.Pages.HomePage;
import it.stockato.its.myniuko.Pages.Login;
import it.stockato.its.myniuko.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalendarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalendarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarioFragment extends Fragment implements DialogFragment.IDialogFragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CalendarioFragment() {
        // Required empty public constructor
    }

    //view del fragment
    CalendarView calendario;
    TextView tv_data, tv_mattina, tv_pomeriggio;
    FragmentManager fragmentManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarioFragment newInstance(String param1, String param2) {
        CalendarioFragment fragment = new CalendarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        fragmentManager = getActivity().getSupportFragmentManager();
        chiamata();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        calendario = view.findViewById(R.id.calendarView);
        tv_data = view.findViewById(R.id.tv_data);
        tv_mattina = view.findViewById(R.id.tv_mattina);
        tv_pomeriggio = view.findViewById(R.id.tv_pomeriggio);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String selectedDate = sdf.format(new Date(calendario.getDate()));
        tv_data.setText(selectedDate);


        /*
        JSON
           { data: 02/02/2019
             mattina : Tommo Ago
             pomeriggio : Mauro Mazzetto
            }
         */
        //trovare il modo di colorare le date con degli eventi

        final ArrayList<Lezioni> listalezioni = new ArrayList<Lezioni>();
        listalezioni.add(new Lezioni("01-07-2019", "Tommaso Agostini", "Mauro Mazzetto"));
        listalezioni.add(new Lezioni("02-05-2019", "Luongo Alberto", "Cappello Antonio"));
        listalezioni.add(new Lezioni("01-06-2019", "Tommaso Agostini", "Tommaso Agostini"));
        lezioni(selectedDate, listalezioni);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String day, monthS, d;
               if(dayOfMonth<10){
                    day = "0"+dayOfMonth;
               }else{
                   day = String.valueOf(dayOfMonth);
               }
                if(month<9){
                    monthS = "0"+(month+1);
                }else{
                    monthS = String.valueOf(month+1);
                }
                tv_data.setText(day+"-"+monthS+"-"+year);
                d = day+"-"+monthS+"-"+year;
                lezioni(d, listalezioni);
                
            }
        });



        return view;
    }


    public void lezioni(String data, ArrayList<Lezioni> listalezioni){

        //Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
        for(int i=0; i<listalezioni.size();i++){
            Lezioni l = listalezioni.get(i);
            String d = l.getData();
           // Toast.makeText(getContext(), d, Toast.LENGTH_SHORT).show();
            if(d.equals(data)){
                tv_mattina.setText(l.getMattina());
                tv_pomeriggio.setText(l.getPomeriggio());

                break;
            }else{
                tv_mattina.setText("Nessuna lezione");
                tv_pomeriggio.setText("Nessuna lezione");

            }
        }

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //per la chiamata
    public void chiamata(){
        Log.d("STRONZO", "chiamata");
        OkHttpClient vClient = new OkHttpClient();
        String url = "http://kennedysql.altervista.org/api_kennedy/userCalendar.php";
        RequestBody vBody = new FormBody.Builder().add("ID", "1").build(); //devo mandare l'id dell'utente (mario rossi =1)
        Request vRequest = new Request.Builder().url(url).post(vBody).build();
        vClient.newCall(vRequest).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Log.d("STRONZO", "fail ");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                Log.d("STRONZO", "response");
                if(response.isSuccessful())
                {
                    Log.d("STRONZO", "response success");
                    final String myResponse = response.body().string();
                    getActivity().runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                JSONArray jsonArray = new JSONArray(myResponse);
                                Log.d("STRONZO", "response "+myResponse);
                                ArrayList<CalendarioCorso> list = new ArrayList<CalendarioCorso>();
                                ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());

                                if(myResponse==null){
                                    createDialog();
                                    /*
                                    DialogFragment wrongData = new DialogFragment("Attenzione", "Non ci sono lezioni per te", 1);
                                    wrongData.show(getActivity().getFragmentManager(), "dialog");
                                    */
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

                                        list.add(calendarioCorso);

                                    }

                                }


                            }
                            catch (JSONException e)
                            {
                                Log.d("STRONZO", "exception: "+e.getMessage());
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void createDialog(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage("Non ci sono lezioni per te");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
