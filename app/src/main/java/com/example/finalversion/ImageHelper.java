package com.example.finalversion;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageHelper {
    private static int[] imageResources = {
            R.drawable.cover_image_1, // Resimleri eklemeye devam edin
            R.drawable.cover_image_2,
            R.drawable.cover_image_3,
            R.drawable.cover_image_4, // Resimleri eklemeye devam edin
            R.drawable.cover_image_5,
            R.drawable.cover_image_6,
            R.drawable.cover_image_7, // Resimleri eklemeye devam edin
            R.drawable.cover_image_8,
            R.drawable.cover_image_9,
            R.drawable.cover_image_10, // Resimleri eklemeye devam edin

            //...
    };


    public static byte[] getImageBytesAtIndex(Resources resources, int index) {
        if (index >= 0 && index < imageResources.length) {
            Bitmap bitmap = BitmapFactory.decodeResource(resources, imageResources[index]);
            return convertBitmapToByteArray(bitmap);
        } else {
            return null;
        }
    }

    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap getImageFromBytes(byte[] bookCover) {
        if (bookCover == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bookCover, 0, bookCover.length);
    }
}