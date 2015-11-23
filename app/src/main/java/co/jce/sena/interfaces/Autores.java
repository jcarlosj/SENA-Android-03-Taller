package co.jce.sena.interfaces;

/**
 * Created by jcarlosj on 17/11/15.
 */
public interface Autores {

    /*-> Atributos (Comunes)
         Enlaces de petición al webservice
    */
    public static final String URL_LISTAR   = "http://192.168.0.17/taller3/autores/listar.php";
    public static final String URL_AGREGAR  = "http://192.168.0.17/taller3/autores/agregar.php";
    public static final String URL_EDITAR   = "http://192.168.0.17/taller3/autores/editar.php";
    public static final String URL_ELIMINAR = "http://192.168.0.17/taller3/autores/eliminar.php";

    //-> Campos de la tabla "Autores"
    public static final String C_ID                 = "id_autor";
    public static final String C_AUTOR              = "autor";
    public static final String C_ANIO_NACIMIENTO    = "anio_nacimiento";
    public static final String C_ANIO_FALLECIMIENTO = "anio_fallecimiento";
    public static final String C_LUGAR_NACIMIENTO   = "lugar_nacimiento";
    public static final String C_VIDA               = "vida";
    public static final String C_ESTILO             = "estilo";
    public static final String C_EPOCA_ID           = "epoca_id";

}
