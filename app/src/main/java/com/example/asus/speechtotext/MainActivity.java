package com.example.asus.speechtotext;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    FloatingActionButton fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView3);
        fb=(FloatingActionButton)findViewById(R.id.floatingActionButton4);
        Toast.makeText(this, "say!", Toast.LENGTH_SHORT).show();
    }
    public void getText(View v){
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        fb.setAlpha(0.5f);
         if(intent.resolveActivity(getPackageManager())!=null)
         startActivityForResult(intent,10);
        else
             Toast.makeText(this, "nooo", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

     //   ArrayList<String> result=null;
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){

            case 10:
                if(RESULT_OK==resultCode && data!=null){


                 ArrayList <String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Log.i("info",result.get(0));
                    Toast.makeText(this, result.get(0), Toast.LENGTH_SHORT).show();
                    tv.setText(result.get(0));
                    fb.setAlpha(1.0f);

                }
                break;

        }



    }
}
