package com.senapathi.threadsample;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Senapathi on 11-05-2016.
 */
public class UserPage extends AppCompatActivity {
    private TextView objtext;
    String strtext;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin);
        strtext = getIntent().getStringExtra("location");
        objtext = (TextView) findViewById(R.id.txtlocation);
        objtext.setText("Installed to "+strtext);
    }
}
