package com.example.aspect.aspectjtest001.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.aspect.aoplib.ClassTrace;
import com.example.aspect.aspectjtest001.R;
import com.example.aspect.aspectjtest001.fragment.Fragment1;
import com.example.aspect.aspectjtest001.fragment.Fragment2;
import com.example.aspect.aspectjtest001.fragment.ViewPagerFragment1;
import com.example.aspect.aspectjtest001.fragment.ViewPagerFragment2;
import com.example.aspect.aspectjtest001.fragment.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

@ClassTrace(004)
public class ViewPagerActivity extends AppCompatActivity {

    private static final String TAG = "!!!!MainActivity";
    private ViewPager viewPager;
    private List<Fragment> pages = new ArrayList<>();
    private Fragment page1 = new ViewPagerFragment1();
    private Fragment page2 = new ViewPagerFragment2();
    private ViewPagerFragmentAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViewPager();


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

    }

    private void initViewPager(){
        pages.add(page1);
        pages.add(page2);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(),pages);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
