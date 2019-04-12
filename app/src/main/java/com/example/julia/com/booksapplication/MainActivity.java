package com.example.julia.com.booksapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Item> volumeInfoList;
    private ProgressDialog dialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ApiService api = RetroClient.getApiService();

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading...");
        dialog.show();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Call<BookResponse> call = api.getMyJSON();
        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                dialog.dismiss();

                if (response.isSuccessful()) {

                    volumeInfoList = response.body().getItems();
                    BooksAdapter adapter = new BooksAdapter(volumeInfoList);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }


}
