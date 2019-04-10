package com.example.julia.com.booksapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.CustomViewHolder> {
    private List<Book> books;

    public BooksAdapter(List<Book> books) {
        this.books = books;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.publisher.setText(book.getPublisher());
        holder.bookAuthor.setText(book.getAuthors().get(0));
        holder.publishedDate.setText(book.getPublishedDate());
        holder.description.setText(book.getDescription());
    }

    @Override
    public int getItemCount() {
        return books.size();

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView bookTitle, bookAuthor, publisher, publishedDate, description;

        public CustomViewHolder(View view) {
            super(view);
            bookTitle = view.findViewById(R.id.bookTitle);
            bookAuthor = view.findViewById(R.id.bookAuthor);
            publisher = view.findViewById(R.id.publisher);
            publishedDate = view.findViewById(R.id.publishedDate);
            description = view.findViewById(R.id.description);
        }
    }
}
