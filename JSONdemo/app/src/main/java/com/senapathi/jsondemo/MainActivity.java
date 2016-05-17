package com.senapathi.jsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String line;
    private String s;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        InputStream ios = null;
        try {
            ios = getAssets().open("weather_report.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
        listView = (ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        try {
            adapter.addHotels(parseHotels(ios));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Hotels> parseHotels(InputStream ios) throws JSONException, IOException {

        //use a method which converts input stream to String

//        byte[] bytes=new byte[1024];
//        while(ios.read(bytes)!=-1){
//
//        }
        //


        BufferedReader reader = new BufferedReader(new InputStreamReader(ios));
        StringBuilder out = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        reader.close();
        s = out.toString();
        JSONObject jsonObject = new JSONObject(s);
        JSONArray array = jsonObject.getJSONArray("hotels");
        //array.length();
        //
        //
        //
        List<Hotels> list = new ArrayList<>();
        //
        for (int i = 0; i < array.length(); i++) {
            Hotels hotels = new Hotels();
            JSONObject jsonObject1 = array.getJSONObject(i);
            hotels.setTitle(jsonObject1.getString("title"));
            hotels.setLat(jsonObject1.getDouble("lat"));
            hotels.setLon(jsonObject1.getDouble("lon"));
            list.add(hotels);
        }
        return list;
    }
}
