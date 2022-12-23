package com.example.newsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListBerita extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Berita> newsArray = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private ArrayList<Berita> ArrayNewsBaru = new ArrayList<>();
    Button add_button;

    String categori;
    int usia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);
        Intent intent = getIntent();
        usia = intent.getIntExtra(DetailUser.MESSAGE_AGE, 1);
        categori = intent.getStringExtra(DetailUser.MESSAGE_KATEGORI);

        addData();

        newsAdapter = new NewsAdapter(this, ArrayNewsBaru);
        recyclerView = findViewById(R.id.rv_berita);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);

        add_button = findViewById(R.id.add);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent berita = new Intent(view.getContext(), AddBeritaActivity.class);
                startActivity(berita);
            }
        });

    }

    private void addData() {
        for (Berita n : newsArray) {
            if (n.getKategori().equals(categori) && n.getAge() <= usia) {
                findViewById(androidx.appcompat.R.id.none).setVisibility(View.GONE);
                ArrayNewsBaru.add(n);
            } else {
                TextView none = findViewById(androidx.appcompat.R.id.none);
                none.setText("Tidak ditemukan");
            }
        }
    }

//    private void filterNews(int umur, String kategory) {
////        ArrayList <Berita> completeNewsAsset = completeNewsAssetclass.berita;
//
//        for (int i = 0; i <= completeNewsAsset.size()-1; i++){
//            Berita hotnews = completeNewsAsset.get(i);
//            if (hotnews.kategori.equals(kategory) && hotnews.age <= umur){
//                newsArray.add(hotnews);
//            }
//            else{
//                continue;
//            }
//        }
//    }

}