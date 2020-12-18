package com.erennkurtt.engapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    ImageButton imageButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Words word4 = new Words();
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int temp = preferences.getInt("indexAdv", -1) + 1;
        int temp2 = preferences.getInt("AdvLast",-1) +1 ;
        if(temp == word4.adv.length) {
            temp = 0;
        }
        if(temp2>= word4.adv.length){
            editor.putInt("AdvLast",word4.adv.length);
        }
        else{
            editor.putInt("AdvLast",temp2);
        }
        editor.putInt("indexAdv",temp);
        editor.apply();

        int index1 = preferences.getInt("indexAdv", -1);

        final TextView textAdv = (TextView) findViewById(R.id.textAdv);
        final TextView textAdv2 = (TextView) findViewById(R.id.textAdv2);
        textAdv.setText(word4.adv[index1]);
        textAdv2.setText(word4.advTR[index1]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words word4 = new Words();
                SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                int temp = preferences.getInt("indexAdv", -1) + 1;
                int temp2 = preferences.getInt("AdvLast",-1) +1 ;
                if(temp == word4.adv.length) {
                    temp = 0;
                }
                if(temp2>= word4.adv.length){
                    editor.putInt("AdvLast",word4.adv.length);
                }
                else{
                    editor.putInt("AdvLast",temp2);
                }
                editor.putInt("indexAdv",temp);
                editor.apply();

                int index1 = preferences.getInt("indexAdv", -1);

                final TextView textAdv = (TextView) findViewById(R.id.textAdv);
                final TextView textAdv2 = (TextView) findViewById(R.id.textAdv2);
                textAdv.setText(word4.adv[index1]);
                textAdv2.setText(word4.advTR[index1]);
            }
        });
    }
}