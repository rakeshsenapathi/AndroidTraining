package com.senapathi.jsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.apache.http.params.HttpParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 16-05-2016.
 */
public class MyAdapter extends BaseAdapter {


    private TextView titleview;
    private TextView latview;
    private TextView lonview;
    //
    private Context mContext;
    List<Hotels> mHotels = new ArrayList<>();
    public MyAdapter(Context context){
           mContext = context;
    }
    //

    public void addHotels(List<Hotels> list) {
        mHotels = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    //



    @Override
    public int getCount() {
        return mHotels.size();
    }

    @Override
    public Object getItem(int position) {
        return mHotels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.listview,null);

       titleview = (TextView) v.findViewById(R.id.titleTV);
        latview = (TextView) v.findViewById(R.id.latTV);
        lonview = (TextView) v.findViewById(R.id.lonTV);

        Hotels h = mHotels.get(position);


        titleview.setText(h.getTitle());
        latview.setText(String.valueOf( h.getLat()));
        lonview.setText(String.valueOf(h.getLon()) );
        return v;
    }
}
