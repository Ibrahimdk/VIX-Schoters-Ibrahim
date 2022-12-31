package com.example.localeibra;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class fragHoodie extends Fragment {
    View v;
    private RecyclerView myrecyclerView;
    private List<tshirtclass> listShirt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.fragment_frag_tshirt,container,false);
        myrecyclerView = (RecyclerView) v.findViewById(R.id.thsirt_rcy);

        initData();
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(new tshirtAdapter((ArrayList<tshirtclass>) listShirt));
        return v;
    }

    public void initData()
    {
        this.listShirt = new ArrayList<>();
        listShirt = new ArrayList<>();
        listShirt.add(new tshirtclass("Lacoste",
                "Oversize","$65","A hoodie is a type of sweatshirt with a hood " +
                "attached to the neckline. It is typically made of a comfortable, " +
                "lightweight fabric such as cotton or a cotton blend",R.drawable.hoodie2));
        listShirt.add(new tshirtclass("Givenchy",
                "Basic","$75","A hoodie is a type of sweatshirt with a hood " +
                "attached to the neckline. It is typically made of a comfortable, " +
                "lightweight fabric such as cotton or a cotton blend" ,R.drawable.hoodie1));
        listShirt.add(new tshirtclass("Gucci",
                "Basic","$32","A hoodie is a type of sweatshirt with a hood " +
                "attached to the neckline. It is typically made of a comfortable, " +
                "lightweight fabric such as cotton or a cotton blend " ,R.drawable.hoodie3));
    }

}