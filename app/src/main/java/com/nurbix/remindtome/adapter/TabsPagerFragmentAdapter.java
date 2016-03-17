package com.nurbix.remindtome.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nurbix.remindtome.fragments.AbstractTabFragment;
import com.nurbix.remindtome.fragments.BirthdaysFragment;
import com.nurbix.remindtome.fragments.HistoryFragment;
import com.nurbix.remindtome.fragments.IdeasFragment;
import com.nurbix.remindtome.fragments.TodoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm){
        super(fm);

        this.context = context;
        initTabMap(context);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, HistoryFragment.getInstance(context));
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdaysFragment.getInstance(context));
    }
}
