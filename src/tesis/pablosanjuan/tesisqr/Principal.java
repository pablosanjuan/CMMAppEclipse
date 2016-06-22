package tesis.pablosanjuan.tesisqr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Principal extends Activity implements View.OnClickListener, OnMenuItemClickListener {

    Button btn_qr, btn_museos, btn_logros, btn_rank;
    ImageButton btn_settings;
    View v;
    TextView usuario;
    private SharedPreferences prefs;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
        usuario = (TextView) findViewById(R.id.txt_usuario);
        btn_qr = (Button) findViewById(R.id.btn_codigo_qr);
        btn_museos = (Button) findViewById(R.id.btn_museos);
//        btn_logros = (Button) findViewById(R.id.btn_logros);
        btn_rank = (Button) findViewById(R.id.btn_ranking);
        btn_settings =  (ImageButton) findViewById(R.id.btn_settings);

        String vlr_usuario = prefs.getString("usuario", "");
        usuario.setText(vlr_usuario);
        btn_qr.setOnClickListener(this);
        btn_museos.setOnClickListener(this);
//        btn_logros.setOnClickListener(this);
        btn_rank.setOnClickListener(this);
        btn_settings.setOnClickListener(this);
        
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        btn_qr.setTypeface(font);
        btn_museos.setTypeface(font);
//        btn_logros.setTypeface(font);
        btn_rank.setTypeface(font);
        usuario.setTypeface(font);
    }

	@SuppressLint("NewApi")
	@Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_codigo_qr:
            	Intent ir_cod = new Intent().setClass(Principal.this, ListaMisiones.class);
                startActivity(ir_cod);
            break;
            case R.id.btn_museos:
            	ir_url();
            break;
//            case R.id.btn_logros:
//                Intent ir_museos = new Intent().setClass(Principal.this, Medallas.class);
//                startActivity(ir_museos);
//            break;
            case R.id.btn_ranking:
            	Intent ir_maps = new Intent().setClass(Principal.this, MapaMuseo.class);
                startActivity(ir_maps);
            break;
            case R.id.btn_settings:
            	 PopupMenu popup = new PopupMenu(this, v);
            	    MenuInflater inflater = popup.getMenuInflater();
            	    inflater.inflate(R.menu.main, popup.getMenu());
            	    popup . setOnMenuItemClickListener ( this ); 
            	    popup.show();
            break;
        }
    }
    
    private void ir_url() {
    	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);
		
	}
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	            String contenido = intent.getStringExtra("SCAN_RESULT");
	            try {
		            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(contenido));
					startActivity(browserIntent);
				} catch (Exception e) {
					LayoutInflater inflater = getLayoutInflater();
                	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
                	TextView text = (TextView) layout.findViewById(R.id.text_toast);
                	text.setText("No Corresponde a Ninguna Pieza del Museo");
                	Toast toast = new Toast(getApplicationContext());
                	toast.setDuration(Toast.LENGTH_LONG);
                	toast.setView(layout);
                	toast.show();
				}
	        }
	    }
	}
	public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.perfil:
              Intent ir_perfil = new Intent().setClass(Principal.this, Logueo.class);
              startActivity(ir_perfil);
              return true;
           case R.id.Borrar:
    		    new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Borrar Perfil")
    		      .setMessage("Se Perderan Todos los Avances, Estás seguro?").setNegativeButton(android.R.string.cancel, null)
    		      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
    		        @Override
    		        public void onClick(DialogInterface dialog, int which){
    	            	SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
    	                Editor editor=preferencias.edit();
    	                editor.putString("usuario", "");
    	                editor.putString("contrasena", "");
    	                editor.putBoolean("d_museo1", false);
    	                editor.putBoolean("d_museo2", false);
    	                editor.putBoolean("d_museo3", false);
    	                editor.putBoolean("d_museo4", false);
    	                editor.putBoolean("d_museo5", false);
    	                editor.putBoolean("d_museo6", false);
    	                editor.putBoolean("m2_101", false);
    	                editor.putBoolean("m2_102", false);
    	                editor.putBoolean("m2_103", false);
    	                editor.putBoolean("ban_m2_101", false);
    	                editor.putBoolean("ban_m2_102", false);
    	                editor.putBoolean("ban_m2_103", false);
    	                
    	                editor.putBoolean("m3_101", false);
    	                editor.putBoolean("m3_102", false);
    	                editor.putBoolean("m3_103", false);
    	                editor.putBoolean("ban_m3_101", false);
    	                editor.putBoolean("ban_m3_102", false);
    	                editor.putBoolean("ban_m3_103", false);

    	                editor.putBoolean("m4_101", false);
    	                editor.putBoolean("m4_102", false);
    	                editor.putBoolean("m4_103", false);
    	                editor.putBoolean("ban_m4_101", false);
    	                editor.putBoolean("ban_m4_102", false);
    	                editor.putBoolean("ban_m4_103", false);

    	                editor.putBoolean("m5_101", false);
    	                editor.putBoolean("m5_102", false);
    	                editor.putBoolean("m5_103", false);
    	                editor.putBoolean("ban_m5_101", false);
    	                editor.putBoolean("ban_m5_102", false);
    	                editor.putBoolean("ban_m5_103", false);
    	                
    	                editor.putBoolean("m6_101", false);
    	                editor.putBoolean("m6_102", false);
    	                editor.putBoolean("m6_103", false);
    	                editor.putBoolean("ban_m6_101", false);
    	                editor.putBoolean("ban_m6_102", false);
    	                editor.putBoolean("ban_m6_103", false);
    	                editor.commit();
    		        	
    		        	Intent ir_logueo = new Intent().setClass(Principal.this, Logueo.class);
    	                startActivity(ir_logueo);
    	                finish();
    		        }
    		      }).show();
    		    return true;
           case R.id.Contacto:
              Intent ir_contacto =  new Intent().setClass(Principal.this, FeedBack.class);
              startActivity(ir_contacto);
              return true;
           case R.id.Acerca:
              Intent ir_about =  new Intent().setClass(Principal.this, About.class);
              startActivity(ir_about);
              return true;
           case R.id.Salir:
              finish();
              System.runFinalization();
              System.exit(0);
              Principal.this.finish();
              return true;
        }
		return false;
    }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		  if (keyCode == KeyEvent.KEYCODE_BACK) {
		    new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Salir")
		      .setMessage("Deseas Salir?").setNegativeButton(android.R.string.cancel, null)//sin listener
		      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
		        @Override
		        public void onClick(DialogInterface dialog, int which){
		          //Salir
		        	Principal.this.finish();
		        }
		      }).show();
		    // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
		    return true;
		  }
		//para las demas cosas, se reenvia el evento al listener habitual
		  return super.onKeyDown(keyCode, event);
		}
}