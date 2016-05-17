package com.senapathi.threadsample;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable,View.OnClickListener {

   private TextView textView;
   private TextView textLocation;
   private  EditText editText;
   private Button button;
   private Button btninstall;

   private ProgressBar progressBar;
    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int value = (int) msg.obj;
            textView.setText(value+"%");
            progressBar.setProgress(value);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
        btninstall = (Button) findViewById(R.id.install);
        editText = (EditText) findViewById(R.id.txtname);
        textLocation = (TextView) findViewById(R.id.txtlocation);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
                       case R.id.button :
                                          textView.setText("0%");
                                          progressBar.setProgress(0);
                                          new Thread(this).start();
                                          button.setEnabled(false);
                                          break;
                       case R.id.install :
                                          Intent intent = new Intent(this,UserPage.class);
                                          intent.putExtra("location",editText.getText().toString());
                                          startActivity(intent);
                                          break;

        }

    }

    @Override
    public void run() {
        //
        for (int i=0 ; i<=100 ; i+=5){
            //
            try {
                Thread.sleep(100);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
            //
           Message message = new Message();
            message.obj = i;
            mhandler.sendMessage(message);
           }
        updateUI();
        //
    }

    @WorkerThread
    public void updateUI(){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"Done!",Toast.LENGTH_SHORT).show();
                button.setEnabled(true);
                btninstall.setText("Install");

                //make download button invisible

                button.setVisibility(View.INVISIBLE);

                //make install button visible

                btninstall.setVisibility(View.VISIBLE);

                //edit text visible
                editText.setVisibility(View.VISIBLE);

                btninstall.setOnClickListener(MainActivity.this);
//                //
//                textLocation.setText(editText.getText().toString());
            }
        });
    }
}
