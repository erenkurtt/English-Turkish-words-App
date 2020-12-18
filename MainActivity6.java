package com.erennkurtt.engapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Random;

public class MainActivity6 extends AppCompatActivity {

    Props prop = new Props();
    private RewardedAd rewardedAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        newQuestion();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
                prop.isInternet=false;
                prop.adCounter=2;
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);


    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonEvents1();

    }

    public void newQuestion(){

        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);

        Words word = new Words();

        final Button ansA =  findViewById(R.id.button7);
        final Button ansB =  findViewById(R.id.button8);
        final Button ansC =  findViewById(R.id.button9);

        prop.isSituation1= false;
        prop.isSituation2= false;
        prop.isSituation3= false;
        prop.isSituation4= false;

        TextView count = findViewById(R.id.counterQuest);

        CharSequence ctrText = prop.counter + "/10";
        count.setText(ctrText);

        ansA.setBackgroundColor(0x792B2424);
        ansB.setBackgroundColor(0x792B2424);
        ansC.setBackgroundColor(0x792B2424);


        int NounNumb = preferences.getInt("NounLast", 0);

        if(NounNumb < 15 ){
            NounNumb = 16;
        }


        int VerbNumb = preferences.getInt("VerbLast", 0);

        if(VerbNumb < 15){
            VerbNumb = 16;
        }


        int AdjNumb = preferences.getInt("AdjLast", 0);

        if(AdjNumb < 15){
            AdjNumb = 16;
        }


        int AdvNumb = preferences.getInt("AdvLast", 0);
        if(AdvNumb < 15){
            AdvNumb = 16;
        }



        TextView text123 =  findViewById(R.id.Question);

        Random rnd = new Random();
        int rndNumber = rnd.nextInt(4)+1;
        int indexNumb;
        int randomNumb1;
        int randomNumb2;

        if(rndNumber == 1){
            indexNumb = rnd.nextInt(NounNumb);
            randomNumb1 = rnd.nextInt(NounNumb);
            randomNumb2 = rnd.nextInt(NounNumb);
            text123.setText(word.keysEng[indexNumb]);
            ansA.setText(word.keysTr[indexNumb]);
            ansB.setText(word.keysTr[randomNumb1]);
            ansC.setText(word.keysTr[randomNumb2]);
            prop.NounIndex = indexNumb;
            prop.isSituation1 = true;
        }
        else if(rndNumber==2){
            indexNumb = rnd.nextInt(VerbNumb);
            randomNumb1 = rnd.nextInt(VerbNumb);
            randomNumb2 = rnd.nextInt(VerbNumb);
            text123.setText(word.verb1[indexNumb]);
            ansA.setText(word.turkish[randomNumb1]);
            ansB.setText(word.turkish[indexNumb]);
            ansC.setText(word.turkish[randomNumb2]);
            prop.VerbIndex = indexNumb;
            prop.isSituation2 = true;
        }
        else if(rndNumber==3){
            indexNumb = rnd.nextInt(AdjNumb);
            randomNumb1 = rnd.nextInt(AdjNumb);
            randomNumb2 = rnd.nextInt(AdjNumb);
            text123.setText(word.adj[indexNumb]);
            ansA.setText(word.adjTR[randomNumb1]);
            ansB.setText(word.adjTR[randomNumb2]);
            ansC.setText(word.adjTR[indexNumb]);
            prop.AdjIndex = indexNumb;
            prop.isSituation3 = true;
        }
        else if(rndNumber==4){
            indexNumb = rnd.nextInt(AdvNumb);
            randomNumb1 = rnd.nextInt(AdvNumb);
            randomNumb2 = rnd.nextInt(AdvNumb);
            text123.setText(word.adv[indexNumb]);
            ansA.setText(word.advTR[randomNumb1]);
            ansB.setText(word.advTR[indexNumb]);
            ansC.setText(word.advTR[randomNumb2]);
            prop.AdvIndex = indexNumb;
            prop.isSituation4 = true;
        }



    }
    public void newQuestion2(){
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);

        Words word = new Words();

        Button ansA =  findViewById(R.id.button7);
        Button ansB =  findViewById(R.id.button8);
        Button ansC =  findViewById(R.id.button9);

        TextView count = findViewById(R.id.counterQuest);

        CharSequence ctrText = prop.counter + "/10";
        count.setText(ctrText);

        prop.isSituation1= false;
        prop.isSituation2= false;
        prop.isSituation3= false;
        prop.isSituation4= false;

        ansA.setBackgroundColor(0x792B2424);
        ansB.setBackgroundColor(0x792B2424);
        ansC.setBackgroundColor(0x792B2424);


        int NounNumb = preferences.getInt("NounLast", 0);

        if(NounNumb < 15 ){
            NounNumb = 16;
        }


        int VerbNumb = preferences.getInt("VerbLast", 0);

        if(VerbNumb < 15){
            VerbNumb = 16;
        }


        int AdjNumb = preferences.getInt("AdjLast", 0);

        if(AdjNumb < 15){
            AdjNumb = 16;
        }


        int AdvNumb = preferences.getInt("AdvLast", 0);
        if(AdvNumb < 15){
            AdvNumb = 16;
        }



        TextView text123 =  findViewById(R.id.Question);


        Random rnd = new Random();

        int rndNumber = rnd.nextInt(4)+1;
        int indexNumb;
        int randomNumb1;
        int randomNumb2;
        if(rndNumber==1){
            indexNumb = rnd.nextInt(NounNumb);
            randomNumb1 = rnd.nextInt(NounNumb);
            randomNumb2 = rnd.nextInt(NounNumb);
            text123.setText(word.keysTr[indexNumb]);
            ansA.setText(word.keysEng[indexNumb]);
            ansB.setText(word.keysEng[randomNumb1]);
            ansC.setText(word.keysEng[randomNumb2]);
            prop.NounIndex = indexNumb;
            prop.isSituation1 = true;
        }
        else if(rndNumber==2){
            indexNumb = rnd.nextInt(VerbNumb);
            randomNumb1 = rnd.nextInt(VerbNumb);
            randomNumb2 = rnd.nextInt(VerbNumb);
            text123.setText(word.turkish[indexNumb]);
            ansA.setText(word.verb1[randomNumb1]);
            ansB.setText(word.verb1[indexNumb]);
            ansC.setText(word.verb1[randomNumb2]);
            prop.VerbIndex = indexNumb;
            prop.isSituation2 = true;
        }
        else if(rndNumber==3){
            indexNumb = rnd.nextInt(AdjNumb);
            randomNumb1 = rnd.nextInt(AdjNumb);
            randomNumb2 = rnd.nextInt(AdjNumb);
            text123.setText(word.adjTR[indexNumb]);
            ansA.setText(word.adj[indexNumb]);
            ansB.setText(word.adj[randomNumb1]);
            ansC.setText(word.adj[randomNumb2]);
            prop.AdjIndex = indexNumb;
            prop.isSituation3 = true;
        }
        else if(rndNumber==4){
            indexNumb = rnd.nextInt(AdvNumb);
            randomNumb1 = rnd.nextInt(AdvNumb);
            randomNumb2 = rnd.nextInt(AdvNumb);
            text123.setText(word.advTR[indexNumb]);
            ansA.setText(word.adv[randomNumb1]);
            ansB.setText(word.adv[indexNumb]);
            ansC.setText(word.adv[randomNumb2]);
            prop.AdvIndex = indexNumb;
            prop.isSituation4 = true;
        }

    }

    public void buttonEvents1(){
        final Button ansA =  findViewById(R.id.button7);
        final Button ansB =  findViewById(R.id.button8);
        final Button ansC =  findViewById(R.id.button9);
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysTr[prop.NounIndex].equals (ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.turkish[prop.VerbIndex].equals (ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adjTR[prop.AdjIndex].equals (ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.advTR[prop.AdvIndex].equals (ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }

            }
        });
        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysTr[prop.NounIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.turkish[prop.VerbIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adjTR[prop.AdjIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.advTR[prop.AdvIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }

            }
        });

        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysTr[prop.NounIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.turkish[prop.VerbIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adjTR[prop.AdjIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.advTR[prop.AdvIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }

            }
        });
    }

    public void buttonEvents2(){
        final Button ansA =  findViewById(R.id.button7);
        final Button ansB =  findViewById(R.id.button8);
        final Button ansC =  findViewById(R.id.button9);
        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysEng[prop.NounIndex].equals(ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.verb1[prop.VerbIndex].equals(ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adj[prop.AdjIndex].equals(ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.adv[prop.AdvIndex].equals(ansA.getText())) {
                        ansA.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansA.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedA(ansB,ansC,ansA);
                    }
                }

            }
        });
        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysEng[prop.NounIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.verb1[prop.VerbIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adj[prop.AdjIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.adv[prop.AdvIndex].equals(ansB.getText())) {
                        ansB.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansB.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedB(ansA,ansC ,ansB);
                    }
                }

            }
        });

        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(prop.isSituation1){
                    Words w1 = new Words();
                    if (w1.keysEng[prop.NounIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation2){
                    Words w1 = new Words();
                    if (w1.verb1[prop.VerbIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation3){
                    Words w1 = new Words();
                    if (w1.adj[prop.AdjIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }
                else if(prop.isSituation4){
                    Words w1 = new Words();
                    if (w1.adv[prop.AdvIndex].equals(ansC.getText())) {
                        ansC.setBackgroundColor(Color.rgb(70, 191, 59));
                        theNextOne();
                    } else {
                        ansC.setBackgroundColor(Color.rgb(189, 51, 51));
                        failedQuestionPressedC(ansA,ansB,ansC);
                    }
                }

            }
        });
    }
    public void theNextOne(){
        int temp;
        Random rdn = new Random();
        final TextView sucText = findViewById(R.id.success);
        final ImageView tick = findViewById(R.id.imageView2);
        final ImageButton rest = findViewById(R.id.imageButton4);
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        prop.counter++;
        if(prop.counter >= 11 ){
            temp = preferences.getInt("Quest",0) + 1;
            editor.putInt("Quest",temp);
            editor.apply();
            questsDone();
            sucText.setVisibility(View.VISIBLE);
            tick.setVisibility(View.VISIBLE);
            rest.setVisibility(View.VISIBLE);
            prop.counter=1;

            rest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    sucText.setVisibility(View.INVISIBLE);
                    tick.setVisibility(View.INVISIBLE);
                    rest.setVisibility(View.INVISIBLE);
                    newQuestion();
                    buttonEvents1();
                    questAgain();
                }
            });
        }
        int rdnNumb = rdn.nextInt(2);
        if(rdnNumb ==1 ){
            newQuestion();
            buttonEvents1();
        }
        else{
            newQuestion2();
            buttonEvents2();
        }

    }

    public void failedQuestionPressedA(final Button btn2, final Button btn3 , final Button wrong){
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);

        //prop.backupA = btn3.getText();
        //prop.backupB = btn2.getText();
        //prop.backupC = wrong.getText();

        final TextView failedText =  findViewById(R.id.textFailed);
        final TextView ctrQuest = findViewById(R.id.counterQuest);
        final Button ad =  findViewById(R.id.button10);
        final Button back =  findViewById(R.id.button11);

        ctrQuest.setVisibility(View.INVISIBLE);
        if(prop.adCounter>=2){
            adIsDone();
        }
        else{
            failedText.setVisibility(View.VISIBLE);
            ad.setVisibility(View.VISIBLE);
            back.setVisibility(View.VISIBLE);
        }
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = MainActivity6.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            rewardedAd = createAndLoadRewardedAd();
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            prop.adCounter++;
                            adCompleted(btn2,btn3,wrong,ad,back,failedText,ctrQuest);
                            newQuestion();
                            buttonEvents1();
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(gears);
            }
        });

    }
    public void failedQuestionPressedB(final Button btn1, final Button btn2 , final Button wrong){
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);

        //prop.backupA = btn3.getText();
        //prop.backupB = btn2.getText();
        //prop.backupC = wrong.getText();

        final TextView failedText =  findViewById(R.id.textFailed);
        final TextView ctrQuest = findViewById(R.id.counterQuest);
        final Button ad =  findViewById(R.id.button10);
        final Button back =  findViewById(R.id.button11);

        ctrQuest.setVisibility(View.INVISIBLE);
        if(prop.adCounter>=2){
            adIsDone();
        }
        else{
            failedText.setVisibility(View.VISIBLE);
            ad.setVisibility(View.VISIBLE);
            back.setVisibility(View.VISIBLE);
        }
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = MainActivity6.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                                rewardedAd = createAndLoadRewardedAd();
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            prop.adCounter++;
                            adCompleted(btn1,btn2,wrong,ad,back,failedText,ctrQuest);
                            newQuestion();
                            buttonEvents1();
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(gears);
            }
        });
    }
    public void failedQuestionPressedC(final Button btn1, final Button btn2, final Button wrong){
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);

        //prop.backupA = btn3.getText();
        //prop.backupB = btn2.getText();
        //prop.backupC = wrong.getText();

        final TextView failedText =  findViewById(R.id.textFailed);
        final TextView ctrQuest = findViewById(R.id.counterQuest);
        final Button ad =  findViewById(R.id.button10);
        final Button back =  findViewById(R.id.button11);

        ctrQuest.setVisibility(View.INVISIBLE);

        if(prop.adCounter>=2){
            adIsDone();
        }
        else{
            failedText.setVisibility(View.VISIBLE);
            ad.setVisibility(View.VISIBLE);
            back.setVisibility(View.VISIBLE);
        }

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (rewardedAd.isLoaded()) {
                    Activity activityContext = MainActivity6.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {

                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            rewardedAd = createAndLoadRewardedAd();
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            prop.adCounter++;
                            adCompleted(btn1,btn2,wrong,ad,back,failedText,ctrQuest);
                            newQuestion();
                            buttonEvents1();
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gears = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(gears);
            }
        });
    }

    public void adCompleted(Button btn1, Button btn2, Button btn3 , Button ad, Button back, TextView failed, TextView counter){
       // btn1.setText(prop.backupA);
       // btn2.setText(prop.backupB);
       // btn3.setText(prop.backupC);

        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setBackgroundColor(0x792B2424);
        counter.setVisibility(View.VISIBLE);
        ad.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        failed.setVisibility(View.INVISIBLE);

    }

    public void questsDone(){
        final TextView first =  findViewById(R.id.Question);
        final Button btn1 =  findViewById(R.id.button7);
        final Button btn2 =  findViewById(R.id.button8);
        final Button btn3 =  findViewById(R.id.button9);
        final TextView last =  findViewById(R.id.counterQuest);

        first.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        last.setVisibility(View.INVISIBLE);

    }
    public void questAgain(){
        final TextView first =  findViewById(R.id.Question);
        final Button btn1 =  findViewById(R.id.button7);
        final Button btn2 =  findViewById(R.id.button8);
        final Button btn3 =  findViewById(R.id.button9);
        final TextView last =  findViewById(R.id.counterQuest);

        first.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        last.setVisibility(View.VISIBLE);
    }

    public void adIsDone(){
        final Button ad =  findViewById(R.id.button10);
        final Button back =  findViewById(R.id.button11);
        final ImageButton rest = findViewById(R.id.imageButton4);
        final TextView failedText =  findViewById(R.id.textFailed2);


            ad.setVisibility(View.INVISIBLE);
            back.setVisibility(View.INVISIBLE);
            rest.setVisibility(View.VISIBLE);
            CharSequence result ="Yanlış cevap! Skor: " +prop.counter;
            failedText.setText(result);
            failedText.setVisibility(View.VISIBLE);
            if(prop.isInternet){
                prop.adCounter=0;
            }
            else{
                prop.adCounter=2;
            }

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prop.counter = 1;
                failedText.setVisibility(View.INVISIBLE);
                rest.setVisibility(View.INVISIBLE);
                newQuestion();
                buttonEvents1();
                questAgain();
            }
        });

    }


    public RewardedAd createAndLoadRewardedAd() {
        RewardedAd rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
                prop.isInternet=false;
                prop.adCounter=2;
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;
    }

}