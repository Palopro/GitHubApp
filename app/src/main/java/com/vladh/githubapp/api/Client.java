package com.vladh.githubapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Client {

    private static final String BASE_URL = "https://api.github.com";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final Service SERVICE = retrofit.create(Service.class);

    public static Service getService() {
        return SERVICE;
    }
}
