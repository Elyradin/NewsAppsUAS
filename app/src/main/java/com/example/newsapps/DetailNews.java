package com.example.newsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailNews extends AppCompatActivity {
    TextView juduldet, katdet, isidet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        Intent detailBerita = getIntent();

        String judul = detailBerita.getStringExtra("judul");
        String kategori = detailBerita.getStringExtra("kategori");
        String isi = detailBerita.getStringExtra("isi");

        juduldet = findViewById(R.id.det_judul);
        katdet = findViewById(R.id.det_kategori);
        isidet = findViewById(R.id.det_isi);

        juduldet.setText(judul);
        katdet.setText(kategori);
        isidet.setText(isi);
    }
}