package com.aman.bookingapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BestFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Villa> villaArrayList = new ArrayList<>();
    TabsRecyclerAdapter tabsRecyclerAdapter;
    LinearLayoutManager HorizontalLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_best, container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.best_villa_rv);
        ArrayList<Drawable> villa1 = new ArrayList<>();
        if(null != getActivity()) villa1.add(getActivity().getDrawable(R.drawable.villa1));
        if(null != getActivity()) villa1.add(getActivity().getDrawable(R.drawable.villa2));
        if(null != getActivity()) villa1.add(getActivity().getDrawable(R.drawable.villa1));
        if(null != getActivity()) villa1.add(getActivity().getDrawable(R.drawable.villa2));


        ArrayList<Drawable> villa2 = new ArrayList<>();
        if(null != getActivity()) villa2.add(getActivity().getDrawable(R.drawable.villa2));
        if(null != getActivity()) villa2.add(getActivity().getDrawable(R.drawable.villa1));
        if(null != getActivity()) villa2.add(getActivity().getDrawable(R.drawable.villa2));
        if(null != getActivity()) villa2.add(getActivity().getDrawable(R.drawable.villa1));

        villaArrayList.add(new Villa("Villa, Kemah Tinggi","2", "920", "210", villa1));
        villaArrayList.add(new Villa("Villa, Kuta Premiere","2", "1220", "350", villa2));
        villaArrayList.add(new Villa("Birdsong at Asola Farms","2", "620", "100", villa1));
        villaArrayList.add(new Villa("Villa, Kemah Tinggi","2", "920", "210", villa2));
        villaArrayList.add(new Villa("Villa, Kemah Tinggi","2", "920", "210", villa1));
        villaArrayList.add(new Villa("Villa, Kemah Tinggi","2", "920", "210", villa2));

        tabsRecyclerAdapter = new TabsRecyclerAdapter(villaArrayList, getContext(), recyclerView);
        HorizontalLayout
                = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView.setAdapter(tabsRecyclerAdapter);
        tabsRecyclerAdapter.notifyDataSetChanged();

    }

}