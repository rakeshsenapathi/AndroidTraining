package com.senapathi.apicallsdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  MyAdapter adapter;
    ListView  listView;
    private String sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... params) {

                return Utils.performGET(params[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
//                    sv=s;
//                    parseContacts(s);

                        adapter.addrecords(parseContacts(s));



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute("http://api.androidhive.info/contacts/");

        listView = (ListView) findViewById(R.id.listview);
        adapter = new MyAdapter(this);
        listView.setAdapter(adapter);



    }

    private List<contacts> parseContacts(String s) throws JSONException {

        //

        JSONObject jsonObject = new JSONObject(s);
        JSONArray array = jsonObject.getJSONArray("contacts");

        //

        List<contacts> list = new ArrayList<>();
        for(int i=0;i<array.length();i++)
        {
            contacts c = new contacts();
            JSONObject jsonObject1 = array.getJSONObject(i);
            c.setName(jsonObject1.getString("name"));
            c.setEmail(jsonObject1.getString("email"));
            c.setGender(jsonObject1.getString("gender"));
            c.setAddress(jsonObject1.getString("address"));
            c.setId(jsonObject1.getString("id"));
            list.add(c);

        }
        Log.i("My List", list.toString());
          return list;
    }
}
