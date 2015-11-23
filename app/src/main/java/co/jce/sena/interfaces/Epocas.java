package co.jce.sena.interfaces;

/**
 * Created by jcarlosj on 17/11/15.
 */
public interface Epocas {

    /*-> Atributos (Comunes)
         Enlaces de petición al webservice
    */
    public static final String URL_LISTAR   = "http://192.168.0.17/taller3/epocas/listar.php";
    public static final String URL_AGREGAR  = "http://192.168.0.17/taller3/epocas/agregar.php";
    public static final String URL_EDITAR   = "http://192.168.0.17/taller3/epocas/editar.php";
    public static final String URL_ELIMINAR = "http://192.168.0.17/taller3/epocas/eliminar.php";

    //-> Campos de la tabla "Epocas"
    public static final String C_ID                 = "id_epoca";
    public static final String C_AUTOR              = "epoca";
    public static final String C_ANIO_NACIMIENTO    = "tiempo_comprendido";

}
