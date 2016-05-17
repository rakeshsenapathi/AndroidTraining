package com.senapathi.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnEnter);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        //startActivity(new Intent(this, ListViewPage.class));
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
//        startActivity(new Intent(this, ListViewPage.class));
        startActivityForResult(new Intent(this, ListViewPage.class), 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                //
                Student student = (Student) data.getSerializableExtra("data");
//                student.name;
                txtTitle.setText("Selected student: "+student.name);

            }
        }

    }
}
