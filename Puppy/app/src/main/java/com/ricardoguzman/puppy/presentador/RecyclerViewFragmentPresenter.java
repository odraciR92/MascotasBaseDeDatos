package com.ricardoguzman.puppy.presentador;

import android.content.Context;

import com.ricardoguzman.puppy.db.ConstructorMascotas;
import com.ricardoguzman.puppy.fragment.IRecyclerViewFragment;
import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ricgu on 23/12/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private ConstructorMascotas constructorMascotas;
    private Context context;
    private IRecyclerViewFragment iRecyclerViewFragment;
    ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(Context context, IRecyclerViewFragment iRecyclerViewFragment) {
        this.context = context;
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptadot(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
