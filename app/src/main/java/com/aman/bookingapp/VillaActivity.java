package com.aman.bookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class VillaActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    SliderPagerAdapter sliderPagerAdapter;
    private TextView[] dots;
    private LinearLayout ll_dots;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villa);

        setTransparentStatusBar(getWindow(), this);

        mViewPager = findViewById(R.id.villa_image);
        ll_dots    = findViewById(R.id.ll_dots);

        ArrayList<Drawable> slider_image_list = new ArrayList<>();

        slider_image_list.add(getDrawable(R.drawable.villa1));
        slider_image_list.add(getDrawable(R.drawable.villa2));
        slider_image_list.add(getDrawable(R.drawable.villa1));
        slider_image_list.add(getDrawable(R.drawable.villa2));



        sliderPagerAdapter = new SliderPagerAdapter(this, slider_image_list);
        mViewPager.setAdapter(sliderPagerAdapter);
        dots = new TextView[slider_image_list.size()];



        addBottomDots(0,dots,ll_dots);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position,dots,ll_dots);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
    private void addBottomDots(int currentPage, TextView[] dots, LinearLayout ll_dots) {

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

    public static void setTransparentStatusBar(Window window, Activity activity){
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.BLACK);
    }
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}