package com.example.julia.com.booksapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("retrofit/json_object.json")
    Call<BookList> getMyJSON();
}
