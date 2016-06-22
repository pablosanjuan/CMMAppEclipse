package tesis.pablosanjuan.tesisqr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mision2 extends Activity implements OnClickListener {

	int REQUEST_CODE = 0;
	Button btn_scan;
	private SharedPreferences prefs;
	TextView txResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mision2);
		prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
		btn_scan = (Button) findViewById(R.id.btn_scan_m2);
        txResult = (TextView) findViewById(R.id.pista_m2);
        btn_scan.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        btn_scan.setTypeface(font);
        
        validar_m2_101();
        validar_m2_102();
	}

	private void validar_m2_101() {
		if (prefs.getBoolean("m2_101", false)){
        	txResult.setText("¡Bien hecho! Ahora vamos con la pieza de arte que representa a la familia");
        }
	}
	private void validar_m2_102() {
		if (prefs.getBoolean("m2_102", false)) {
        	txResult.setText("Muy bien,  para finalizar el entrenamiento, escanea el último elemento de esta búsqueda: Fueron traídas desde el cementerio de la ciudad para estar presentes en esta colección");
		}
	}

	@Override
	public void onClick(View v){
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);
	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	            String contenido = intent.getStringExtra("SCAN_RESULT");
	            validar(contenido);
	        }
	    }
	}
	    private void validar(String contenido) {
	    	validar_vlr_m2_101(contenido);
	    	validar_vlr_m2_102(contenido);
	    	validar_vlr_m2_103(contenido);
		}
		private void validar_vlr_m2_103(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala1/0103/index.html")) {
                if (prefs.getBoolean("ban_m2_101", false)){
                	if (prefs.getBoolean("ban_m2_102", false)) {

                        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
		                Editor editor=preferencias.edit();
		                editor.putBoolean("d_museo2", true);
		                editor.commit();
		                
		            	LayoutInflater inflater = getLayoutInflater();
		            	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
		            	TextView text = (TextView) layout.findViewById(R.id.text_toast);
		            	text.setText("Mision 2 Superada!!! - Supera Otra Mision");
		            	Toast toast = new Toast(getApplicationContext());
		            	toast.setDuration(Toast.LENGTH_LONG);
		            	toast.setView(layout);
		            	toast.show();
		            	
			        	Intent ir_m1 = new Intent().setClass(Mision2.this, ListaMisiones.class);
		                startActivity(ir_m1);
		                finish();
					}else {
						return;
					}
				} else {
					LayoutInflater inflater = getLayoutInflater();
	            	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
	            	TextView text = (TextView) layout.findViewById(R.id.text_toast);
	            	text.setText("Si es una de las Piezas, Pero Debes Seguir Las Pistas Para Encontrar la Pieza Correcta");
	            	Toast toast = new Toast(getApplicationContext());
	            	toast.setDuration(Toast.LENGTH_LONG);
	            	toast.setView(layout);
	            	toast.show();
				}
	}else{
    	return;
    }
		}

		private void validar_vlr_m2_102(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala1/0102/index.html")) {
                if (prefs.getBoolean("ban_m2_101", false)){
                	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                    Editor editor=preferencias.edit();
                    editor.putBoolean("m2_102", true);
                    editor.putBoolean("ban_m2_102", true);
                    editor.commit();
                    
                    LayoutInflater inflater = getLayoutInflater();
                	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
                	TextView text = (TextView) layout.findViewById(R.id.text_toast);
                	text.setText("Codigo Encontrado");
                	Toast toast = new Toast(getApplicationContext());
                	toast.setDuration(Toast.LENGTH_LONG);
                	toast.setView(layout);
                	toast.show();
                	
                	Intent ir_m1 = new Intent().setClass(Mision2.this, Mision2.class);
                    startActivity(ir_m1);
                    finish();
				} else {
					LayoutInflater inflater = getLayoutInflater();
	            	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
	            	TextView text = (TextView) layout.findViewById(R.id.text_toast);
	            	text.setText("Si es una de las Piezas, Pero Debes Seguir Las Pistas Para Encontrar la Pieza Correcta");
	            	Toast toast = new Toast(getApplicationContext());
	            	toast.setDuration(Toast.LENGTH_LONG);
	            	toast.setView(layout);
	            	toast.show();
				}
		}else{
        	return;
        }
	}

		private void validar_vlr_m2_101(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala1/0101/Index.html")) {  
            	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                Editor editor=preferencias.edit();
                editor.putBoolean("m2_101", true);
                editor.putBoolean("ban_m2_101", true);
                editor.commit();
                finish();
                
            	LayoutInflater inflater = getLayoutInflater();
            	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
            	TextView text = (TextView) layout.findViewById(R.id.text_toast);
            	text.setText("Codigo Encontrado");
            	Toast toast = new Toast(getApplicationContext());
            	toast.setDuration(Toast.LENGTH_LONG);
            	toast.setView(layout);
            	toast.show();
            	
	        	Intent ir_m1 = new Intent().setClass(Mision2.this, Mision2.class);
                startActivity(ir_m1);
                finish();
        }else{
        	return;
        }
		}
}