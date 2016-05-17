package com.senapathi.startactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 09-05-2016.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    List<Student> mStudents = new ArrayList<>();

    public MyAdapter(Context context) {
        this.mContext = context;

    }

    public void addStudents(List<Student> list) {
        mStudents = new ArrayList<>(list);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mStudents.size();
    }

    @Override
    public Student getItem(int position) {
        return mStudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.studentlayout, null);
        //
        TextView nameView = (TextView) v.findViewById(R.id.name);
        TextView addressView = (TextView) v.findViewById(R.id.address);
        TextView phoneView = (TextView) v.findViewById(R.id.phno);
        Student s = getItem(position);

        nameView.setText(s.name);
        addressView.setText(s.address);
        phoneView.setText(s.phno);
        return v;
    }
}
