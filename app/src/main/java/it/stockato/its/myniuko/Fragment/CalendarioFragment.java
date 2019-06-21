package it.stockato.its.myniuko.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.stockato.its.myniuko.Calendario.Lezioni;
import it.stockato.its.myniuko.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalendarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalendarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarioFragment extends Fragment  {
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
}
