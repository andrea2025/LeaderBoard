package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    public static ViewPager viewPager;
    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new LearningLeaderFragment(),"Learning Leaders");
        mViewPagerAdapter.addFragment(new SkillLeaderFragment(),"Skill IQ Leaders");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

//
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            if (tab != null) {
//
//                TextView tabTextView = new TextView(this);
//                tab.setCustomView(tabTextView);
//
//                tabTextView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
//                tabTextView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
//
//
//            }
//
//        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTextColor(Color.WHITE);

                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTextColor(Color.BLUE);

                    }
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
