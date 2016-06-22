package tesis.pablosanjuan.tesisqr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Logueo extends Activity implements View.OnClickListener {

    Button principal2;
    EditText usu, pass;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logueo);

        prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
        usu = (EditText) findViewById(R.id.edt_usuario);
        principal2 = (Button) findViewById(R.id.btn_nada2);
        principal2.setOnClickListener(this);
        usu.setText(prefs.getString("usuario", ""));
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        principal2.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nada2:
    			String usuario=usu.getText().toString();
            	if(checklogindata(usuario)==true){
            		
            		SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                    Editor editor=preferencias.edit();
                    editor.putString("usuario", usuario);
                    editor.putBoolean("validar_sesion", true);
                    editor.commit();
                    
            		Intent ir_principal =  new Intent().setClass(Logueo.this, Principal.class);
                    startActivity(ir_principal);
                    finish();
        		}else{
        			err_login_vacios();
        		}
            break;
        }
    }
    
    public boolean checklogindata(String username){
        if 	(username.equals("")){
        return false;
        }else{
        	return true;
        }
    }
    public void err_login_vacios(){
    	LayoutInflater inflater = getLayoutInflater();
    	View layout = inflater.inflate(R.layout.toast_personalizado,(ViewGroup) findViewById(R.id.toast_contenedor)); //"inflamos" nuestro layout
    	TextView text = (TextView) layout.findViewById(R.id.text_toast);
    	text.setText("Debe Llenar Todos los Campos");
    	Toast toast = new Toast(getApplicationContext());
    	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    	toast.setDuration(Toast.LENGTH_LONG);
    	toast.setView(layout);
    	toast.show();
    }
}