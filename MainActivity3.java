package com.erennkurtt.engapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Words word2 = new Words();
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int temp = preferences.getInt("indexVerb", -1) + 1;
        int temp2 = preferences.getInt("VerbLast",-1) +1;
        if(temp == word2.verb1.length) {
            temp = 0;
        }
        if(temp2>= word2.verb1.length){
            editor.putInt("VerbLast",word2.verb1.length);
        }
        else{
            editor.putInt("VerbLast",temp2);
        }
        editor.putInt("indexVerb",temp);
        editor.apply();

        int index1 = preferences.getInt("indexVerb", -1);

        final TextView text1 = (TextView) findViewById(R.id.textV1);
        final TextView text2 = (TextView) findViewById(R.id.textV2);
        final TextView text3 = (TextView) findViewById(R.id.textV3);
        final TextView text4 = (TextView) findViewById(R.id.textTR);
        text1.setText(word2.verb1[index1]);
        text2.setText(word2.verb2[index1]);
        text3.setText(word2.verb3[index1]);
        text4.setText(word2.turkish[index1]);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ImageButton imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words word2 = new Words();
                SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferences.edit();
                int temp = preferences.getInt("indexVerb", -1) + 1;
                int temp2 = preferences.getInt("VerbLast",-1) +1;
                if(temp == word2.verb1.length) {
                    temp = 0;
                }
                if(temp2>= word2.verb1.length){
                    editor2.putInt("VerbLast",word2.verb1.length);
                }
                else{
                    editor2.putInt("VerbLast",temp2);
                }
                editor2.putInt("indexVerb",temp);
                editor2.apply();

                int index1 = preferences.getInt("indexVerb", -1);

                final TextView text1 = (TextView) findViewById(R.id.textV1);
                final TextView text2 = (TextView) findViewById(R.id.textV2);
                final TextView text3 = (TextView) findViewById(R.id.textV3);
                final TextView text4 = (TextView) findViewById(R.id.textTR);
                text1.setText(word2.verb1[index1]);
                text2.setText(word2.verb2[index1]);
                text3.setText(word2.verb3[index1]);
                text4.setText(word2.turkish[index1]);
            }
        });
    }
}