package com.joyapps.belajartabpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        setViewPagerAdapter();
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("TAB " + (position + 1))).attach();
    }

    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TabOneFragment());
        fragmentList.add(new TabTwoFragment());
        fragmentList.add(new TabThreeFragment());

        viewPager2Adapter.setFragments(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);
    }
}
