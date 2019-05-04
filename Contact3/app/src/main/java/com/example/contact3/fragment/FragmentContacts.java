package com.example.contact3.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.contact3.Contact;
import com.example.contact3.R;
import com.example.contact3.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentContacts extends Fragment {
    private View v;
    private RecyclerView myrecyclerView;
    static List<Contact> listContact;
    public FragmentContacts() {
    }
    public List<Contact> getListContact(){
        return listContact;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment,container,false);
        myrecyclerView = v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listContact = new ArrayList<>();
        listContact.add(new Contact("Горбач","87474033722",R.drawable.male));
        listContact.add(new Contact("Madi Bikamalov","87073240078",R.drawable.male));
        listContact.add(new Contact("Aidana Satzhan","87750180564",R.drawable.male));
        listContact.add(new Contact("Nursultan Nazarbayev","87074657078",R.drawable.male));
        listContact.add(new Contact("Amantay Orynbayev","87770886336",R.drawable.male));
        listContact.add(new Contact("Vladimir Putin","98765544234",R.drawable.male));
        listContact.add(new Contact("Aaron Jones","877773436634",R.drawable.male));
        listContact.add(new Contact("Madi Bikamalov","87073240078",R.drawable.male));
        listContact.add(new Contact("Aidana Satzhan","87750180564",R.drawable.male));
        listContact.add(new Contact("Nursultan Nazarbayev","87074657078",R.drawable.male));
        listContact.add(new Contact("Angela Merkel","87753467474",R.drawable.male));
        listContact.add(new Contact("Vladimir Putin","98765544234",R.drawable.male));
    }
    public void addContact(){

    }
}
