package com.erennkurtt.engapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {


    ImageButton imageButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Words word3 = new Words();
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int temp = preferences.getInt("indexAdj", -1) + 1;
        int temp2 = preferences.getInt("AdjLast" ,-1) + 1;
        if(temp == word3.adj.length) {
            temp = 0;
        }
        if(temp2>= word3.adj.length ){
            editor.putInt("AdjLast",word3.adj.length);
        }
        else{
            editor.putInt("AdjLast",temp2);
        }
        editor.putInt("indexAdj",temp);
        editor.apply();

        int index1 = preferences.getInt("indexAdj", -1);

        final TextView text1eng = (TextView) findViewById(R.id.textAdj);
        final TextView text2tr = (TextView) findViewById(R.id.textAdjTr);
        text1eng.setText(word3.adj[index1]);
        text2tr.setText(word3.adjTR[index1]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageButton4 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Words word3 = new Words();
                SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                int temp = preferences.getInt("indexAdj", -1) + 1;
                int temp2 = preferences.getInt("AdjLast" ,-1) + 1;
                if(temp == word3.adj.length) {
                    temp = 0;
                }
                if(temp2>= word3.adj.length ){
                    editor.putInt("AdjLast",word3.adj.length);
                }
                else{
                    editor.putInt("AdjLast",temp2);
                }
                editor.putInt("indexAdj",temp);
                editor.apply();

                int index1 = preferences.getInt("indexAdj", -1);

                final TextView text1eng = (TextView) findViewById(R.id.textAdj);
                final TextView text2tr = (TextView) findViewById(R.id.textAdjTr);
                text1eng.setText(word3.adj[index1]);
                text2tr.setText(word3.adjTR[index1]);
            }
        });
    }
}