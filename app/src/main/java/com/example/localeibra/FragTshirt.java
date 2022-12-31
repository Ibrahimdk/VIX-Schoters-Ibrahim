package com.example.localeibra;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


//public class FragTshirt extends Fragment {

    //private RecyclerView myrecyclerView;
    //private ArrayList<tshirtclass> listShirt;

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tablayout_custom);
       // myrecyclerView = findViewById(R.id.thsirt_rcy);
        //initData();

        //myrecyclerView.setAdapter(new tshirtAdapter(listShirt));
        //myrecyclerView.setLayoutManager(new LinearLayoutManager(this));
    //}

public class FragTshirt extends Fragment {
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
                "Oversize","$65", "A t-shirt is a casual, short-sleeved shirt made " +
                "of lightweight fabric. It is often made of cotton or a cotton blend, and is designed" +
                " to fit comfortably on the body. T-shirts are popular as everyday wear.",R.drawable.shirt9));
        listShirt.add(new tshirtclass("Givenchy",
                "Basic","$75","A t-shirt is a casual, short-sleeved shirt made " +
                "of lightweight fabric. It is often made of cotton or a cotton blend, and is designed" +
                " to fit comfortably on the body. T-shirts are popular as everyday wear.",R.drawable.shirt7));
        listShirt.add(new tshirtclass("Gucci",
                "Basic","$32","A t-shirt is a casual, short-sleeved shirt made " +
                "of lightweight fabric. It is often made of cotton or a cotton blend, and is designed" +
                " to fit comfortably on the body. T-shirts are popular as everyday wear.",R.drawable.shirt8));
    }


}