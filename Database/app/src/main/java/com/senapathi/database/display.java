package com.senapathi.database;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Senapathi on 12-05-2016.
 */
public class display extends AppCompatActivity {
    ListView list;
    Helper mHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaypage);
        mHelper = new Helper(this);
        assert list != null;
        list = (ListView) findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this);
        list.setAdapter(adapter);
        mHelper.getReadableDatabase();
        adapter.addRecords( mHelper.populateRecords());
    }
}
