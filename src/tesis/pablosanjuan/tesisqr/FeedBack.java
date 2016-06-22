package tesis.pablosanjuan.tesisqr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FeedBack extends Activity implements OnClickListener {

	private String nombre;
	private SharedPreferences prefs;
//	private EditText txt_asunt;
	private EditText txt_mens;
	private Button btn_enviar;
	TextView t_opi, t_env;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_back);
        
        prefs = getSharedPreferences("datos",Context.MODE_PRIVATE);
		nombre = prefs.getString("usuario", "");
        
		t_opi = (TextView) findViewById(R.id.txt_opinion);
        btn_enviar = (Button) findViewById(R.id.enviar);
//        txt_asunt = (EditText) findViewById(R.id.edt_asunto);
		txt_mens = (EditText) findViewById(R.id.edt_msn);
		btn_enviar.setOnClickListener(this);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        t_opi.setTypeface(font);
        btn_enviar.setTypeface(font);
    }
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.enviar:
			
			String[] to = { "infodstec@gmail.com"};
		        Intent emailIntent = new Intent(Intent.ACTION_SEND);
		        
//		        String asunto = txt_asunt.getText().toString();
		        String mensaje= txt_mens.getText().toString()+" - " + "Mensaje Enviado Desde APP MUSEO Por:"+ nombre+" ";
		        
		        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
//		        emailIntent.putExtra(Intent.EXTRA_REFERRER, asunto);
//		        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
		        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
		        emailIntent.setType("plain/text");
		        startActivity(emailIntent);
		        finish();
		}
	}
}
