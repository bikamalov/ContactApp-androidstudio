package com.example.contact3;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contact3.adapters.ViewPagerAdapter;
import com.example.contact3.fragment.FragmentCalls;
import com.example.contact3.fragment.FragmentContacts;
import com.example.contact3.fragment.FragmentFav;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private final int[] ICONS = {R.drawable.call_fragment, R.drawable.contact_fragment, R.drawable.favorite_fragment};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentCalls(), "Calls");
        adapter.addFragment(new FragmentContacts(), "Contacts");
        //adapter.addFragment(new FragmentFav(), "Add");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < ICONS.length-1; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(ICONS[i]);
        }


    }
}
