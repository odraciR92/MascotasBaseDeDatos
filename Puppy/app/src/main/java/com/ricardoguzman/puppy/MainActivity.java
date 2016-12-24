package com.ricardoguzman.puppy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ricardoguzman.puppy.adapter.PageAdapter;
import com.ricardoguzman.puppy.fragment.PerfilFragment;
import com.ricardoguzman.puppy.fragment.RecyclerViewFragment;
import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)  findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null)
            setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.btnMasLikes:
                startActivity(new Intent(getApplicationContext(), SegundoActivity.class));
                break;
            case R.id.btnAcercaDe:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                break;
            case R.id.btnContacto:
                startActivity(new Intent(getApplicationContext(), ContactoActivity.class));
                break;
        }


        return true;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),
                agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_huella);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pero_perfil);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
}
