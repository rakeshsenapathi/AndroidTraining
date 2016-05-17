package com.senapathi.startactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 10-05-2016.
 */
public class ListViewPage extends AppCompatActivity implements AdapterView.OnItemClickListener {

    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        ListView listView = (ListView) findViewById(R.id.listview);
        adapter = new MyAdapter(this);
        assert listView != null;
        listView.setAdapter(adapter);
        adapter.addStudents(getStaticData());
        listView.setOnItemClickListener(this);
    }


    public List<Student> getStaticData() {
        List<Student> list = new ArrayList<>();
        //
        for (int i = 1; i <= 20; i++) {
            Student student = new Student();
            student.name = "Name #" + i;
            student.address = "Address #" + i;
            student.phno = "Phone #" + i;
            //
            list.add(student);
        }

        return list;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent();
        intent.putExtra("data", adapter.getItem(position));
        setResult(RESULT_OK, intent);
        //
        finish();
    }
}
