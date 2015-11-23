package co.jce.sena.operaciones;

import android.util.Log;

import java.util.ArrayList;

import co.jce.sena.estructurasdatos.Obra;

/**
 * Created by jcarlosj on 22/11/15.
 */
public class ProcesarDatos {

    //-> Atributos (Comunes)
    private ArrayList<String[]> alDatos;

    public ProcesarDatos() {
        alDatos = new ArrayList<String[]>();
    }

    public ArrayList<String[]> segmentar( String datos, int niveles ) {

        if( niveles == 2 ){
            alDatos = segmentaCampos( segmentaRegistros( datos ) );
        }

        return alDatos;
    }

    public ArrayList<String> getArrayListData( int indice ) {

        ArrayList<String> datos = new ArrayList<String>();
        //-> Extrae el indice indicado
        for( int i = 0; i < alDatos .size(); i++) {
            Log.i( "EXTRAE: alDatos ", "get( " + i + " )[ " + indice + " ] : " + alDatos .get(i)[ indice ] );
            datos .add( alDatos .get( i )[ indice ] );
        }

        return datos;
    }

    public String[] getArrayData( int indice ) {

        String datos[] = new String[ alDatos .size() ];

        //-> Extrae el indice indicado
        for( int i = 0; i < alDatos .size(); i++) {
            Log.i( "EXTRAE: alDatos ", "get( " + i + " )[ " + indice + " ] : " + alDatos .get( i )[ indice ] );
            datos[ i ] = alDatos .get( i )[ indice ];
        }

        return datos;
    }

    private String[] segmentaRegistros( String datos ) {
        //-> Divide cada que encuentra un :: (Siempre genera una división adicional)
        return datos .split("::");
    }

    public ArrayList<String[]> segmentaCampos( String registros[] ) {

        ArrayList<String[]> alDatos = new ArrayList<>();

        //-> Segmenta cada campo contenido en cada una de las cadenas contenidas en el "Array" registros.
        for( int i = 0; i < registros .length - 1; i++ ) {       //: Reducimos en uno el tamaño del Array.
            alDatos .add( registros[ i ] .split( "," ) );        //: Segmenta y extrae cada campo de cada uno de los registros lo agrega a un "Array" de tipo "String"
        }

        //-(T)> Recorremos el "ArrayList"
        for( int i = 0; i < alDatos .size(); i++) {
            for( int j = 0; j < alDatos .get(0) .length; j++ ) {
                Log.i( "alDatos ", "get( " + i + " )[ " + j + " ] : " + alDatos .get( i )[ j ] );
            }
        }

        return alDatos;
    }

    public ArrayList<Obra> getArrayListObra( ArrayList<String[]> datos ) {

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
