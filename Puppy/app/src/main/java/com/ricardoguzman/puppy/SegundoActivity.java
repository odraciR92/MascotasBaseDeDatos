package com.ricardoguzman.puppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.ricardoguzman.puppy.adapter.MascotaAdaptador;
import com.ricardoguzman.puppy.db.ConstructorMascotas;
import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

public class SegundoActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_activity);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar4);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this);
        mascotas = constructorMascotas.obtenerMascotasFavoritas();

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        rvMascotas.setLayoutManager(llm);
        initAdapatador();
        Toast.makeText(this,"Mascotas favoritas",Toast.LENGTH_SHORT).show();
    }


    public void initAdapatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this,true);
        rvMascotas.setAdapter(adaptador);
    }
}
