package com.programandoando.hamp.materialtabs.activity;

/**
 * Created by HAMP on 20/05/2016.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.programandoando.hamp.materialtabs.R;
import com.programandoando.hamp.materialtabs.fragments.FourFragment;
import com.programandoando.hamp.materialtabs.fragments.OneFragment;
import com.programandoando.hamp.materialtabs.fragments.ThreeFragment;
import com.programandoando.hamp.materialtabs.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //1
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons={
           R.drawable.ic_tab_favourite,
           R.drawable.ic_tab_call,
           R.drawable.ic_tab_contacts
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager){

        //Enlazar viewPager ------- adapter
        ViewPagerAdapter adapter=
                new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(),"ONE");
        adapter.addFragment(new TwoFragment(),"TWO");
        adapter.addFragment(new ThreeFragment(),"THREE");
        adapter.addFragment(new FourFragment(),"FOUR");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList=
                new ArrayList<>();
        private final List<String> mFragmentTitleList=
                new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return null;//NULL TAB SOLO APARESCA CON ICONOS
            //return mFragmentTitleList.get(position);
        }



    }
}
