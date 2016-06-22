package tesis.pablosanjuan.tesisqr;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Presentacion extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 7000;
    private SharedPreferences prefs;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentacion);
        
        txt = (TextView) findViewById(R.id.txt_patrocinio);
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        txt.setTypeface(font);
        prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	
                if (prefs.getBoolean("validar_sesion", false)) {
                	Intent ir_log = new Intent().setClass(Presentacion.this, Principal.class);
                    startActivity(ir_log);
                    finish();
            	}else{
            		Intent ir_princ = new Intent().setClass(Presentacion.this, Logueo.class);
                    startActivity(ir_princ);
                    finish();
            	}
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
