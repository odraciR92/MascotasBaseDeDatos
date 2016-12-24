package com.ricardoguzman.puppy.db;

import android.content.ContentValues;
import android.content.Context;

import com.ricardoguzman.puppy.R;
import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ricgu on 23/12/2016.
 */

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context){
        this.context=context;
    }

    public ArrayList<Mascota> obtenerMascotas(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Lucky");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Rocky");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Chop");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Rex");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro4);

        db.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Puppy");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro5);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE,"Lobo");
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE,0);
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO,R.drawable.perro6);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_NUMERO_LIKES,1);

        db.insertarLikeMascota(contentValues);
    }

    public void quitarLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_NUMERO_LIKES,-1);

        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerLikesMascota(mascota);
    }
}
