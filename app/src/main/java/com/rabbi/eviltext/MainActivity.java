package com.rabbi.eviltext;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import java.io.*;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity { 
    private EditText text,limit;
    private Button resetBtn,generareBtn;
    String TEXT_FOR_REPEAT;
    long LIMIT_NUMBER;
    private TextView displayText;
    private CheckBox newLine;
    private ImageView copyText,shareText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = findViewById(R.id.text);
        limit = findViewById(R.id.limit);
        resetBtn = findViewById(R.id.resetBtn);
        generareBtn = findViewById(R.id.generateBtn);
        displayText = findViewById(R.id.displayText);
        newLine = findViewById(R.id.newLine);
        copyText = findViewById(R.id.copyText);
        shareText = findViewById(R.id.shareText);
        
        generareBtn.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View p1) {
                try{
                   TEXT_FOR_REPEAT = text.getText().toString();
                   final String limit_text = limit.getText().toString();
                   LIMIT_NUMBER = Long.parseLong(limit_text);

                   if(TEXT_FOR_REPEAT != null && LIMIT_NUMBER > 0){
                      StringBuilder repeated_text = new StringBuilder();
                      for (int i = 0; i < LIMIT_NUMBER; i++) {
                         if(newLine.isChecked()){
                            repeated_text.append(TEXT_FOR_REPEAT+"\n");
                         }
                         else{
                            repeated_text.append(TEXT_FOR_REPEAT);
                         }
                      }
                      displayText.setText(repeated_text.toString());
                   }
                }
                catch(Exception e){                
                   if(text.getText().toString().isEmpty()){
                      text.setError("Please fill out this field");
                   }
                   if(limit.getText().toString().isEmpty()){
                      limit.setError("Please fill out this field");                
                   }                                      
                }
             }
                       
       });
       
       resetBtn.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View p1) {
                text.setText("");
                limit.setText("");
                displayText.setText("Repeated text will appear here 🥰");
                
             }
                       
       });
       
       
       copyText.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View p1) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", displayText.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplication(), "🎯 Text Copied To Clipboard 🎯", Toast.LENGTH_SHORT).show();
             }
                       
       });
       
       shareText.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View p1) {
                Intent share_intent = new Intent(Intent.ACTION_SEND);
                share_intent.setType("text/plain");
                String subject = "Repeated Text";
                String body = displayText.getText().toString();
                share_intent.putExtra(share_intent.EXTRA_SUBJECT,subject);
                share_intent.putExtra(share_intent.EXTRA_TITLE,"Share Repeated Text");
                share_intent.putExtra(share_intent.EXTRA_TEXT,body);
                startActivity(share_intent.createChooser(share_intent,"Share With"));
             }             
          
       });
        
    }
    
    // Creating Option Menu
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {

      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main_menu,menu);
      return super.onCreateOptionsMenu(menu);
   }

// Add Listener
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {

      if(item.getItemId() == R.id.aboutId){
         Intent intent = new Intent(getApplicationContext(),AboutApp.class);
         startActivity(intent);
         overridePendingTransition(0,0);
      }
      if(item.getItemId() == R.id.followId){
         Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cutt.ly/rabbi"));
         startActivity(intent);
      }
      return super.onOptionsItemSelected(item);
   }
	
} 


