package com.example.julia.com.booksapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookList {

    @SerializedName("")
    @Expose
    private ArrayList<BookResponse> bookResponse = null;
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = null;
    @SerializedName("volumeInfo")
    @Expose
    private ArrayList<VolumeInfo> volumeInfo = null;

    public ArrayList<BookResponse> getBookResponse() {
        return bookResponse;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<VolumeInfo> getVolumeInfo() {
        return volumeInfo;
    }


}
