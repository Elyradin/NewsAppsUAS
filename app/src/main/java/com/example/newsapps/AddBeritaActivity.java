package com.example.newsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBeritaActivity extends AppCompatActivity {
    EditText judulBerita, isiBerita, umur,kategorinews;
    Spinner spinnerText;
    Button kirimBerita;

    DatabaseReference mDatabaseReference;
    Berita berita;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_berita);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Berita.class.getSimpleName());

        judulBerita = findViewById(R.id.jdulBerita);
        isiBerita = findViewById(R.id.isiBerita);
        umur = findViewById(R.id.umur);
        spinnerText = findViewById(R.id.labelspinner);
        kirimBerita = findViewById(R.id.btn_send);
        kategorinews = findViewById(R.id.etkategori);


        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

    }

    private void insertData() {
//        Berita newBerita = new Berita();
//        String judul = judulBerita.getText().toString();
//        String isi = isiBerita.getText().toString();
//        Integer usia = Integer.valueOf(umur.getText().toString());
//        String categori = kategorinews.getText().toString();
//
//        if (judul != "" && isi!= ""){
//            newBerita.setJudul(judul);
//            newBerita.setAge(usia);
//            newBerita.setKategori(categori);
//            newBerita.setIsi(isi);
//
//            mDatabaseReference.push().setValue(newBerita);
//            Toast.makeText(this, "Successfully insert data!", Toast.LENGTH_SHORT).show();
//        }
    }
}