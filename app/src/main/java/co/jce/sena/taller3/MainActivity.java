package co.jce.sena.taller3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import co.jce.sena.adapters.ObrasAdapter;
import co.jce.sena.estructurasdatos.Obra;
import co.jce.sena.operaciones.CRUDObras;
import co.jce.sena.operaciones.Convertir;
import co.jce.sena.tasks.ListarObras;

public class MainActivity extends AppCompatActivity {

    //-> Define los componentes
    private ListView lvObras;

    //-> Atributos (Comunes)
    private ArrayList<Obra> alObra;
    private ArrayList<String[]> alObras;
    private ObrasAdapter adaptadorObras;
    private CRUDObras crudObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        //-> Declaramos variables locales
        ArrayList<Obra> existenRegistros = null;
        crudObras = new CRUDObras( this );     //: Instancia para el CRUD

        //-> Accedemos a los componentes del "Activity".
        lvObras = ( ListView ) findViewById( R .id .lvObras );      //: ListView

        if( mostrarObras() == null ) {
            Toast.makeText( this, "No hay registros", Toast.LENGTH_SHORT ) .show();
        }
        else {
            mostrarObras();

            //-> Instanciamos el Adaptador.
            //   Asociamos el "Adapter" al "ArrayList".
            adaptadorObras = new ObrasAdapter( getApplicationContext(), alObra );

            //-> Asociamos el "Adapter" con el "ListView".
            lvObras .setAdapter( adaptadorObras );
        }

        //-> Agregamos el escuchador al "ListView"
        lvObras .setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                crudObras .opciones( view, position, alObra);
            }
        });

    }

    private ArrayList<Obra> mostrarObras() {

        //-> Declaramos variables locales
        String salida = null;
        alObras = null;

        //-> Ejecuto mi Tarea Asincrona ListarEmpleados y le paso el parámetro
        ListarObras cadena = ( ListarObras ) new ListarObras( this ) .execute();

        try {
            //-> Obtengo el valor de retorno de mi tarea asíncrona.
            salida = cadena.get();
            Log .i("MainActivity", "Obras: " + salida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //-> Valida si la cadena de retorno esta vacia.
        if( salida != ""  ) {
            //-> Convierte una cadena a un ArrayList<String[]>
            alObras = Convertir .cadenaEnArrayListDeArray( salida );

            //-> Convierte un ArrayList<String[]> a un ArrayList<Empleado>
            alObra = Convertir .arrayListDeArrayEnArrayListEmpleado( alObras );
        }

        return alObra;
    }

}
