package com.ricardoguzman.puppy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ricardoguzman.puppy.pojo.Mascota;
import com.ricardoguzman.puppy.R;
import com.ricardoguzman.puppy.adapter.MascotaAdaptador;
import com.ricardoguzman.puppy.presentador.IRecyclerViewFragmentPresenter;
import com.ricardoguzman.puppy.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment{
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        rvMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(getContext(),this);
        return view;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptadot(ArrayList<Mascota> mascotas) {
        return new MascotaAdaptador(mascotas,getActivity(),true);
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
