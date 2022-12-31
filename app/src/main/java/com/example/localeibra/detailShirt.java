package com.example.localeibra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailShirt extends AppCompatActivity {

    ImageView detGambar;
    TextView detMerk, detJenis, detPrice, detDesc;

    String namaMerk, namaJenis, namaPrice, namaDesc;
    int fotoPakaian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_shirt);

        detMerk = findViewById(R.id.det_merk);
        detJenis= findViewById(R.id.det_jenis);
        detPrice = findViewById(R.id.price_id);
        detDesc = findViewById(R.id.desc);
        detGambar = findViewById(R.id.det_img);

        //foto pakaian
        Bundle bundle = getIntent().getExtras();
        fotoPakaian = bundle.getInt("foto_pakaian");
        //fotoPakaian = bundle.getInt(String.valueOf("foto_pakaian"));
        detGambar.setImageResource(fotoPakaian);

        getInputExtra();
    }

    private void getInputExtra() {
        namaMerk = getIntent().getStringExtra("nama_merk");
        namaJenis = getIntent().getStringExtra("nama_jenis");
        namaPrice = getIntent().getStringExtra("nama_price");
        namaDesc = getIntent().getStringExtra("nama_desc");

        setDataActivity(namaMerk, namaJenis, namaPrice, namaDesc);

    }

    private void setDataActivity(String namaMerk, String namaJenis, String namaPrice, String namaDesc) {
        detMerk.setText(namaMerk);
        detJenis.setText(namaJenis);
        detPrice.setText(namaPrice);
        detDesc.setText(namaDesc);
    }

    public void addCart(View view) {
        Intent it = new Intent(detailShirt.this, FormData.class );
        startActivity(it);
    }


}

