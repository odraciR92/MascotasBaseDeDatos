package com.ricardoguzman.puppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar3);
        setSupportActionBar(miActionBar);

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
}
