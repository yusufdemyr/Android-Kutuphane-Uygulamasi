package com.example.finalversion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookdetails);

        // Verileri alma
        String bookTitle = getIntent().getStringExtra("bookTitle");
        String bookAuthor = getIntent().getStringExtra("bookAuthor");
        String bookDescription = getIntent().getStringExtra("bookDescription");
        int drawableId = getIntent().getIntExtra("bookCover", -1);

        // layout bilgileri çekme
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView authorTextView = findViewById(R.id.authorTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView coverImageView = findViewById(R.id.coverImageView);

        // bilgileri layout yerleştirme
        titleTextView.setText(bookTitle);
        authorTextView.setText(bookAuthor);
        descriptionTextView.setText(bookDescription);

        // drawableId kontrolü yaparak eğer geçerli bir drawableId varsa bu resmi ImageView'e yerleştir
        if (drawableId != -1) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawableId);
            coverImageView.setImageBitmap(bitmap);
        }
    }



}
