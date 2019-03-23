package com.example.firstson;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView menu;
    private TextView txtSearch;
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.list,
            R.drawable.book,
            R.drawable.community,
            R.drawable.user
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        //sự kiện ấn menu thanh ngang
        onClickMenuNavDrawer();
        //sự kiện ấn nút search
        onClickSearchActionBar();
        //sự kiện kéo thanh ngang
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //selected nút home khi lần đầu load app
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft_rep = fm.beginTransaction();
        ft_rep.replace(R.id.fragment_main, new OneFragment());
        ft_rep.commit();
        //sự kiện bấm menun dưới
        onNavigationItemSelected();

    }

    private void anhXa()
    {
        menu = (ImageView) findViewById(R.id.fab);
        txtSearch = (TextView) findViewById(R.id.txtSearch) ;

    }

    private void onNavigationItemSelected()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNav_Bar);
        final Menu menuBot = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()) {
                    case R.id.ichome:
                        fragment=new OneFragment();
                        break;
                    case R.id.icsort:
                        fragment=new TwoFragment();
                        break;
                    case R.id.icbook:
                        menuBot.getItem(2).setChecked(true);
                        fragment=new ThreeFragment();
                        break;
                    case R.id.iccommunity:
                        menuBot.getItem(3).setChecked(true);
                        fragment=new FourFragment();
                        break;
                    case R.id.icuser:
                        menuBot.getItem(4).setChecked(true);
                        fragment=new FiveFragment();
                        break;
                }
                item.setChecked(true);
                if(fragment!=null){
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_main,fragment);
                    fragmentTransaction.commit();
                }
                return false;
            }
        });
    }
    private void onClickSearchActionBar()
    {
        txtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
    private void onClickMenuNavDrawer()
    {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DrawerLayout navDrawer = findViewById(R.id.drawer_layout);
                // If navigation drawer is not open yet open it else close it.
                if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(Gravity.START);
                else navDrawer.closeDrawer(Gravity.END);
            }
        });
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(),"TWO");
        adapter.addFrag(new ThreeFragment(), "three");
        adapter.addFrag(new FourFragment(),"four");
        adapter.addFrag(new FiveFragment(),"five");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNav_Bar);
        final Menu menuBot = bottomNavigationView.getMenu();

        int id = item.getItemId();
        Fragment fragment=null;
        if (id == R.id.nav_home) {
            menuBot.getItem(0).setChecked(true);
            fragment=new OneFragment();

        } else if (id == R.id.nav_sort) {
            menuBot.getItem(1).setChecked(true);
            fragment=new TwoFragment();

        } else if (id == R.id.nav_story) {
            menuBot.getItem(2).setChecked(true);
            fragment=new ThreeFragment();

        } else if (id == R.id.nav_community) {
            menuBot.getItem(3).setChecked(true);
            fragment = new FourFragment();

        }
        if(fragment!=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_main, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
             return null;
        }
    }
}
