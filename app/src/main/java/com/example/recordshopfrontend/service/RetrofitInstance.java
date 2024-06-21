package com.example.recordshopfrontend.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://10.0.2.2:8080/api/v1/recordShop/";

    public static AlbumApiService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AlbumApiService.class); // The Retrofit class generates an implementation of the AlbumApiService interface
    }


}
