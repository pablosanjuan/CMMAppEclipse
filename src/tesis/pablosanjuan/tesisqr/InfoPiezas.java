package tesis.pablosanjuan.tesisqr;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tesis.pablosanjuan.tesisqr.R;


public class InfoPiezas extends Activity {

    ArrayList<String> lista_opcion;
    ListView lista_museos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_piezas);

        lista_museos = (ListView) findViewById(R.id.menu_opc);
        lista_opcion = new ArrayList<String>();
        lista_opcion.add("Pieza Museo1");
        lista_opcion.add("Pieza Museo2");
        lista_opcion.add("Pieza Museo3");
        lista_opcion.add("Pieza Museo4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, lista_opcion);
        lista_museos.setAdapter(adapter);
    }
}
