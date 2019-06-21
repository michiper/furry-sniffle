package it.stockato.its.myniuko.MieiCorsi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class MieiCorsiAdapter extends ArrayAdapter {

    Context ctx;
    int resID;
    List<MieiCorsi> list_corsi;

    public MieiCorsiAdapter(@NonNull Context context, int resource, @NonNull List<MieiCorsi> objects) {
        super(context, resource, objects);
        ctx = context;
        resID = resource;
        list_corsi = objects;
    }


    @Override //getView è un metodo della classe ArrayAdapter, converte ogni singola view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(ctx).inflate(resID, null);

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

