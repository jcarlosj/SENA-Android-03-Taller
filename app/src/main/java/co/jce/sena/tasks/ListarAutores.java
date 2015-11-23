package co.jce.sena.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import co.jce.sena.interfaces.Autores;
import co.jce.sena.interfaces.Obras;
import co.jce.sena.webservices.RequestHandler;

/**
 * Created by jcarlosj on 17/11/15.
 */
public class ListarAutores extends AsyncTask<String, Void, String> implements Obras {

    //-> Atributos (Especiales)
    Context contexto;
    ProgressDialog loading;

    public ListarAutores(Context contexto) {
        super();
        this.contexto = contexto;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show( contexto, "Cargando datos...","Espere por favor...", false, false );
    }

    @Override
    protected String doInBackground(String... params) {
        Log .i( "doInBackground", "URL: " + Autores .URL_LISTAR );

        RequestHandler rh = new RequestHandler();
        String res = rh.sendGetRequest( Autores .URL_LISTAR );

        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loading.dismiss();
        Log .i( "onPostExecute", "Retorna > " + s );
    }

}
