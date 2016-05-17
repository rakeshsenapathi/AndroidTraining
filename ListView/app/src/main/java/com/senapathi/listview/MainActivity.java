package com.senapathi.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
//        String[] values = new String[] {
//                "Android" , "IOS" ,"Maverick" ,"Yosemite" ,"Ubuntu" ,"Khali Linux" ,"Marshmallow" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//        listView.setAdapter(adapter);
        MyAdapter myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        //
        myAdapter.addStudents(getStaticData());


    }

    //
    private List<Student> getStaticData() {
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

}
