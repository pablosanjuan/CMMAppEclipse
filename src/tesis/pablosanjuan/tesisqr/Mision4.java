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

public class Mision4 extends Activity implements OnClickListener {

	int REQUEST_CODE = 0;
	Button btn_scan;
	TextView txResult;
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mision4);
		
		prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
		btn_scan = (Button) findViewById(R.id.btn_scan_m4);
        txResult = (TextView) findViewById(R.id.pista_m4);
        btn_scan.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        btn_scan.setTypeface(font);
        validar_m4_101();
        validar_m4_102();
	}

	private void validar_m4_101() {
		if (prefs.getBoolean("m4_101", false)){
        	txResult.setText("Estos elementos distinguían en la liturgia al Arzobispo dándole un toque distintivo");
        }
	}
	private void validar_m4_102() {
		if (prefs.getBoolean("m4_102", false)) {
        	txResult.setText("¡Muy bien!, ahora para completar el atuendo del Arzobispo solo necesitamos algo que lo cubra");
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
	    	validar_vlr_m4_101(contenido);
	    	validar_vlr_m4_102(contenido);
	    	validar_vlr_m4_103(contenido);
		}
		private void validar_vlr_m4_103(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala3/0305/index.html")) {
                if (prefs.getBoolean("ban_m4_101", false)){
                	if (prefs.getBoolean("ban_m4_102", false)) {

                        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
		                Editor editor=preferencias.edit();
		                editor.putBoolean("d_museo4", true);
		                editor.commit();
		                
		            	LayoutInflater inflater = getLayoutInflater();
		            	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
		            	TextView text = (TextView) layout.findViewById(R.id.text_toast);
		            	text.setText("Mision 4 Superada!!! - Supera Otra Mision");
		            	Toast toast = new Toast(getApplicationContext());
		            	toast.setDuration(Toast.LENGTH_LONG);
		            	toast.setView(layout);
		            	toast.show();
		            	
			        	Intent ir_m1 = new Intent().setClass(Mision4.this, ListaMisiones.class);
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

		private void validar_vlr_m4_102(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala3/0304/index.html")) {
                if (prefs.getBoolean("ban_m4_101", false)){
                	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                    Editor editor=preferencias.edit();
                    editor.putBoolean("m4_102", true);
                    editor.putBoolean("ban_m4_102", true);
                    editor.commit();
                    
                    LayoutInflater inflater = getLayoutInflater();
                	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
                	TextView text = (TextView) layout.findViewById(R.id.text_toast);
                	text.setText("Codigo Encontrado");
                	Toast toast = new Toast(getApplicationContext());
                	toast.setDuration(Toast.LENGTH_LONG);
                	toast.setView(layout);
                	toast.show();
                	
                	Intent ir_m1 = new Intent().setClass(Mision4.this, Mision4.class);
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

		private void validar_vlr_m4_101(String contenido) {
			if (contenido.equals("http://www.unicauca.edu.co/museos/qr/Sala3/0301/index.html")) {  
            	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                Editor editor=preferencias.edit();
                editor.putBoolean("m4_101", true);
                editor.putBoolean("ban_m4_101", true);
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
            	
	        	Intent ir_m1 = new Intent().setClass(Mision4.this, Mision4.class);
                startActivity(ir_m1);
                finish();
        }else{
        	return;
        }
		}
}