package com.example.finalversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.CursorWindow;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
    private static final boolean DEBUG_MODE = false;
    private BookDataSource dataSource;
    private List<Book> bookList;
    private ListView listView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Veritabanını sıfırla
        BookDataSource bookDataSource = new BookDataSource(this);
        bookDataSource.resetDatabase();

        dataSource = new BookDataSource(this);
        dataSource.open();
        // Resim kaynağını belirle

        byte[] firstImageBytes = ImageHelper.getImageBytesAtIndex(getResources(), 0);
        byte[] firstImageBytes2 = ImageHelper.getImageBytesAtIndex(getResources(), 1);
        byte[] firstImageBytes3 = ImageHelper.getImageBytesAtIndex(getResources(), 2);
        byte[] firstImageBytes4 = ImageHelper.getImageBytesAtIndex(getResources(), 3);
        byte[] firstImageBytes5 = ImageHelper.getImageBytesAtIndex(getResources(), 4);
        byte[] firstImageBytes6 = ImageHelper.getImageBytesAtIndex(getResources(), 5);
        byte[] firstImageBytes7 = ImageHelper.getImageBytesAtIndex(getResources(), 6);
        byte[] firstImageBytes8 = ImageHelper.getImageBytesAtIndex(getResources(), 7);
        byte[] firstImageBytes9 = ImageHelper.getImageBytesAtIndex(getResources(), 8);
        byte[] firstImageBytes10 = ImageHelper.getImageBytesAtIndex(getResources(), 9);

        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {
            if (DEBUG_MODE) {
                e.printStackTrace();
            }
        }

        BookDataSource kitapVeritabani = new BookDataSource(this);
        kitapVeritabani.kitap_ekle("bookList.db", "Harry Potter ve Felsefe Taşı", "J.K. Rowling", "Büyüleyici bir dünyada geçen, genç sihirbaz Harry Potter'ın arkadaşlık, cesaret ve büyüyle dolu epik macerasını keşfedin. Hogwarts Büyücülük Okulu'ndaki eşsiz deneyimleriyle Harry, karanlık güçlere karşı savaşırken okurlara unutulmaz bir yolculuk sunar.", firstImageBytes);
        kitapVeritabani.kitap_ekle("bookList.db", "Sefiller", "Victor Hugo", "Fransız Devrimi döneminde geçen bu klasik eser, eski mahkum Jean Valjean'ın yaşam mücadelesini ve onunla etkileşime giren diğer karakterlerin öykülerini içeriyor. Adaletsizlik, umut ve insanlık temalarını işleyen bu kitap, edebi bir başyapıt olarak kabul edilir.", firstImageBytes2);
        kitapVeritabani.kitap_ekle("bookList.db", "Sonsuzluğun Sonu", "Isaac Asimov", "Bilim kurgu dehası Isaac Asimov'un Vakıf serisinin bir parçası olan bu kitap, galaktik imparatorluğun çöküşünü ve gelecekteki bir bilim adamları grup tarafından kurulan Vakıf'ın hikayesini anlatır. Asimov'un öngörüsü ve derinlikli karakterleriyle bilim kurgu hayranlarını cezbeder.", firstImageBytes3);
        kitapVeritabani.kitap_ekle("bookList.db", "1984", "George Orwell", "Distopik bir gelecekteki totaliter rejimi konu alan 1984, bireyin özgürlüğüne karşı devletin baskısını çarpıcı bir şekilde tasvir eder. George Orwell'ın politik bir uyarı niteliğindeki bu eseri, düşünce özgürlüğü ve toplumsal kontrol üzerine derin düşündürücü bir analiz sunar.", firstImageBytes4);
        kitapVeritabani.kitap_ekle("bookList.db", "Suç ve Ceza", "Fyodor Dostoyevski", "Bu klasik roman, yoksulluk, suç, ceza ve ahlaki çatışmaları ele alarak insan psikolojisinin derinliklerine iner. Raskolnikov'un içsel çatışmalarını ve suç işlemenin ağırlığıyla başa çıkma çabalarını anlatan Dostoyevski'nin başyapıtlarından biridir.", firstImageBytes5);
        kitapVeritabani.kitap_ekle("bookList.db", "Yüzüklerin Efendisi", "J.R.R. Tolkien", "Orta Dünya'nın epik yolculuğunu takip eden bu üçleme, Frodo'nun Yüzük'ü yok etme görevini üstlenmesiyle başlar. Tolkien'ın yaratıcı mitolojisi, karakter derinliği ve destansı atmosferiyle okurları büyüler.", firstImageBytes6);
        kitapVeritabani.kitap_ekle("bookList.db", "Jane Eyre", "Charlotte Brontë", "Bir yetim kızın zorlu yaşamı ve aşk arayışını konu alan bu klasik roman, kadın karakterlerin güçlenmesi ve kendi kimliklerini bulmalarını vurgular. Jane Eyre'in güçlü karakteri ve romantik ögeleriyle unutulmaz bir eser.", firstImageBytes7);
        kitapVeritabani.kitap_ekle("bookList.db", "Bülbülü Öldürmek", "Harper Lee", "Rassizm ve adalet temalarını işleyen bu Amerikan klasigi, çocuk bakış açısından toplumsal sorunlara duyarlı bir yaklaşım sunar. Küçük bir kız olan Scout'un gözünden anlatılan hikaye, ırk ayrımcılığına karşı mücadeleyi anlatır.", firstImageBytes8);
        kitapVeritabani.kitap_ekle("bookList.db", "Şeker Portakalı", "José Mauro de Vasconcelos", "Brezilya'da geçen bu dokunaklı hikaye, bir çocuğun zorluklarla dolu yaşamını ve umudu keşfetmesini anlatır. Zeze'nin masumiyeti ve güçlü dostluk temasıyla, okurlara duygusal bir deneyim sunar.", firstImageBytes9);
        kitapVeritabani.kitap_ekle("bookList.db", "Karamazov Kardeşler", "Fyodor Dostoyevski", "Bu Rus edebiyatının başyapıtlarından biri, ahlaki çatışmalar, aşk ve aile ilişkilerini derinlemesine işler. Dostoyevski'nin karakter analizi ve insan doğası üzerine felsefi düşünceleriyle dolu olan bu roman, edebi zenginliğiyle öne çıkar.", firstImageBytes10);

        listView = findViewById(R.id.listView);
        bookList = dataSource.getAllBooks();
        adapter = new BookAdapter(this, R.layout.list_item, bookList);
        listView.setAdapter(adapter);

        // Adding click listener to the ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected book
            Book selectedBook = bookList.get(position);

            // Get the index of the selected book
            int selectedIndex = position;

            // Get the resource identifier for the drawable
            int drawableId = getResources().getIdentifier("cover_image_" + (selectedIndex + 1), "drawable", getPackageName());


            // Create an intent to switch to a new activity
            Intent intent = new Intent(MainActivity.this, BookDetails.class);

            // Pass data to the new activity if needed
            intent.putExtra("bookTitle", selectedBook.getTitle());
            intent.putExtra("bookAuthor", selectedBook.getAuthor());

            intent.putExtra("bookCover", drawableId); // Pass the drawable resource ID

            intent.putExtra("bookDescription", selectedBook.getDescription());
            // ... add more data as needed

            // Start the new activity
            startActivity(intent);
        });


    }



    @Override
    protected void onDestroy() {
        dataSource.close();
        super.onDestroy();

    }
}