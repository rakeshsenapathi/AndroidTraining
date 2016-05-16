package com.senapathi.asynctaskthread;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   TextView textView;
    ProgressBar progressBar;
    Button button;
    Button btninstall;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        textView = (TextView) findViewById(R.id.text);
        btninstall = (Button) findViewById(R.id.install);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.button) {
            textView.setText("0%");
            progressBar.setProgress(0);
            button.setEnabled(false);
            AsyncThread asyncThread = new AsyncThread();
            asyncThread.execute();
        }

    }

    public class AsyncThread extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            for(int i=0;i<=100;i+=5){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              publishProgress(i);

            }
            return "Done";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textView.setText(values[0]+"%");
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            button.setEnabled(true);
            button.setVisibility(View.INVISIBLE);
            btninstall.setVisibility(View.VISIBLE);
            btninstall.setText("Install");
        }
    }






}
