package com.ricardoguzman.puppy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.ricardoguzman.puppy.pojo.Mascota;
import com.ricardoguzman.puppy.R;
import com.ricardoguzman.puppy.adapter.MascotaAdaptador;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasPerfil;


    public PerfilFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);



        mascotas = new ArrayList<Mascota>();

        rvMascotasPerfil = (RecyclerView) view.findViewById(R.id.rvMascotasPerfil);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        rvMascotasPerfil.setLayoutManager(glm);
        initListaContactos();
        initAdapatador();

        CircularImageView imgFotoPerfil = (CircularImageView)  view.findViewById(R.id.imgFotoPerfil);
        TextView tvNombreCvPerfil=(TextView)  view.findViewById(R.id.tvNombreCvPerfil);

        imgFotoPerfil.setImageResource(mascotas.get(0).getFoto());
        tvNombreCvPerfil.setText(mascotas.get(0).getNombre());
        return view;
    }



    public void initListaContactos(){
        mascotas.add(new Mascota("Lucky", ((int) (Math.random() *10 ) + 1) ,false, R.drawable.perro1));
        mascotas.add(new Mascota("Rocky", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro2));
        mascotas.add(new Mascota("Chop", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro3));
        mascotas.add(new Mascota("Rex", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro4));
        mascotas.add(new Mascota("Lobo", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro6));
        mascotas.add(new Mascota("Puppy", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro5));
    }

    public void initAdapatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity(),false);
        rvMascotasPerfil.setAdapter(adaptador);
    }

}
