package com.rabbi.eviltext;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class AboutApp extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
    }
    
   // for set listener
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if(item.getItemId() == android.R.id.home){
         finish();
      }
      return super.onOptionsItemSelected(item);
   }
    
}
