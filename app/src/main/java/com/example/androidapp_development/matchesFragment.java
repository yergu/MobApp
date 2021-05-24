package com.example.androidapp_development;
import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class matchesFragment extends Fragment {

    public matchesFragment() {
        // Recyller View

    }
    RecyclerView recyclerView;
    List<Model> itemlist;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_matches,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);


        //recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));

        recyclerView.setAdapter(new ItemAdapterMine(itemData()));
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);


        return view;
    }

    private List<Model> itemData() {
        itemlist =new ArrayList<>();
        itemlist.add(new Model(R.drawable.p1,"Kuki"));

        itemlist.add(new Model(R.drawable.p2,"Niksen"));

        itemlist.add(new Model(R.drawable.p3,"Tedi"));

        itemlist.add(new Model(R.drawable.p4,"Ali"));
        return itemlist;







    }}
