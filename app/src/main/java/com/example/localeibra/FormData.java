package com.example.localeibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormData extends AppCompatActivity {
    private EditText psnBrand,
            psnType,
            psnSex,
            psnPrice,
            psnSize;

    private Button buttonConfirm;
    private SQLiteHelper helper;
    private String pilih = "Tambah";
    private String id, brand, type, sex, size, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        psnBrand = findViewById(R.id.psnBrand);
        psnType = findViewById(R.id.psnType);
        psnSex = findViewById(R.id.psnSex);
        psnPrice = findViewById(R.id.psnPrice);
        psnSize = findViewById(R.id.psnSize);
        buttonConfirm = findViewById(R.id.confirmData);

        helper = new SQLiteHelper(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //getSupportActionBar().setTitle("Ubah Data");

            id = bundle.getString("ID");
            brand = bundle.getString("BRAND");
            type = bundle.getString("TYPE");
            sex = bundle.getString("SEX");
            size = bundle.getString("SIZE");
            price = bundle.getString("PRICE");
            pilih = bundle.getString("TANDA");

            psnBrand.setText(brand);
            psnType.setText(type);
            psnSex.setText(sex);
            psnPrice.setText(price);
            psnSize.setText(size);

        } //else {
            //getSupportActionBar().setTitle("Tambah Data");
        //}


        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = psnBrand.getText().toString();
                String type = psnType.getText().toString();
                String sex = psnSex.getText().toString();
                String price = psnPrice.getText().toString();
                String size = psnSize.getText().toString();

                if (TextUtils.isEmpty(brand)) {
                    psnBrand.setError("Must be filled");
                    psnBrand.requestFocus();
                } else if (TextUtils.isEmpty(type)) {
                    psnType.setError("Must be filled");
                    psnType.requestFocus();
                } else if (TextUtils.isEmpty(sex)) {
                    psnSex.setError("Must be filled");
                    psnSex.requestFocus();
                } else if (TextUtils.isEmpty(price)) {
                    psnPrice.setError("Must be filled");
                    psnPrice.requestFocus();
                } else if (TextUtils.isEmpty(size)) {
                    psnSize.setError("Must be filled");
                    psnSize.requestFocus();
                } else {
                    if(pilih.equals("Tambah")){
                        boolean isInsert = helper.insertData(brand,
                                type,
                                sex,
                                price,
                                size);

                        if (isInsert) {
                            Toast.makeText(FormData.this, "Data Saved", Toast.LENGTH_LONG).show();
                            kosong();
                            startActivity(new Intent(FormData.this, Cart.class));
                            finish();
                        } else {
                            Toast.makeText(FormData.this, "Data is not saved", Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(FormData.this, Cart.class));
                            finish();
                        }
                    }else {
                        boolean isUpdate  = helper.updateData(
                                id,
                                brand,
                                type,
                                sex,
                                price,
                                size);

                        if (isUpdate) {
                            Toast.makeText(FormData.this, "Data Succesfully Changed", Toast.LENGTH_LONG).show();
                            kosong();
                            startActivity(new Intent(FormData.this, Cart.class));
                            finish();
                        } else {
                            Toast.makeText(FormData.this, "Data is not saved", Toast.LENGTH_SHORT).show();
                            kosong();
                            startActivity(new Intent(FormData.this, Cart.class));
                            finish();
                        }

                    }
                }
            }

        });

    }

    private void kosong() {
        psnBrand.setText(null);
        psnType.setText(null);
        psnSex.setText(null);
        psnPrice.setText(null);
        psnSize.setText(null);
    }
}