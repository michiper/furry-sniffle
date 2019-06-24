package it.stockato.its.myniuko.Forema;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import it.stockato.its.myniuko.R;

public class ForemaFragment extends Fragment {


    ListView mInfoListView;
    ForemaInfoAdapter mInfoAdapter;

    List<Info> mInformations;


    ListView mContactsListView;
    ForemaContactsAdapter mContactsAdapter;

    List<Contact> mContacts;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View vView = inflater.inflate(R.layout.fragment_forema, container, false);


        // Informations

        mInformations = new ArrayList<>();

        mInformations.add(new Info(0, R.drawable.ic_courses, "Corsi in partenza"));
        mInformations.add(new Info(1, R.drawable.ic_map, "Mappa e sedi"));
        mInformations.add(new Info(2, R.drawable.ic_frequently_asked_questions, "FAQ"));
        mInformations.add(new Info(3, R.drawable.ic_fastfood, "Compliance"));
        mInformations.add(new Info(4, R.drawable.ic_information, "About us"));


        mInfoListView = vView.findViewById(R.id.forema_info_listview);
        mInfoAdapter = new ForemaInfoAdapter(getContext(), R.layout.forema_info_cell, mInformations);
        mInfoListView.setAdapter(mInfoAdapter);


        // Contacts

        mContacts = new ArrayList<>();
        mContacts.add(new Contact(0, R.drawable.ic_phone, "Telefono", "+39 0498227173"));
        mContacts.add(new Contact(1, R.drawable.ic_email, "Email", "info@forema.it"));
        mContacts.add(new Contact(2, R.drawable.ic_edit, "Richiesta info"));
        mContacts.add(new Contact(3, R.drawable.ic_newsletter, "Newsletter"));

        mContactsListView = vView.findViewById(R.id.forema_contacts_listview);
        mContactsAdapter = new ForemaContactsAdapter(getContext(), 0, mContacts);
        mContactsListView.setAdapter(mContactsAdapter);

        return vView;

    }
}
