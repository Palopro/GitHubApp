package com.vladh.githubapp.api;

import com.vladh.githubapp.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Service {

    @GET("/search/users?q=language:java+location:kiev")
    Call<ItemResponse> getItems();
}
