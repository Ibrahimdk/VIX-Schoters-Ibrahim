package com.example.localeibra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.database.Cursor;
import android.os.Bundle;

import android.widget.ListView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private ListView list_view;
    private ListViewCartAdapter adapter;
    private ArrayList<dataCart> listCart = new ArrayList<>();
    private SQLiteHelper helper;
    private SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        list_view = findViewById(R.id.cart_list_view);
        refresh = findViewById(R.id.refresh);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                menampilkanData();
            }
        });

        helper = new SQLiteHelper(this);

        menampilkanData();
    }


    private void menampilkanData(){
        listCart.clear();
        Cursor res = helper.getDataAll();
        refresh.setRefreshing(true);
        while (res.moveToNext()) {
            String id = res.getString(0);
            String brand = res.getString(1);
            String type = res.getString(2);
            String sex = res.getString(3);
            String size = res.getString(4);
            String price = res.getString(5);

            listCart.add(new dataCart(
                    id,
                    brand,
                    type,
                    sex,
                    size,
                    price));

        }
        adapter = new ListViewCartAdapter(listCart,Cart.this);
        list_view.setAdapter(adapter);
        refresh.setRefreshing(false);

    }
}