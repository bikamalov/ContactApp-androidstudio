package com.example.contact3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;


import com.example.contact3.R;

public class FragmentCalls extends Fragment {
    private View v;
    private RecyclerView recyclerView;
    private static final int REQUEST_CALL = 1;
    private TextView mEditTextNumber;

    public FragmentCalls() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    v = inflater.inflate(R.layout.calls_fragment,container,false);
        mEditTextNumber = v.findViewById(R.id.edit_text_number);
        Button button0 = v.findViewById(R.id.button0);
        Button button1 = v.findViewById(R.id.button1);
        Button button2 = v.findViewById(R.id.button2);
        Button button3 = v.findViewById(R.id.button3);
        Button button4 = v.findViewById(R.id.button4);
        Button button5 = v.findViewById(R.id.button5);
        Button button6 = v.findViewById(R.id.button6);
        Button button7 = v.findViewById(R.id.button7);
        Button button8 = v.findViewById(R.id.button8);
        Button button9 = v.findViewById(R.id.button9);
        Button buttonhash = v.findViewById(R.id.buttonhash);
        Button buttonstar = v.findViewById(R.id.buttonstar);
     //   Button buttondeletelast = v.findViewById(R.id.buttondeletelast);
        Button buttondeleteall = v.findViewById(R.id.buttondeleteall);
        Button buttoncall = v.findViewById(R.id.buttoncall);
        buttoncall.setOnClickListener((v)->{ makePhoneCall();});

        buttondeleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.equals("")){
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }else {
                    mEditTextNumber.setText("");
                }

            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditTextNumber.setText(mEditTextNumber.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"1");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"2");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"3");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"4");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"5");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"6");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"7");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                };
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"8");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"9");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        buttonhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=11){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"#");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
        buttonstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber.length()!=12){
                    mEditTextNumber.setText(mEditTextNumber.getText()+"*");
                }else {
                    mEditTextNumber.setText(mEditTextNumber.getText());
                }
            }
        });
    return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void makePhoneCall() {
        String number = mEditTextNumber.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getContext(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
