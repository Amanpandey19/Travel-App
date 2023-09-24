package com.aman.bookingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kharag on 19-03-2020.
 */
public class TabsRecyclerAdapter extends RecyclerView.Adapter<TabsRecyclerAdapter.ViewHolder> {
    Context context;
    List<Villa> mList;


    RecyclerView mRecyclerView;


    public TabsRecyclerAdapter(List<Villa> mList, Context context, RecyclerView recyclerView) {
        this.mList=mList;
        this.context=context;
        this.mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.villaName.setText(mList.get(position).getName());
        holder.bedroom.setText(mList.get(position).getBedroom() + " Bed Rooms");
        holder.cost.setText("$ " + mList.get(position).getCostPerRoom());
        holder.area.setText(mList.get(position).getArea()+" m");

        ArrayList<Drawable> slider_image_list = new ArrayList<>();

        slider_image_list = mList.get(position).getVilla_images();


        holder.sliderPagerAdapter = new SliderPagerAdapter(context, slider_image_list);
        holder.mViewPager.setAdapter(holder.sliderPagerAdapter);
        holder.dots = new TextView[slider_image_list.size()];

        holder.containerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VillaActivity.class);
                context.startActivity(intent);
            }
        });

        addBottomDots(0,holder.dots,holder);
        holder.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position,holder.dots,holder);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addBottomDots(int currentPage, TextView[] dots,ViewHolder holder) {

        holder.ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            holder.ll_dots.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView villaName;
        TextView area;
        TextView bedroom;
        TextView cost;
        private ViewPager mViewPager;
        SliderPagerAdapter sliderPagerAdapter;
        private TextView[] dots;
        private LinearLayout ll_dots;
        ConstraintLayout containerLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mViewPager  =  itemView.findViewById(R.id.villa_image);
            ll_dots     =  itemView.findViewById(R.id.ll_dots);
            villaName   =  itemView.findViewById(R.id.villa_name);
            area        =  itemView.findViewById(R.id.square_text);
            bedroom     =  itemView.findViewById(R.id.bed_text);
            cost        =  itemView.findViewById(R.id.villa_price);
            containerLayout = itemView.findViewById(R.id.container_item);


        }
    }
}
