package tesis.pablosanjuan.tesisqr;

import tesis.pablosanjuan.tesisqr.R;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MapaMuseo extends Activity implements OnClickListener {
	Button b_sal1, b_sal2, b_sal3, b_sal4, b_sal5, b_reco;
	ImageView maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_museo);
        
        b_sal1 = (Button) findViewById(R.id.btn_sala1);
        b_sal2 = (Button) findViewById(R.id.btn_sala2);
        b_sal3 = (Button) findViewById(R.id.btn_sala3);
        b_sal4 = (Button) findViewById(R.id.btn_sala4);
        b_sal5 = (Button) findViewById(R.id.btn_sala5);
        b_reco = (Button) findViewById(R.id.btn_recorrido);
        maps = (ImageView) findViewById(R.id.mapas_museo);
        
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        b_sal1.setTypeface(font);
        b_sal2.setTypeface(font);
        b_sal3.setTypeface(font);
        b_sal4.setTypeface(font);
        b_sal5.setTypeface(font);
        b_reco.setTypeface(font);
        
        b_sal1.setOnClickListener(this);
        b_sal2.setOnClickListener(this);
        b_sal3.setOnClickListener(this);
        b_sal4.setOnClickListener(this);
        b_sal5.setOnClickListener(this);
        b_reco.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sala1:		
			maps.setBackgroundResource(R.drawable.s1);
			break;
		case R.id.btn_sala2:
			maps.setBackgroundResource(R.drawable.s2);
			break;
		case R.id.btn_sala3:		
			maps.setBackgroundResource(R.drawable.s3);
			break;
		case R.id.btn_sala4:		
			maps.setBackgroundResource(R.drawable.s4);
			break;
		case R.id.btn_sala5:		
			maps.setBackgroundResource(R.drawable.s5);
			break;
		case R.id.btn_recorrido:		
			maps.setBackgroundResource(R.drawable.ruta);
			break;
	}
}
}
