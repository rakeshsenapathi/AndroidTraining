package com.senapathi.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Senapathi on 10-05-2016.
 */
public class MyAdapter extends BaseAdapter {

    public Context mContext;

    public MyAdapter (Context context){
        this.mContext = context ;
    }
    @Override
    public int getCount(){
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            View v = LayoutInflater.from(mContext).inflate(R.layout.grid_row, null);

            return v;
    }
}
