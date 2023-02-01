package com.rabbi.eviltext;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class SplashActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
       Thread thread = new Thread(new Runnable(){

             @Override
             public void run() {
                try {
                   Thread.sleep(500);
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                   finish();
                } catch (InterruptedException e) {}
             }
                        
        });
        
        thread.start();
        
    }
    
}
