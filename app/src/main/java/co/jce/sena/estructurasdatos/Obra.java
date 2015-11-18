package co.jce.sena.estructurasdatos;

/**
 * Created by jcarlosj on 17/11/15.
 */
public class Obra {

    //-> Atributos (Comunes)
    private int id_obra,
                autor_id,
                epoca_id,
                genero_id;
    private String titulo,
                   anio_edicion,
                   argumento,
                   autor,
                   epoca,
                   genero;

    //-> Constructor
    public Obra( int id_obra, String titulo, int autor_id, int epoca_id, int genero_id, String autor, String epoca, String genero ) {
        this .id_obra = id_obra;
        this .titulo = titulo;
        this .autor_id = autor_id;
        this .epoca_id = epoca_id;
        this .genero_id = genero_id;
        this .autor = autor;
        this .epoca = epoca;
        this .genero = genero;
    }

    //-> Getters & Setters
    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra( int id_obra ) {
        this .id_obra = id_obra;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id( int autor_id ) {
        this .autor_id = autor_id;
    }

    public int getEpoca_id() {
        return epoca_id;
    }

    public void setEpoca_id( int epoca_id ) {
        this .epoca_id = epoca_id;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id( int genero_id ) {
        this .genero_id = genero_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo( String titulo ) {
        this .titulo = titulo;
    }

    public String getAnio_edicion() {
        return anio_edicion;
    }

    public void setAnio_edicion( String anio_edicion ) {
        this .anio_edicion = anio_edicion;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento( String argumento ) {
        this .argumento = argumento;
    }

    //-> Getters & Setters (No pertenecen a la estructura de la tabla)
    public String getAutor() {
        return autor;
    }

    public void setAutor( String autor ) {
        this .autor = autor;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca( String epoca ) {
        this .epoca = epoca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero( String genero ) {
        this.genero = genero;
    }
}
