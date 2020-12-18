package com.erennkurtt.engapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    Button noun;
    Button verb;
    Button adj;
    Button adv;
    Button quiz;
    Button stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        noun = (Button) findViewById(R.id.button2);
        verb = (Button) findViewById(R.id.button4);
        adj = (Button) findViewById(R.id.button5);
        adv = (Button) findViewById(R.id.button);
        quiz = (Button) findViewById(R.id.button3);
        stats = (Button) findViewById(R.id.button6);


        noun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(gears);
            }
        });
        verb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(gears);
            }
        });
        adj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(gears);
            }
        });
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(gears);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity6.class);
                startActivity(gears);
            }
        });
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity.this, MainActivity7.class);
                startActivity(gears);
            }
        });
    }
}