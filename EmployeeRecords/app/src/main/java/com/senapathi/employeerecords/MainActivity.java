package com.senapathi.employeerecords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    EmployeeAdapter mEmployeeAdapter;
    String mEmployeeName;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        mEmployeeAdapter = new EmployeeAdapter(this);
        listView.setAdapter(mEmployeeAdapter);
        mEmployeeAdapter.createRecords(getStaticData());
        //
        listView.setOnItemClickListener(this);
    }

    private List<EmpRecord> getStaticData() {
        List<EmpRecord> list = new ArrayList<>();
        //
        for (int i = 1; i <= 20; i++) {
            EmpRecord employee = new EmpRecord();
            employee.setName( "Name #" + i);
            employee.setDesignation( "Designation #" + i);
            employee.setSalary("Salary #" + i);
            //
            list.add(employee);
        }

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //
        EmpRecord record = mEmployeeAdapter.getItem(position);
        mEmployeeName = record.name();
        Intent intent = new Intent(this, UserPage.class);
        intent.putExtra("user_name", mEmployeeName);
        //
        intent.putExtra("data", record);

        startActivity(intent);

    }
}
