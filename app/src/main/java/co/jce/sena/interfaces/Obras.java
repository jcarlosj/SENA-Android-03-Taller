package co.jce.sena.interfaces;

/**
 * Created by jcarlosj on 17/11/15.
 */
public interface Obras {

    /*-> Atributos (Comunes)
         Enlaces de petición al webservice
    */
    public static final String URL_LISTAR   = "http://192.168.0.17/taller3/obras/listar.php";
    public static final String URL_AGREGAR  = "http://192.168.0.17/taller3/obras/agregar.php";
    public static final String URL_EDITAR   = "http://192.168.0.17/taller3/obras/editar.php";
    public static final String URL_ELIMINAR = "http://192.168.0.17/taller3/obras/eliminar.php";

    //-> Campos de la tabla "Obras"
    public static final String C_ID           = "id_obra";
    public static final String C_TITULO       = "titulo";
    public static final String C_ANIO_EDICION = "anio_edicion";
    public static final String C_ARGUMENTO    = "argumento";
    public static final String C_AUTOR_ID     = "autor_id";
    public static final String C_EPOCA_ID     = "epoca_id";
    public static final String C_GENERO_ID    = "genero_id";

}
