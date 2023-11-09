package com.example.finalversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class BookDataSource {
        private SQLiteDatabase database;
        private DatabaseHelper dbHelper;
        private Context context; // Context nesnesi

        public BookDataSource(Context context) {
            this.context = context;
            dbHelper = new DatabaseHelper(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

    public void kitap_ekle(String dbName, String title, String author, String description, byte[] coverImage) {
        SQLiteDatabase database = null;

        try {
            // Veritabanına bağlan
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            database = dbHelper.getWritableDatabase();

            // Kitap bilgilerini eklemek için ContentValues kullan
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_TITLE, title);
            values.put(DatabaseHelper.COLUMN_AUTHOR, author);
            values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);

            // Kapak resmini eklemek isterseniz:

            byte[] coverBlob = coverImage;
            values.put(DatabaseHelper.COLUMN_COVER, coverBlob);

            // Veritabanına veriyi ekle
            database.insert(DatabaseHelper.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

        public List<Book> getAllBooks() {
            List<Book> books = new ArrayList<>();
            Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                int titleIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE);
                int authorIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AUTHOR);
                int descriptionIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION);
                int coverIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_COVER);

                do {
                    int id = cursor.getInt(idIndex);
                    String title = cursor.getString(titleIndex);
                    String author = cursor.getString(authorIndex);
                    String description = cursor.getString(descriptionIndex);
                    byte[] cover = cursor.getBlob(coverIndex);

                    books.add(new Book(id, title, author, description, cover));
                } while (cursor.moveToNext());
                cursor.close();
            }

            return books;
        }
    public void resetDatabase() {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        dbHelper.resetDatabase();
    }
}