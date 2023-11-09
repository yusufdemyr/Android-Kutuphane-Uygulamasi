package com.example.finalversion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private int resource;
    private List<Book> books;

    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
        this.context = context;
        this.resource = resource;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }

        ImageView coverImageView = convertView.findViewById(R.id.coverImageView);
        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView authorTextView = convertView.findViewById(R.id.authorTextView);

        Book book = books.get(position);
        if (book != null) {
            // Burada görüntülemeleri güncelleyin
            byte[] coverData = book.getCover();
            if (coverData != null) {
                Bitmap coverBitmap = BitmapFactory.decodeByteArray(coverData, 0, coverData.length);
                coverImageView.setImageBitmap(coverBitmap);
                titleTextView.setText(book.getTitle());
                authorTextView.setText(book.getAuthor());
            } else {
                // Eksik veya null kapak verisi durumu için başka bir işlem yapın.
                // Örneğin varsayılan bir resmi kullanabilir veya boş bir görüntü görüntüleyebilirsiniz.
                coverImageView.setImageResource(R.drawable.default_cover);
                titleTextView.setText(book.getTitle());
                authorTextView.setText(book.getAuthor());
            }


        }


        return convertView;
    }
}