package it.stockato.its.myniuko.MieiCorsi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import it.stockato.its.myniuko.R;

public class MieiCorsiAdapter extends ArrayAdapter {

    Context ctx;
    int resID;
    List<Corso> list_corsi;

    public MieiCorsiAdapter(@NonNull Context context, int resource, @NonNull List<Corso> objects) {
        super(context, resource, objects);
        ctx = context;
        resID = resource;
        list_corsi = objects;
    }


    @Override //getView è un metodo della classe ArrayAdapter, converte ogni singola view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(ctx).inflate(resID, null);


        TextView vCourseName = convertView.findViewById(R.id.course_name);
        TextView vCourseProgressTextView = convertView.findViewById(R.id.course_progress_tv);

        ProgressBar vProgressBar = convertView.findViewById(R.id.course_progress);


        Corso vCorso = list_corsi.get(position);

        vCourseName.setText(vCorso.getTitoloCorso());
        vCourseProgressTextView.setText(getContext().getText(R.string.course_progress) + ("60" + "") + "%");

        vProgressBar.setProgress(60);

/*
        TextView textViewNome = convertView.findViewById(R.id.tv_nome);
        Contatti z1 = list_corsi.get(position);
        textViewNome.setText(z1.nome);

        TextView textViewNumero = convertView.findViewById(R.id.tv_numero);
        Contatti z2 = list_corsi.get(position);
        textViewNumero.setText(z2.numero);
*/
        return convertView;
    }
}

