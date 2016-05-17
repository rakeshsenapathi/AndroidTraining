package com.senapathi.threading;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable, View.OnClickListener {

    TextView text;
    Button btn;
    ProgressBar progressBar;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //
            int value = (int) msg.obj;
            text.setText("Count is " + value);
            progressBar.setProgress(value);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.button2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn.setOnClickListener(this);
        //

    }

    @Override
    public void run() {
        //
        for (int i = 0; i <=100; i++) {
            try {
                //
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //
            Message message = new Message();
            message.obj = i;
            mHandler.sendMessage(message);
        }
        updateUI();
    }

    @WorkerThread
    public void updateUI() {
        //
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText("Thread ended!");

            }
        });
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                text.setText("Thread ended!");
            }
        });

//        text.post(new Runnable() {
//            @Override
//            public void run() {
//                text.setText("Thread ended!");
//            }
//        });
    }


    @Override
    public void onClick(View v) {
        text.setText("Thread started!");
        new Thread(this).start();
    }

}
