package com.senapathi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

public class MainActivity extends AppCompatActivity {

    //
    private TextView id;
    private TextView name;
    private TextView address;
    private TextView mail;
    private TextView gender;
    ListView listView;
    List<Contacts> list;
    private MyAdapter adapter1;
    //    List<contacts> list = new ArrayList<>();
    //
    RestInterface restInterface;
    String BASE_URL ="http://api.androidhive.info";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        id = (TextView) findViewById(R.id.etname);
        name = (TextView) findViewById(R.id.etid);
        address = (TextView) findViewById(R.id.etmail);
        mail = (TextView) findViewById(R.id.etaddress);
        gender = (TextView )findViewById(R.id.etgender);
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();
        restInterface = adapter.create(RestInterface.class);
        //
        assert listView != null;
        listView = (ListView) findViewById(R.id.listview);
         adapter1 = new MyAdapter(this);
       // listView.setAdapter(adapter1);
        //adapter1.addrecords(callService());
        callService();



//        callService();
    }

    private void callService() {
        restInterface.getContacts(new Callback<MyPojo>() {
            @Override
            public void success(MyPojo contacts, Response response) {
                Log.e("Response",contacts.toString());


                list = new ArrayList<Contacts>(Arrays.asList(contacts.getContacts()));
                        adapter1.addrecords(list);
                listView.setAdapter(adapter1);
                // list = contacts;
                // list = new ArrayList<>();
                 //list.add(contacts);
//                  list.addAll();
//                return list;
            }


            @Override
            public void failure(RetrofitError error) {

            }
        });

        //return list;
    }


}
