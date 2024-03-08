package com.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Tab_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.viewpager2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new Tab_Adapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapter);

        /////////////////////////////////////////////
        //Add new tabs from here and change in tab adapter///
        ///////////////////////////////////////////////////
        tabLayout.addTab(tabLayout.newTab().setText("Currency"));
        tabLayout.addTab(tabLayout.newTab().setText("Length"));
        tabLayout.addTab(tabLayout.newTab().setText("Weight"));
        tabLayout.addTab(tabLayout.newTab().setText("Temperature"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}