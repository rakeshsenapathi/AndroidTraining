package com.senapathi.employeerecords;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Senapathi on 10-05-2016.
 */
public class UserPage extends AppCompatActivity {

    public static final String TAG = "UserPage";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);

        TextView textView = (TextView) findViewById(R.id.name);
        TextView designView = (TextView) findViewById(R.id.designation);
        TextView salaryView = (TextView) findViewById(R.id.salary);
//        String user_name = getIntent().getStringExtra("user_name");
        EmpRecord record = (EmpRecord) getIntent().getSerializableExtra("data");
        assert textView != null;
        textView.setText(record.getName());
        assert designView != null;
        designView.setText(record.getDesignation());
        assert salaryView != null;
        salaryView.setText(record.getSalary());



    }

}
