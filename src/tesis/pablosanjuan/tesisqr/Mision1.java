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

public class Mision1 extends Activity implements OnClickListener {

	int REQUEST_CODE = 0;
	Button btn_scan;
//	TextView txResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mision1);
		
		btn_scan = (Button) findViewById(R.id.btn_scan_m1);
//        txResult = (TextView) findViewById(R.id.txt_resultado);
        btn_scan.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        btn_scan.setTypeface(font);
	}
	
	@Override
	public void onClick(View v) {
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
	    	
		       if (contenido.equals("Scanner configurado correctamente")) {  
		            	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
	                    Editor editor=preferencias.edit();
	                    editor.putBoolean("d_museo1", true);
	                    editor.commit();
	                    finish();
	                    
	                	LayoutInflater inflater = getLayoutInflater();
	                	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
	                	TextView text = (TextView) layout.findViewById(R.id.text_toast);
	                	text.setText("Mision 1 - Superada!!!");
	                	Toast toast = new Toast(getApplicationContext());
	                	toast.setDuration(Toast.LENGTH_LONG);
	                	toast.setView(layout);
	                	toast.show();
		        }else{
                	LayoutInflater inflater = getLayoutInflater();
                	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
                	TextView text = (TextView) layout.findViewById(R.id.text_toast);
                	text.setText("Codigo Incorrecto - Vuelve a Intentarlo");
                	Toast toast = new Toast(getApplicationContext());
                	toast.setDuration(Toast.LENGTH_LONG);
                	toast.setView(layout);
                	toast.show();
		        	}
	    }
}