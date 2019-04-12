package com.example.julia.com.booksapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("volumes?q=android&maxResults=5")
    Call<BookResponse> getMyJSON();
}
