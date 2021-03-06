package bonsai.app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BonsaiActivity extends Activity {
	

    // Utilidad de manejo de Base de Datos
	private BonsaiDbUtil bonsaidb;
	private long bonsaiactual;
	
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonsai);
        bonsaidb = new BonsaiDbUtil(this);	// Construinos el DDBBAdapter
        bonsaidb.open();
        bonsaiactual = 0;
        try {
        	Cursor bonsai = bonsaidb.fetchBonsai(bonsaiactual);
            startManagingCursor(bonsai);
            String nombre = bonsai.getString(
                    bonsai.getColumnIndexOrThrow(BonsaiDbUtil.KEY_NAME));
        	Toast.makeText(this, "El bonsai actual es: " + nombre, Toast.LENGTH_LONG).show();
            
        } catch (Exception e) {
        	Toast.makeText(this, "None bonsai created", Toast.LENGTH_LONG).show();
        	
        }
        
    }
    
    
    
    public void goGallery(View v) {
    	Toast.makeText(this, "Gallery will be soon available", Toast.LENGTH_SHORT).show();
    }
    
    public void goEdit(View v) {
	    Intent editAct = new Intent().setClass(this, EditBonsaiActivity.class);
	    startActivity(editAct);
    }
}