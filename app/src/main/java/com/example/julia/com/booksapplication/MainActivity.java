package com.example.julia.com.booksapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<VolumeInfo> volumeInfoList;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ApiService api = RetroClient.getApiService();

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading...");
        dialog.show();

        BooksAdapter adapter = new BooksAdapter(volumeInfoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        Call<BookList> call = api.getMyJSON();
        call.enqueue(new Callback<BookList>() {
            @Override
            public void onResponse(Call<BookList> call, Response<BookList> response) {
                dialog.dismiss();

                if (response.isSuccessful()) {

                    volumeInfoList = response.body().getVolumeInfo();
                }
            }

            @Override
            public void onFailure(Call<BookList> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }


}
