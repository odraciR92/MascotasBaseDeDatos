package com.ricardoguzman.puppy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ricardoguzman.puppy.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ricgu on 23/12/2016.
 */

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDeDatos.DATABASE_NAME,
                null, ConstantesBaseDeDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qryCreaTablaContacto="CREATE TABLE "+ConstantesBaseDeDatos.TABLA_MASCOTA+" (" +
                ConstantesBaseDeDatos.TABLA_MASCOTA_ID         +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDeDatos.TABLA_MASCOTA_NOMBRE     +" TEXT, "+
                ConstantesBaseDeDatos.TABLA_MASCOTA_LIKE      +" INTEGER, "+
                ConstantesBaseDeDatos.TABLA_MASCOTA_FOTO       +" INTEGER "+
                ")";

        String qryCreaTablaLikesContacto="CREATE TABLE "+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES+" (" +
                ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID               +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA       +" INTEGER, "+
                ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_NUMERO_LIKES     +" INTEGER, "+
                "FOREIGN KEY("+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA+") "+
                "REFERENCES "+ConstantesBaseDeDatos.TABLA_MASCOTA+"("+ConstantesBaseDeDatos.TABLA_MASCOTA_ID+")"+
                ")";
        db.execSQL(qryCreaTablaContacto);
        db.execSQL(qryCreaTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDeDatos.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String qrySelectMascotas= "SELECT * FROM "+ConstantesBaseDeDatos.TABLA_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(qrySelectMascotas,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setLike((registros.getInt(2)==1)?true:false);
            mascotaActual.setFoto(registros.getInt(3));

            mascotaActual.setLikes(obtenerLikesMascota(mascotaActual));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String qrySelectMascotas= "SELECT COUNT(*) AS cuenta, mascota."+ConstantesBaseDeDatos.TABLA_MASCOTA_ID+
                                  " FROM "+ConstantesBaseDeDatos.TABLA_MASCOTA+" mascota, "+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES+" likes"+
                                  " WHERE mascota."+ConstantesBaseDeDatos.TABLA_MASCOTA_ID+"= likes."+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA+
                                  " GROUP BY mascota."+ConstantesBaseDeDatos.TABLA_MASCOTA_ID+
                                  " ORDER BY cuenta DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(qrySelectMascotas,null);

        while (registros.moveToNext()){
           mascotas.add(obtenerMascotaPorId(registros.getInt(1)));
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDeDatos.TABLA_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes =0;

        String qryLikes = "SELECT COUNT("+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_NUMERO_LIKES+")"+
                          " FROM "+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES+
                          " WHERE "+ConstantesBaseDeDatos.TABLA_MASCOTA_LIKES_ID_MASCOTA+
                          "="+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(qryLikes,null);

        while (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public Mascota obtenerMascotaPorId(int id){
        Mascota mascotaActual = new Mascota();
        String qrySelectMascotas= "SELECT * "+
                " FROM "+ConstantesBaseDeDatos.TABLA_MASCOTA+
                " WHERE "+ConstantesBaseDeDatos.TABLA_MASCOTA_ID+"="+id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros2 = db.rawQuery(qrySelectMascotas,null);
        while (registros2.moveToNext()){
            mascotaActual.setId(registros2.getInt(0));
            mascotaActual.setNombre(registros2.getString(1));
            mascotaActual.setLike((registros2.getInt(2)==1)?true:false);
            mascotaActual.setFoto(registros2.getInt(3));

            mascotaActual.setLikes(obtenerLikesMascota(mascotaActual));
        }
        return mascotaActual;
    }


}
