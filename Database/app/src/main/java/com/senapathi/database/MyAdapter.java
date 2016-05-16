package com.senapathi.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 12-05-2016.
 */
public class MyAdapter extends BaseAdapter {


    TextView idView ;
    TextView nameView;
   // List<Helper.Employ> memploys = new ArrayList<>();
    Context mContext;
    List<Helper.Employ> list = new ArrayList<>();

    public MyAdapter(Context context){
        mContext = context;

    }

    public void addRecords(List<Helper.Employ> employList){

        list = new ArrayList<>(employList);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Helper.Employ getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.employee,null);
        idView= (TextView) v.findViewById(R.id.idLV);
        nameView  = (TextView) v.findViewById(R.id.nameLV);
        Helper.Employ e = getItem(position);
        idView.setText(e.getId()+"");
        nameView.setText(e.getName());
        return v;
    }


}
