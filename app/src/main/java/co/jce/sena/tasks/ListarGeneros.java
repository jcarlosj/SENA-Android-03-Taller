package co.jce.sena.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import co.jce.sena.interfaces.Epocas;
import co.jce.sena.interfaces.Generos;
import co.jce.sena.webservices.RequestHandler;

/**
 * Created by jcarlosj on 17/11/15.
 */
public class ListarGeneros extends AsyncTask<String, Void, String> implements Generos {

    //-> Atributos (Especiales)
    Context contexto;
    ProgressDialog loading;

    public ListarGeneros(Context contexto) {
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
        Log .i( "doInBackground", "URL: " + Generos .URL_LISTAR );

        RequestHandler rh = new RequestHandler();
        String res = rh.sendGetRequest( Generos .URL_LISTAR );

        return res;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loading.dismiss();
        Log .i( "onPostExecute", "Retorna > " + s );
    }

}
