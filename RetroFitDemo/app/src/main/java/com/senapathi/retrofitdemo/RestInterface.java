package com.senapathi.retrofitdemo;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

/**
 * Created by Senapathi on 17-05-2016.
 */
public interface RestInterface {
    @GET("/contacts/")
    void getContacts(Callback<MyPojo> cb);
}
