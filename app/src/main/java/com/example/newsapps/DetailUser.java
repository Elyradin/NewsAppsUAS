package com.example.newsapps;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String spinnerText;
    Button send, tambahBerita;
    EditText tanggalLahir, kategorinews;
    int age;

    public static final String MESSAGE_AGE = "key_usia";
    public static final String MESSAGE_KATEGORI = "key_kategori";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        send = findViewById(R.id.btnkirim);
        tambahBerita = findViewById(R.id.btnAdd);
        tanggalLahir = findViewById(R.id.ettanggal);
        kategorinews = findViewById(R.id.etkategori);


        findViewById(R.id.ettanggal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        Spinner spinner = findViewById(R.id.labelspinner);
        ArrayAdapter<CharSequence> adaptor = ArrayAdapter.createFromResource(this, R.array.Kategori, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adaptor);
        spinner.setOnItemSelectedListener(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(DetailUser.this, ListBerita.class);
                kirim.putExtra(MESSAGE_AGE, age);
                kirim.putExtra(MESSAGE_KATEGORI, spinnerText);
                startActivity(kirim);
            }
        });



    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String category = adapterView.getItemAtPosition(i).toString();
        kategorinews = findViewById(R.id.etkategori);
        kategorinews.setText(category);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void showDatePicker() {
        //buat instansiasi
        DialogFragment dateFragment = new DatePickerFrag();
        //ini yang ditampilin
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }
    public void processDatePickerResult(int day, int month, int year) {
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);

        String dateMessage = day_string + "-" + month_string + "-" + year_string;
        EditText input_tanggal = findViewById(R.id.ettanggal);
        input_tanggal.setText(dateMessage);
    }
}