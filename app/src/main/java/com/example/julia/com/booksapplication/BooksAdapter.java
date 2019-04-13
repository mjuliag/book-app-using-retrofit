package com.example.julia.com.booksapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.CustomViewHolder> {
    private List<Item> volumeInfo;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        VolumeInfo volumeInfo = this.volumeInfo.get(position).getVolumeInfo();
        holder.bookTitle.setText(volumeInfo.getTitle());
        holder.publisher.setText(volumeInfo.getPublisher());
        if (volumeInfo.getAuthors() != null && !volumeInfo.getAuthors().isEmpty()) {
            holder.bookAuthor.setText(volumeInfo.getAuthors().get(0));
        }
        holder.publishedDate.setText(volumeInfo.getPublishedDate());
        holder.description.setText(volumeInfo.getDescription());
    }

    @Override
    public int getItemCount() {
        return volumeInfo == null ? 0 : volumeInfo.size();
    }

    public void setVolumeInfo(final List<Item> volumeInfo) {
        this.volumeInfo = volumeInfo;
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView bookTitle, bookAuthor, publisher, publishedDate, description;

        CustomViewHolder(View view) {
            super(view);
            bookTitle = view.findViewById(R.id.bookTitle);
            bookAuthor = view.findViewById(R.id.bookAuthor);
            publisher = view.findViewById(R.id.publisher);
            publishedDate = view.findViewById(R.id.publishedDate);
            description = view.findViewById(R.id.description);
        }
    }
}
