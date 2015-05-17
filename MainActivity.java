package com.example.howtopron;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

// Author: Gabriel Machado Christianetti
//Last update: 17/05/2015


public class MainActivity extends Activity implements OnClickListener {

	Button aperteParaFalar;
	ListView resultados; 
	static final int check = 1111;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultados = (ListView)findViewById(R.id.listView1);
        aperteParaFalar = (Button)findViewById(R.id.btnFalar);
        aperteParaFalar.setOnClickListener(this);
        
    }		

    @Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		
		
		intent.setAction(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE);
		
		intent.setAction(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE);
		
			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
			intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Pode falar...");
				
			intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
			
			
	//	}while(intent.equals(RecognizerIntent.RESULT_AUDIO_ERROR));
		
		
		startActivityForResult(intent, check);
		
	}

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == check && resultCode == RESULT_OK){
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			resultados.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));	
		
		}
    	
    	
    	super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
    
}
