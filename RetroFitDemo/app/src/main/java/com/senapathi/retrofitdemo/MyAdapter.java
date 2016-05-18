package com.senapathi.retrofitdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 17-05-2016.
 */
public class MyAdapter extends BaseAdapter {

    //
    private TextView name;
    private TextView mail;
    private TextView address;
    private TextView id;
    private TextView gender;
    //
    private Context mContext;
    List<Contacts> mContacts = new ArrayList<>();
    public MyAdapter(Context context){
        mContext = context;

    }
    //
    public void addrecords(List<Contacts> list){
        mContacts = new ArrayList<>(list);
        notifyDataSetChanged();
    }
    //
    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.contacts,null);
        name = (TextView) v.findViewById(R.id.etname);
        address = (TextView) v.findViewById(R.id.etaddress);
        mail = (TextView) v.findViewById(R.id.etmail);
        id = (TextView) v.findViewById(R.id.etid);
        gender = (TextView) v.findViewById(R.id.etgender);
        Contacts c = mContacts.get(position);
        name.setText(c.getName());
        address.setText(c.getAddress());
        mail.setText(c.getEmail());
        gender.setText(c.getGender());
        id.setText(c.getId());
        return v;
    }
}
