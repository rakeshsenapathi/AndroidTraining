package com.senapathi.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText idtxt;
    private EditText nametxt;
    Helper mHelper ;
    private Helper.Employ employ;
    private Button insertbutton;
    private Button updatebutton;
    private Button deletebutton;
    private Button displaybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        idtxt = (EditText) findViewById(R.id.idtxt);
        nametxt = (EditText) findViewById(R.id.nametxt);
        //
        mHelper = new Helper(this);

        //
        insertbutton = (Button) findViewById(R.id.insertbtn);
        updatebutton = (Button) findViewById(R.id.updatebtn);
        deletebutton = (Button) findViewById(R.id.deletebtn);
        displaybutton = (Button) findViewById(R.id.displaybtn);

        //
        insertbutton.setOnClickListener(this);
        updatebutton.setOnClickListener(this);
        deletebutton.setOnClickListener(this);
        displaybutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String id = idtxt.getText().toString();
        String name = nametxt.getText().toString();
        if (checkIDtext(id,name)) {
            Toast.makeText(MainActivity.this,"Empty Inputs",Toast.LENGTH_SHORT).show();
        }
        else {
            switch (v.getId()) {

                case R.id.insertbtn:
                    mHelper.insertData(id,name);
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.updatebtn:
                    Toast.makeText(MainActivity.this, "Data Upadated", Toast.LENGTH_SHORT).show();
                    mHelper.updateData(id,name);
                    break;
                case R.id.deletebtn:
                    Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                    mHelper.deleteData(id);
                    break;
                case R.id.displaybtn:
                    Intent intent = new Intent(MainActivity.this,display.class);
                    startActivity(intent);
                    break;

            }
        }
    }


    public Boolean checkIDtext(String id, String name) {
        if (TextUtils.isEmpty(id) && TextUtils.isEmpty(name)) {
            return true;
        }
        else
        return false;
    }
}
