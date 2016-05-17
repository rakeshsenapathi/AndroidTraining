package com.senapathi.employeerecords;

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
public class EmployeeAdapter extends BaseAdapter {


    private Context mcontext;
    List<EmpRecord> employee;// = new ArrayList<>();

    public EmployeeAdapter(Context context) {
        this.mcontext = context;
    }

    public void createRecords(List<EmpRecord> list) {
        employee = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        if (employee == null) {
            return 0;
        }
        return employee.size();
    }

    @Override
    public EmpRecord getItem(int position) {
        return employee.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = LayoutInflater.from(mcontext).inflate(R.layout.employee, null);
//        //
//        TextView nameView = (TextView) v.findViewById(R.id.name);
//        TextView designView = (TextView) v.findViewById(R.id.designation);
//        TextView salaryView = (TextView) v.findViewById(R.id.salary);
//        EmpRecord s = getItem(position);
//
//        nameView.setText(s.name);
//        designView.setText(s.designation);
//        salaryView.setText(s.salary);
//        return v;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(mcontext).inflate(R.layout.employee, null);
        }
        //
        TextView nameView = (TextView) v.findViewById(R.id.name);
        TextView designView = (TextView) v.findViewById(R.id.designation);
        TextView salaryView = (TextView) v.findViewById(R.id.salary);
        EmpRecord s = getItem(position);

        nameView.setText(s.getName());
        designView.setText(s.getDesignation());
        salaryView.setText(s.getSalary());
        return v;
    }
}
