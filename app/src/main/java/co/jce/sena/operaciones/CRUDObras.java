package co.jce.sena.operaciones;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import co.jce.sena.estructurasdatos.Autor;
import co.jce.sena.estructurasdatos.Obra;
import co.jce.sena.taller3.R;
import co.jce.sena.tasks.ListarAutores;
import co.jce.sena.tasks.ListarEpocas;
import co.jce.sena.tasks.ListarGeneros;

/**
 * Created by jcarlosj on 18/11/15.
 */
public class CRUDObras {

    //-> Atributos (Comunes)
    private Context contexto;
    private View view;
    private ArrayList<Obra> alObra;

    private ArrayList<String> alSpinner;

    //-> Atributos (Especiales)
    private AlertDialog .Builder adbVentana;
    private Dialog dialog;
    private ArrayAdapter<String> dataAdapter;

    //-> Define los componentes
    private Spinner spnAutor,
                    spnEpoca,
                    spnGenero;

    //-> Constructor
    public CRUDObras( Context contexto ) {
        this .contexto = contexto;

    }

    //-> Lanza una lista sencilla de selección con las opciones disponibles a realizar
    public void opciones( final View view, final int posicion, ArrayList<Obra> alObra ) {

        //-> Agrega los valores relevantes para hacerlos accesibles a todos los métodos
        //   de la clase.
        this .alObra = alObra;
        this .view = view;

        //-> Se instancia (crea) la ventana de dialogo
        adbVentana = new AlertDialog.Builder( contexto );

        //-> Se dan características a la ventana de dialogo una vez creada.
        adbVentana .setTitle( R.string .opciones )
                .setItems( R .array .acciones, new DialogInterface.OnClickListener() {
                    public void onClick( DialogInterface dialog, int which ) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        if ( which == 0 ) {
                            agregarVentana( view );
                            Toast.makeText( contexto, "Elegiste agregar", Toast.LENGTH_SHORT) .show();
                        }
                        if ( which == 1 ) {
                            Toast .makeText( contexto, "Elegiste editar", Toast .LENGTH_SHORT ) .show();
                        }
                        if ( which == 2 ) {
                            Toast .makeText( contexto, "Elegiste mostrar", Toast .LENGTH_SHORT ) .show();
                        }
                        if ( which == 3 ) {
                            Toast .makeText( contexto, "Elegiste eliminar", Toast .LENGTH_SHORT ) .show();
                        }
                        if ( which == 4 ) {
                            Toast .makeText( contexto, "Elegiste cancelar", Toast .LENGTH_SHORT ) .show();
                        }
                    }
                });

        //-> Se crea y muestra la ventana.
        dialog = adbVentana .create();
        dialog .show();
    }

    private void agregarVentana( View view ) {

        //-> Infla el layout personalizado con el formulario
        view = ( LayoutInflater.from( contexto ) ) .inflate( R .layout .layout_add_obra, null );

        //-> Agrega los datos de Autor al Spinner
        Log .i( "CRUDObras", ">>>>> >>>>> >>>>> Spinners <<<<< <<<<<< <<<<<<" );
        cargarSpinnerAutores( view );
        cargarSpinnerEpocas( view );
        cargarSpinnerGeneros( view );

        //-> Se instancia (crea) la ventana de dialogoObra
        adbVentana = new AlertDialog.Builder( contexto );

        //-> Se dan características a la ventana de dialogo una vez creada.
        adbVentana .setView( view )                                                 //: Se agrega el layout con el formulario a la ventana.
                   .setTitle(view.getResources().getString(R.string.agregar_obra))  //: Se agrega un título a la ventana
                        //-> Acciones para el botón GUARDAR
                   .setPositiveButton(
                           view.getResources().getString(R.string.guardar),
                           new DialogInterface.OnClickListener() {

                               public void onClick(DialogInterface dialog, int which) {
                                   //insertar();
                               }

                           }
                   )
                        //-> Acciones para el botón CANCELAR
                   .setNeutralButton(
                           view.getResources().getString(R.string.cancelar),
                           new DialogInterface.OnClickListener() {

                               public void onClick(DialogInterface dialog, int which) {
                                   Toast.makeText(contexto.getApplicationContext(), "No enviaría nada.", Toast.LENGTH_SHORT).show();
                               }

                           }
                   );

        //-> Se crea y muestra la ventana.
        dialog = adbVentana .create();
        dialog .show();

    }

    private void cargarSpinnerAutores( View view ) {

        //-> Declaramos variables locales
        String autores[] = null;
        String salida = null;
        alSpinner = null;

        //-> Accedo al componente "Spinner" donde se cargarán los datos.
        spnAutor = ( Spinner ) view .findViewById( R .id .spnAutor );

        //-> Ejecuto mi Tarea Asincrona ListarEmpleados y le paso el parámetro
        ListarAutores cadena = ( ListarAutores ) new ListarAutores( contexto ) .execute();

        try {
            //-> Obtengo el valor de retorno de mi tarea asíncrona.
            salida = cadena.get();
            Log.i("CRUDObras", "Autores: " + salida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //-> Valida si la cadena de retorno esta vacia.
        if( salida != "" ) {
            //-> Segmenta la cadena obtenida de la Base de Datos
            ProcesarDatos pDatos = new ProcesarDatos();
            pDatos .segmentar( salida, 2 );
            alSpinner = pDatos .getArrayListData( 1 );     //: Obtiene un array para el despliegue del "Spinner"

            //-> Crea el adaptador para el "Spinner" y su "layout" de "item" por defecto
            //   Y puebla de datos el "Adapter"
            this .dataAdapter = new ArrayAdapter<String>( contexto, android . R .layout .simple_spinner_item, alSpinner );

            // Despliega el diseño predeterminado del layout
            this .dataAdapter .setDropDownViewResource( android .R .layout .simple_spinner_dropdown_item );

            // Asocia el "Adapter" al "Spinner" donde se desplegarán los datos
            spnAutor .setAdapter( this .dataAdapter );
        }

    }

    private void cargarSpinnerEpocas( View view ) {

        //-> Declaramos variables locales
        String epocas[] = null;
        String salida = null;
        alSpinner = null;

        //-> Accedo al componente "Spinner" donde se cargarán los datos.
        spnEpoca = ( Spinner ) view .findViewById( R .id .spnEpoca );

        //-> Ejecuto mi Tarea Asincrona ListarEmpleados y le paso el parámetro
        ListarEpocas cadena = ( ListarEpocas ) new ListarEpocas( contexto ) .execute();

        try {
            //-> Obtengo el valor de retorno de mi tarea asíncrona.
            salida = cadena.get();
            Log.i("CRUDObras", "Epocas: " + salida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //-> Valida si la cadena de retorno esta vacia.
        if( salida != "" ) {

            //-> Segmenta la cadena obtenida de la Base de Datos
            ProcesarDatos pDatos = new ProcesarDatos();
            pDatos .segmentar( salida, 2 );
            alSpinner = pDatos .getArrayListData( 1 );     //: Obtiene un array para el despliegue del "Spinner"

            //-> Crea el adaptador para el "Spinner" y su "layout" de "item" por defecto
            //   Y puebla de datos el "Adapter"
            this .dataAdapter = new ArrayAdapter<String>( contexto, android . R .layout .simple_spinner_item, alSpinner );

            // Despliega el diseño predeterminado del layout
            this .dataAdapter .setDropDownViewResource( android .R .layout .simple_spinner_dropdown_item );

            // Asocia el "Adapter" al "Spinner" donde se desplegarán los datos
            spnEpoca .setAdapter( this .dataAdapter );
        }

    }

    private void cargarSpinnerGeneros( View view ) {

        //-> Declaramos variables locales
        String autores[] = null;
        String salida = null;
        alSpinner = null;

        //-> Accedo al componente "Spinner" donde se cargarán los datos.
        spnGenero = ( Spinner ) view .findViewById( R .id .spnGenero );

        //-> Ejecuto mi Tarea Asincrona ListarEmpleados y le paso el parámetro
        ListarGeneros cadena = ( ListarGeneros ) new ListarGeneros( contexto ) .execute();

        try {
            //-> Obtengo el valor de retorno de mi tarea asíncrona.
            salida = cadena.get();
            Log.i( "CRUDObras", "Epocas: " + salida );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //-> Valida si la cadena de retorno esta vacia.
        if( salida != "" ) {
            //-> Segmenta la cadena obtenida de la Base de Datos
            ProcesarDatos pDatos = new ProcesarDatos();
            pDatos .segmentar( salida, 2 );
            alSpinner = pDatos .getArrayListData( 1 );     //: Obtiene un array para el despliegue del "Spinner"

            //-> Crea el adaptador para el "Spinner" y su "layout" de "item" por defecto
            //   Y puebla de datos el "Adapter"
            this .dataAdapter = new ArrayAdapter<String>( contexto, android . R .layout .simple_spinner_item, alSpinner );

            // Despliega el diseño predeterminado del layout
            this .dataAdapter .setDropDownViewResource( android .R .layout .simple_spinner_dropdown_item );

            // Asocia el "Adapter" al "Spinner" donde se desplegarán los datos
            spnGenero .setAdapter( this .dataAdapter );
        }

    }


}
