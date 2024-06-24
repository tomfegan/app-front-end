package com.example.recordshopfrontend.service;

import com.example.recordshopfrontend.model.AlbumModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlbumApiService {

    // This is where the Retrofit HTTP methods will be declared

    // Declare a method in here to get all albums, which returns a
    // Call object of the list of Album objects. Refer to the Retrofit
    // docs for guidance on this.


    // a Retrofit Call<T> object abstracts the details of making network
    // requests, providing a flexible and powerful mechanism for handling
    // HTTP requests and responses in a type-safe manner
    @GET("albums")
    Call<List<AlbumModel>> getAllAlbums(); // i.e., with the @GET annotation, this method is making a GET request to the "/albums" endpoint and expects a list of albumModels in return. Different annotations are used to specify the HTTP request type: GET, POST, PUT, DELETE


}
