package com.senapathi.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendButton;
    public static final String ACTION_SEND = "com.senapathi.broadcast.ACTION_SEND";
    MyReceier receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceier();
        sendButton = (Button) findViewById(R.id.senderbtn);
        assert sendButton != null;
        sendButton.setOnClickListener(this);
        registerReceiver(receiver, new IntentFilter(ACTION_SEND));
    }

    @Override
    public void onClick(View v) {
        //
        sendBroadcast(new Intent(ACTION_SEND));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);

    }


public   class MyReceier extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            sendButton.setText("Receiver Button");

        }

    }
}
