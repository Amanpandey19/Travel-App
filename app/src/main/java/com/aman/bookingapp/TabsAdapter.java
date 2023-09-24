package com.aman.bookingapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsAdapter extends FragmentStateAdapter {


    public TabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new PopularFragment();
            case 2:
                return new ImmediateFragment();
            case 3:
                return new NewFragment();
            case 4:
                return new ProfitableFragment();
                default:
                    return new BestFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
