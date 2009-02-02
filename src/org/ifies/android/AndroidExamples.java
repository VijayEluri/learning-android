package org.ifies.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidExamples extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        first_run = app_preferences.getBoolean("first_run", true);
        
        if (first_run) {
        	new AlertDialog.Builder(AndroidExamples.this)
    		.setTitle("Welcome to Android Developer Examples")
    		.setMessage("This application is a set of advanced examples for http://android.ifies.org.\nThese examples are available online via the website, where you can download the sourcecode for this application.")
    		.setNeutralButton("Close", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int whichButton) {
    				SharedPreferences.Editor editor = app_preferences.edit();
					editor.putBoolean("first_run", false);
					editor.commit();
    			}
    		})
    		.show();
        }
        
        example_admob = (Button) findViewById(R.id.example_admod);
        example_admob.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i_AdMob = new Intent(AndroidExamples.this, AdmobExample.class);
				startActivity(i_AdMob);
			}
        	
        });
        
        example_gallery = (Button) findViewById(R.id.example_gallery);
        example_gallery.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i_Gallery1 = new Intent(AndroidExamples.this, GalleryExample.class);
				startActivity(i_Gallery1);
			}
        	
        });
        
    }
    
    private SharedPreferences app_preferences;
    private boolean first_run;
    
    private Button example_admob;
    private Button example_gallery;
    
}