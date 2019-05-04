package com.example.contact3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Contact>mData;
    Dialog myDialog;
    String number;
    int pos=0;

    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int i) {
        final View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.items_contacts,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
            myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        final Button buttoncall = myDialog.findViewById(R.id.dialog_btn_call);
        Button buttonmessage = myDialog.findViewById(R.id.dialog_btn_message);
        Button buttondelete = myDialog.findViewById(R.id.dialog_btn_delete);

        vHolder.item_contact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                TextView dialog_name_tv = (TextView)myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_phone_tv = myDialog.findViewById(R.id.dialog_phone_id);
                ImageView dialog_contact_img = myDialog.findViewById(R.id.dialog_img);
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_phone_tv.setText(mData.get(vHolder.getAdapterPosition()).getPhone());
                number = mData.get(vHolder.getAdapterPosition()).getPhone();
                dialog_contact_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                Toast.makeText(mContext,"Test Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT);
                System.out.println("INDEXXXXX"+vHolder.getAdapterPosition());
                pos = vHolder.getAdapterPosition();
                myDialog.show();
            }
        });
        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                mContext.startActivity(callIntent);
                System.out.println(mData.get(i).getPhone());
            }
        });
        buttonmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+number));
                mContext.startActivity(sendIntent);
            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.remove(pos);
                notifyDataSetChanged();
                myDialog.cancel();
            }
        });
        return vHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_phone.setText(mData.get(position).getPhone());
        holder.img.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_contact;
        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_contact = (LinearLayout)itemView.findViewById(R.id.item_contact_id);
            tv_name = (TextView)itemView.findViewById(R.id.contact_name);
            tv_phone = itemView.findViewById(R.id.contact_number);
            img = itemView.findViewById(R.id.img_contact);

        }
    }
}
