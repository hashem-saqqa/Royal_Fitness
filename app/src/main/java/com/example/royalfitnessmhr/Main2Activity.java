package com.example.royalfitnessmhr;

import android.os.Bundle;

import com.example.royalfitnessmhr.ui.advertising.AdvertisingFragment;
import com.example.royalfitnessmhr.ui.bathroom.BathroomFragment;
import com.example.royalfitnessmhr.ui.fitnes.FitnesFragment;
import com.example.royalfitnessmhr.ui.gallery.GalleryFragment;
import com.example.royalfitnessmhr.ui.hlep.HlepFragment;
import com.example.royalfitnessmhr.ui.home.HomeFragment;
import com.example.royalfitnessmhr.ui.masag.MasagFragment;
import com.example.royalfitnessmhr.ui.salary.SalaryFragment;
import com.example.royalfitnessmhr.ui.send.SendFragment;
import com.example.royalfitnessmhr.ui.share.ShareFragment;
import com.example.royalfitnessmhr.ui.shareuit.ShareuitFragment;
import com.example.royalfitnessmhr.ui.slideshow.SlideshowFragment;
import com.example.royalfitnessmhr.ui.startec.StartecFragment;
import com.example.royalfitnessmhr.ui.time.TimeFragment;
import com.example.royalfitnessmhr.ui.tools.ToolsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener {

Fragment fragment;
    RecyclerView recyclerView;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);



       /* Fragment fragment = new Fragment();
        loadFragment(fragment);*/

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(        this,drawerLayout
                ,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close

        );
        drawer.setDrawerListener(toggle);
        toggle.syncState();




        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_salary , R.id.nav_time, R.id.nav_Advertising ,
                R.id.nav_help , R.id.nav_share1, R.id.nav_share2, R.id.nav_share3 ,R.id.navigation_home , R.id.navigation_dashboard)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        LayoutInflater inflater = getLayoutInflater();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications ,R.id.navigation_notificationo,R.id.navigation_notification)
                .build();

        BottomNavigationView navigationView1 = findViewById(R.id.nav_vieww);
        NavigationUI.setupWithNavController(navigationView1,navController);
        navigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            private boolean loadFragment(Fragment fragment)
            {
               if(fragment != null)
               {
                   getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,fragment).commit();
                   return true;
               }
               return false;

            }
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.navigation_home:
                    fragment =new HomeFragment();
                    break;
                    case R.id.navigation_dashboard:
                        fragment =new GalleryFragment();
                        break;
                    case R.id.navigation_notifications:
                        fragment =new MasagFragment();
                        break;
                    case R.id.navigation_notificationo:
                        fragment =new BathroomFragment();
                        break;
                    case R.id.navigation_notification:
                        fragment =new MasagFragment();
                        break;


                }
                return loadFragment(fragment);
            }
        });



       /* recyclerView = findViewById(R.id.rc_kapten);
        ArrayList<kapten> kaptens = new ArrayList<>();
        kaptens.add(new kapten(R.drawable.g,"محمةد حسونة"));
        kaptens.add(new kapten(R.drawable.g,"محمةد حسونة"));
        kaptenadapter adapter = new kaptenadapter(kaptens);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);*/


    }
    private void loadFragment(Fragment fragment) {
        //
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin the transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // We can add,replace or remove the fragments from the container layout
        fragmentTransaction.replace(R.id.linearlayout, fragment);

        // Complete the changes added above
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home)
        {
            fragment = new HomeFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id == R.id.nav_gallery)
        {
            fragment = new GalleryFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_send)
        {
            fragment = new SendFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_share)
        {
            fragment = new ShareFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_slideshow)
        {
            fragment = new SlideshowFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
         else if (id== R .id.nav_tools)
        {
            fragment = new ToolsFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
       else if (id== R .id.nav_time)
        {
            fragment = new TimeFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_salary)
        {
            fragment = new SalaryFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_startec)
        {
            fragment = new StartecFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_Advertising)
        {
            fragment = new AdvertisingFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R .id.nav_shareit)
        {
            fragment = new ShareuitFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }
        else if (id== R.id.nav_help)
        {
            fragment = new HlepFragment();
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction mm =m.beginTransaction();
            mm.replace(R.id.drawer_layout,fragment);
            mm.commit();
        }






            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return  true;

    }



}