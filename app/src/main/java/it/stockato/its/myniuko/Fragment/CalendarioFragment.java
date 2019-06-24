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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.stockato.its.myniuko.Alert;
import it.stockato.its.myniuko.Calendario.CalendarioCorso;

import it.stockato.its.myniuko.Calendario.Lezione;
import it.stockato.its.myniuko.Calendario.Modulo;
import it.stockato.its.myniuko.Calendario.ModuloCorso;
import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.Pages.HomePage;
import it.stockato.its.myniuko.Pages.Login;
import it.stockato.its.myniuko.R;
import it.stockato.its.myniuko.Utente.Utente;
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
    TextView tv_data, tv_mattina, tv_pomeriggio, tv_om, tv_op;
    ArrayList<Lezione> listaLezioni;
    ArrayList<Modulo> listaModuli;


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



        chiamataModulo();
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
        tv_om = view.findViewById(R.id.tv_om);
        tv_op = view.findViewById(R.id.tv_op);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String selectedDate = sdf.format(new Date(calendario.getDate()));
        tv_data.setText(selectedDate);

        listaLezioni = HomePage.listLezioni;
        listaModuli = new ArrayList<>();

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
                d = year+"-"+monthS+"-"+day;
                lezioni(d, listaLezioni);
                
            }
        });




        return view;
    }


    public void lezioni(String data, ArrayList<Lezione> list){

        ArrayList<Lezione> leziones = new ArrayList<>();
        for(int i=0; i<list.size();i++){
            Lezione l = list.get(i);
            String d = l.getDataGiorno();
            //Toast.makeText(getContext(), list.get(i).getOreFine(), Toast.LENGTH_SHORT).show();
            if(d.equals(data)){
                leziones.add(l);
            }else{
                tv_om.setText("");
                tv_op.setText("");
                tv_mattina.setText("Nessuna lezione");
                tv_pomeriggio.setText("Nessuna lezione");
            }
        }
        for(int i=0; i<leziones.size();i++){
            Lezione lezione = leziones.get(i);
            if(lezione.getOreInizio().equals("9")){
                tv_om.setText(lezione.getOreFine() + " - " + lezione.getOreInizio());
                tv_mattina.setText("lezione");
            }else{
                tv_op.setText(lezione.getOreFine() + " - " + lezione.getOreInizio());
                tv_pomeriggio.setText("lezione");
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




    public void chiamataModulo(){
        Log.d("MODULO", "chiamata");
        OkHttpClient vClient = new OkHttpClient();
        String url = "http://kennedysql.altervista.org/api_kennedy/getModule.php";
        RequestBody vBody = new FormBody.Builder().add("ID", "1").build(); //devo mandare l'id del corso
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
                    getActivity().runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                JSONObject jsonObject = new JSONObject(myResponse);

                                if(myResponse==null){

                                    Toast.makeText(getContext(),"fail data",Toast.LENGTH_SHORT).show();

                                }else{

                                    String id,CodiceModulo,TitoloModulo,DescrizioneModulo,TotOreModulo,IDCorso;

                                    id = jsonObject.getString("ID");
                                    CodiceModulo = jsonObject.getString("CodiceModulo");
                                    TitoloModulo = jsonObject.getString("TitoloModulo");
                                    DescrizioneModulo = jsonObject.getString("DescrizioneModulo");
                                    TotOreModulo = jsonObject.getString("TotOreModulo");
                                    IDCorso = jsonObject.getString("IDCorso");

                                    Modulo modulo = new Modulo(id, CodiceModulo,TitoloModulo,DescrizioneModulo,TotOreModulo,IDCorso);

                                    Toast.makeText(getContext(),""+modulo.getTitoloModulo(),Toast.LENGTH_SHORT).show();
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

/*
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
    }*/
}
