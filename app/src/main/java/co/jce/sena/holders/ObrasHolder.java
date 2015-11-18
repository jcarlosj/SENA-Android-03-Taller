package co.jce.sena.holders;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jcarlosj on 17/11/15.
 */
public class ObrasHolder {

    //-> Define los componentes
    private ImageView ivObra;
    private TextView tvTitulo,
                     tvAutor;


    //-> Getters & Setters.
    public ImageView getIvObra() {
        return ivObra;
    }

    public void setIvObra( ImageView ivObra ) {
        this .ivObra = ivObra;
    }

    public TextView getTvTitulo() {
        return tvTitulo;
    }

    public void setTvTitulo( TextView tvTitulo ) {
        this .tvTitulo = tvTitulo;
    }

    public TextView getTvAutor() {
        return tvAutor;
    }

    public void setTvAutor( TextView tvAutor ) {
        this .tvAutor = tvAutor;
    }

}
