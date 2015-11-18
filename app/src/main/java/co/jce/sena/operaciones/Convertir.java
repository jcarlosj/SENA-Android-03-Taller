package co.jce.sena.operaciones;

import android.util.Log;

import java.util.ArrayList;

import co.jce.sena.estructurasdatos.Obra;

/**
 * Created by jcarlosj on 11/11/15.
 */
public class Convertir {

    public static ArrayList<String[]> cadenaEnArrayListDeArray( String datos ) {

        //-> Segmenta y extrae cada registro y lo agrega a un "Array" de tipo "String"
        int agrega = 0;                         //: Contando veces que se registro en el ArrayList
        String[] registro, campos = null;
        ArrayList alDatos;
        alDatos = new ArrayList<String[]>();

        //-> Divide cada que encuentra un :: (Siempre genera una división adicional)
        registro = datos.split("::");       //: El último registro no trae nada, por eso se reduce en 1.

        //-> Recorre el "Array" registro
        for( int i = 0; i < registro .length - 1; i++ ) {           //: Reducimos en uno el tamaño del Array.
            /*-> Segmenta y extrae cada campo de cada uno de los registros
                 y lo agrega a un "Array" de tipo "String"                  */
            campos = registro[ i ] .split(",");
            //-(T) System .out .println( "Array (registro): " + registro[ i ] );
            alDatos .add( campos );
            agrega++;
        }
        Log .i( "alDatos", "agrego " + agrega + " registros" );

        //-> Imprime "Array" campos para verificar su contenido (PRUEBA)
        for( int i = 0; i < campos .length; i++ ) {
            Log .i( "Convertir campos[" + i + "] ", campos[ i ] );
        }

        return alDatos;
    }

    public static String[] arrayListDeArrayEnArray( ArrayList<String[]> datos, int filtro ) {

        String aDatos[] = new String[ datos.size() ];

        Log .i( "Longitud", "filas    :" + datos.size() );
        Log .i( "Longitud", "columnas :" + datos.get(0) .length );

        for( int i = 0; i < datos.size(); i++ ) {
            for( int j = 0; j < datos.get( 0 ).length; j++ ) {
                //System .out .println( datos.get( i )[ j ] );
                aDatos[ i ] = datos.get( i )[ filtro ];

            }
        }

        return aDatos;
    }

    public static ArrayList<Obra> arrayListDeArrayEnArrayListEmpleado( ArrayList<String[]> datos ) {

        ArrayList<Obra> obras = new ArrayList<Obra>();
        Obra obra;

        Log .i( "Registros", String .valueOf( datos.size() ) );

        for( int i = 0; i < datos.size(); i++ ) {
            Log .i(
                "datos(" + i + ")",
                datos.get( i )[ 0 ] + "\n" +
                datos.get( i )[ 1 ] + "\n" +
                datos.get( i )[ 2 ] + "\n" +
                datos.get( i )[ 3 ] + "\n" +
                datos.get( i )[ 4 ] + "\n" +
                datos.get( i )[ 5 ] + "\n" +
                datos.get( i )[ 6 ] + "\n" +
                datos.get( i )[ 7 ] + "\n"
            );

            obras .add(
                new Obra(
                    Integer .parseInt( datos.get( i )[ 0 ] ),
                    datos.get( i )[ 1 ],
                    Integer .parseInt( datos.get( i )[ 2 ] ),
                    Integer .parseInt( datos.get( i )[ 3 ] ),
                    Integer .parseInt( datos.get( i )[ 4 ] ),
                    datos.get( i )[ 5 ],
                    datos.get( i )[ 6 ],
                    datos.get( i )[ 7 ]
                )
            );

        }

        return obras;
    }

}
