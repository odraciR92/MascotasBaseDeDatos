package com.ricardoguzman.puppy.fragment;


import com.ricardoguzman.puppy.adapter.MascotaAdaptador;
import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ricgu on 23/12/2016.
 */

public interface IRecyclerViewFragment {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptadot(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
