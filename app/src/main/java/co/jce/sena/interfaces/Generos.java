package co.jce.sena.interfaces;

/**
 * Created by jcarlosj on 17/11/15.
 */
public interface Generos {

    /*-> Atributos (Comunes)
         Enlaces de petición al webservice
    */
    public static final String URL_LISTAR   = "http://192.168.0.17/taller3/generos/listar.php";
    public static final String URL_AGREGAR  = "http://192.168.0.17/taller3/generos/agregar.php";
    public static final String URL_EDITAR   = "http://192.168.0.17/taller3/generos/editar.php";
    public static final String URL_ELIMINAR = "http://192.168.0.17/taller3/generos/eliminar.php";

    //-> Campos de la tabla "Epocas"
    public static final String C_ID     = "id_genero";
    public static final String C_GENERO = "genero";

}
