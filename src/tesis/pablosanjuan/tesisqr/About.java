package tesis.pablosanjuan.tesisqr;

import tesis.pablosanjuan.tesisqr.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class About extends Activity implements OnClickListener {

	Button b_visitanos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        b_visitanos =  (Button) findViewById(R.id.visitanos);
        b_visitanos.setOnClickListener(this);
        
        Typeface font = Typeface.createFromAsset(getAssets(), "Equal-Regular.otf");
        b_visitanos.setTypeface(font);
    }

	@Override
	public void onClick(View arg0) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dstec.co/"));
		startActivity(browserIntent);
	}
}
