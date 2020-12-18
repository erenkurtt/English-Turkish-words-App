package com.erennkurtt.engapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);



        TextView nounData = findViewById(R.id.nounData);
        TextView verbData = findViewById(R.id.VerbData);
        TextView adjData = findViewById(R.id.AdjData);
        TextView advData = findViewById(R.id.AdvData);
        TextView quizData = findViewById(R.id.QuestData);
        CharSequence noun = "Nouns: " + preferences.getInt("NounLast" ,0);
        CharSequence verb = "Verbs: " + preferences.getInt("VerbLast" ,0);
        CharSequence adj = "Adjectives: " + preferences.getInt("AdjLast" ,0);
        CharSequence adv = "Adverbs: " + preferences.getInt("AdvLast" ,0);
        CharSequence quiz = "Başarılı test: " + preferences.getInt("Quest" ,0);
        nounData.setText(noun);
        verbData.setText(verb);
        adjData.setText(adj);
        advData.setText(adv);
        quizData.setText(quiz);
    }


}

