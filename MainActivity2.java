package com.erennkurtt.engapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {



    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Words word1 = new Words();
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int temp = preferences.getInt("index", -1) + 1;
        int temp2 = preferences.getInt("NounLast", -1) + 1;
        if(temp >= word1.keysEng.length) {
            temp = 0;
        }
        editor.putInt("index",temp);

        if(temp2 >= word1.keysEng.length){
            editor.putInt("NounLast",word1.keysEng.length);
        }
        else{
            editor.putInt("NounLast",temp2);
        }

        editor.apply();

        int index1 = preferences.getInt("index", -1);

        final TextView text1eng =  findViewById(R.id.textView);
        final TextView text2tr =  findViewById(R.id.textView2);
        text1eng.setText(word1.keysEng[index1]);
        text2tr.setText(word1.keysTr[index1]);



    }

    @Override
    protected void onResume() {

        super.onResume();
        imageButton =  findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words word1 = new Words();
                SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferences.edit();
                int temp = preferences.getInt("index", -1) + 1;
                int temp2 = preferences.getInt("NounLast", -1) + 1;
                if(temp == word1.keysEng.length) {
                    temp = 0;
                }
                if(temp2 >= word1.keysEng.length){
                    editor2.putInt("NounLast",word1.keysEng.length);
                }
                else{
                    editor2.putInt("NounLast",temp2);
                }
                editor2.putInt("index",temp);
                editor2.apply();

                int index1 = preferences.getInt("index", -1);

                final TextView text1eng =  findViewById(R.id.textView);
                final TextView text2tr =  findViewById(R.id.textView2);
                text1eng.setText(word1.keysEng[index1]);
                text2tr.setText(word1.keysTr[index1]);
            }
        });
    }
}