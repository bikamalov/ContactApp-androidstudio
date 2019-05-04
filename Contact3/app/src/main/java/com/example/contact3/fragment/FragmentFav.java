package com.example.contact3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.contact3.Contact;
import com.example.contact3.R;
import com.example.contact3.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.contact3.fragment.FragmentContacts.listContact;

public class FragmentFav extends Fragment {
    private View v;
    String name,telephone;
    List<Contact> mData = listContact;
    TextView register_name,register_telephone;
    public FragmentFav() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fav_fragment,container,false);
       register_name = v.findViewById(R.id.register_name);
        register_telephone=v.findViewById(R.id.register_phone);
        /*Button add = v.findViewById(R.id.register_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = register_name.getText().toString();
                String phone = register_telephone.getText().toString();
                mData.add(new Contact(name,phone,R.drawable.male));
            }
        });*/



        return v;
    }

}
