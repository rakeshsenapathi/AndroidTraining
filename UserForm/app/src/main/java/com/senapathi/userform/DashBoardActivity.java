package com.senapathi.userform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Senapathi on 06-05-2016.
 */
public class DashBoardActivity extends AppCompatActivity {
    public static final String TAG = "DashBoardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting UI
        setContentView(R.layout.loging);
        TextView textView = (TextView) findViewById(R.id.user_data);
        String username = getIntent().getStringExtra("user_name");
        textView.setText(username);
        //Log Messages
        Log.d(TAG, "onCreate: username is -" + username);

    }
}
