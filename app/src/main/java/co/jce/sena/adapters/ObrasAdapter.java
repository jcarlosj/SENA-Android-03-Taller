package co.jce.sena.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.jce.sena.estructurasdatos.Obra;
import co.jce.sena.holders.ObrasHolder;
import co.jce.sena.taller3.R;

/**
 * Created by jcarlosj on 17/11/15.
 */
public class ObrasAdapter extends ArrayAdapter<Obra> {

    //-> Atributos (Comunes)
    private ArrayList alObras;

    //-> Atributos (Especiales)
    private ObrasHolder obrasHolder;
    private Obra obraPosicion;
    private Context cContexto;

    //-> Define los componentes
    private ImageView ivObra;
    private TextView tvObra,
                     tvAutor;

    //-> Constructor
    public ObrasAdapter( Context contexto, ArrayList<Obra> obras ) {
        super( contexto, 0, obras );     //: super( contexto, recurso, coleccion de objetos );
        this .cContexto = contexto;
        this .alObras = obras;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        //-> Accedemos al objeto "Obra" contenido en el indice indicado del ArrayList
        this .obraPosicion = ( Obra ) this .alObras .get( position );

        //-> Valida si el "View" del "item" del "ListView" NO existe.
        //   En caso de NO existir infla la "View" para el "layout" del "item" nuevo para el "ListView"
        if( convertView == null ) {

            //-> Inflamos la vista del "layout" creado para el despliegue de cada "item" del "ListView" y lo asignamos a la vista.
            convertView = LayoutInflater .from( this .cContexto ) .inflate( R. layout .list_item_obras, null );

            //-> Instanciamos el "holder" para mantener los datos.
            this .obrasHolder = new ObrasHolder();

            //-> Accedemos a los componentes de "list_item_animals.xml"
            //   y se los asignamos al "Holder" para mantenerlos disponibles
            //   Este será el contenedor de las referencias a los componentes de "list_item_animals.xml"
            this .obrasHolder .setIvObra( ( ImageView ) convertView .findViewById( R .id .ivObra ) );
            this .obrasHolder .setTvTitulo( ( TextView ) convertView .findViewById( R .id .tvTitulo ) );
            this .obrasHolder .setTvAutor( ( TextView ) convertView .findViewById( R .id .tvAutor ) );

            //-> Guardamos el "Holder" dentro del "View" para luego poder recuperarlo
            convertView .setTag( this .obrasHolder );

        }

        //-> Reasignamos la referencia de los componentes contenidos en el "View" al "Holder"
        this .obrasHolder = ( ObrasHolder ) convertView .getTag();

        this .obrasHolder .getIvObra() .setImageResource( R .drawable .ic_obra );
        this .obrasHolder .getTvTitulo() .setText( obraPosicion .getTitulo() );
        this .obrasHolder .getTvAutor() .setText( obraPosicion .getAutor() );

        return convertView;
    }
}
