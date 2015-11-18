package co.jce.sena.operaciones;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import co.jce.sena.estructurasdatos.Obra;
import co.jce.sena.taller3.R;

/**
 * Created by jcarlosj on 18/11/15.
 */
public class CRUDObras {

    //-> Atributos (Comunes)
    private Context contexto;
    private View view;
    private ArrayList<Obra> alObra;

    //-> Atributos (Especiales)
    private AlertDialog .Builder adbVentana;
    private Dialog dialog;

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

        //-> Se instancia (crea) la ventana de dialogoObra
        adbVentana = new AlertDialog.Builder( contexto );

        //-> Se dan características a la ventana de dialogo una vez creada.
        adbVentana .setView( view )                                                    //: Se agrega el layout con el formulario a la ventana.
                   .setTitle( view .getResources().getString( R .string .agregar_obra ) )  //: Se agrega un título a la ventana
                        //-> Acciones para el botón GUARDAR
                   .setPositiveButton(
                           view. getResources().getString( R .string .guardar ),
                           new DialogInterface.OnClickListener() {

                               public void onClick(DialogInterface dialog, int which) {
                                    //insertar();
                               }

                           }
                   )
                        //-> Acciones para el botón CANCELAR
                   .setNeutralButton(
                           view .getResources() .getString(R.string.cancelar),
                           new DialogInterface.OnClickListener() {

                               public void onClick(DialogInterface dialog, int which) {
                                   Toast.makeText( contexto .getApplicationContext(), "No enviaría nada.", Toast.LENGTH_SHORT ) .show();
                               }

                           }
                   );

        //-> Se crea y muestra la ventana.
        dialog = adbVentana .create();
        dialog .show();

    }

}
