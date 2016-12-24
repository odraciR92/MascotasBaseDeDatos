package com.ricardoguzman.puppy.db;

/**
 * Created by ricgu on 23/12/2016.
 */

public class ConstantesBaseDeDatos {
    public static final String DATABASE_NAME="mascotas";
    public static final int DATABASE_VERSION=1;

    public static final String TABLA_MASCOTA           ="mascota";
    public static final String TABLA_MASCOTA_ID        ="id";
    public static final String TABLA_MASCOTA_NOMBRE    ="nombre";
    public static final String TABLA_MASCOTA_LIKE      ="like";
    public static final String TABLA_MASCOTA_FOTO      ="foto";

    public static final String TABLA_MASCOTA_LIKES     ="mascota_likes";
    public static final String TABLA_MASCOTA_LIKES_ID  ="id" ;
    public static final String TABLA_MASCOTA_LIKES_ID_MASCOTA = "id_mascota";
    public static final String TABLA_MASCOTA_LIKES_NUMERO_LIKES = "numero_likes";
}
