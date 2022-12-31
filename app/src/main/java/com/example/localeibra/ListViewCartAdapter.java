package com.example.localeibra;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewCartAdapter extends BaseAdapter {
    private List<dataCart> listCart;
    private Context context;
    private SQLiteHelper helper;

    private TextView
            od_brand,
            od_type,
            od_sex,
            od_size,
            od_price;

    private LinearLayout linear;
    private ImageView  hapus;

    public ListViewCartAdapter(List<dataCart> listCart, Context context) {
        this.listCart = listCart;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listCart.size();
    }

    @Override
    public Object getItem(int positon) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_order, null);

        od_brand = v.findViewById(R.id.od_brand);
        od_type = v.findViewById(R.id.od_type);
        od_sex = v.findViewById(R.id.od_sex);
        od_size = v.findViewById(R.id.od_size);
        od_price = v.findViewById(R.id.od_price);
        linear = v.findViewById(R.id.linear);
        hapus = v.findViewById(R.id.ic_delete);

        helper = new SQLiteHelper(context);

        od_brand.setText("Brand : "+listCart.get(position).getBRAND());
        od_type.setText("Type : "+listCart.get(position).getTYPE());
        od_sex.setText("Sex : "+listCart.get(position).getSEX());
        od_size.setText("Size : "+listCart.get(position).getSIZE());
        od_price.setText("Price : "+listCart.get(position).getPRICE());

        linear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent it = new Intent(context, FormData.class);
                it.putExtra("ID", listCart.get(position).getID());
                it.putExtra("BRAND", listCart.get(position).getBRAND());
                it.putExtra("TYPE", listCart.get(position).getTYPE());
                it.putExtra("SEX", listCart.get(position).getSEX());
                it.putExtra("SIZE", listCart.get(position).getSIZE());
                it.putExtra("PRICE", listCart.get(position).getPRICE());
                it.putExtra("TANDA", "Ubah");
                context.startActivity(it);

                return true;
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                alertDialog.setMessage("Apakah anda ingin menhapus item ini?")
                        .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Integer isDelete = helper.deleteData(listCart.get(position).getID());
                                if (isDelete> 0){
                                    Toast.makeText(context, "Data Successfully Deleted", Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(context, "Data Not Deleted", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                            }
                        });
                        alertDialog.show();

            }
        });

        return v;
    }
}
