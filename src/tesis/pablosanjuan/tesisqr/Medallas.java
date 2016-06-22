package tesis.pablosanjuan.tesisqr;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import tesis.pablosanjuan.tesisqr.R;

public class Medallas extends Activity {

	Button d_museo1, d_museo2, d_museo3, d_2_piezas, d_todos, d_share_fb;
	private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medallas);
        
     prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
     
     d_museo1 = (Button) findViewById(R.id.btn_des_museo1);
     d_museo2 = (Button) findViewById(R.id.btn_des_museo2);
     d_museo3 = (Button) findViewById(R.id.btn_des_museo3);
     d_2_piezas = (Button) findViewById(R.id.btn_des_museo4);
     d_todos = (Button) findViewById(R.id.btn_des_museo5);
     d_share_fb = (Button) findViewById(R.id.btn_des_museo6);
     
     if (prefs.getBoolean("d_museo1", false)) {
		d_museo1.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo2", false)) {
		d_museo2.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo3", false)) {
		d_museo3.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo2", false )) {
		d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo2", false)|| prefs.getBoolean("d_museo3", false )) {
		d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo3", false )) {
		d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
	}else if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo2", false )|| prefs.getBoolean("d_museo3", false )) {
		d_todos.setBackgroundColor(R.drawable.back_logoro_completado);
	}

//     if (prefs.getBoolean("d_museo1", false)) {
//    	 if (prefs.getBoolean("d_museo2", false)) {
//    		 if (prefs.getBoolean("d_museo3", false)) {
//    			 if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo2", false )) {
//    				 if (prefs.getBoolean("d_museo2", false)|| prefs.getBoolean("d_museo3", false )) {
//    					 if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo3", false )) {
//    						 if (prefs.getBoolean("d_museo1", false)|| prefs.getBoolean("d_museo2", false )|| prefs.getBoolean("d_museo3", false )) {
//    							 d_todos.setBackgroundColor(R.drawable.back_logoro_completado);
//    						 }
//    						 d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
//    					 }
//    					 d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
//    				 }
//    				 d_2_piezas.setBackgroundColor(R.drawable.back_logoro_completado);
//    			 }
//    			 d_museo3.setBackgroundColor(R.drawable.back_logoro_completado);
//    			 d_museo2.setBackgroundColor(R.drawable.back_logoro_completado);
//        		 d_museo1.setBackgroundColor(R.drawable.back_logoro_completado);
//    		 }
//    		 d_museo2.setBackgroundColor(R.drawable.back_logoro_completado);
//    		 d_museo1.setBackgroundColor(R.drawable.back_logoro_completado);
//    	 }
//    	 d_museo1.setBackgroundColor(R.drawable.back_logoro_completado);
//     	}
//    }
    }
}
