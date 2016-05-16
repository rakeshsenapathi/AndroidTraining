package com.senapathi.basicservicesdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dowloadbtn;

    private ProgressBar progressbar;

    public static final String INTENT_ID = "com.senapathi.basicservicesdemo.INTENT_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dowloadbtn = (Button) findViewById(R.id.downloadbtn);
        assert dowloadbtn != null;
        dowloadbtn.setOnClickListener(this);
        progressbar = (ProgressBar) findViewById( R.id.progressbar );
        registerReceiver( receiver, new IntentFilter(INTENT_ID) );
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           int integer_count = intent.getIntExtra( "count", 0 );
            progressbar.setProgress(integer_count);
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver( receiver );
        super.onDestroy();
    }
}