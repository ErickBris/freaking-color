package com.gkcrop.freakingcolor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Play extends Activity
{

    
    Button buttonNo;
    Button buttonYes;
    int colors[] = {
        R.color.blue, R.color.orange, R.color.yellow, R.color.purple, R.color.green, R.color.red, R.color.gray, R.color.white, R.color.brown, R.color.pink
    };
    String textColors[] = {
            "Blue", "Orange", "Yellow", "Purple", "Green", "Red", "Gray", "White", "Brown", "Pink"
        };
    CountDownTimer countDownTimer;
    int elementOfColors;
    int elemetOfTextColors;
    Boolean isClick;
    Boolean isFirst;
    Boolean isMove;
    ArrayList<Integer> listColor;
    MediaPlayer mp;
    MediaPlayer mpEnd;
    int process;
    ProgressBar progressBar;
    int result;
    int score;
    TextView textGame;
    TextView textViewScore;
    private AdView mAdView;
    
    Editor editor;
	SharedPreferences sharedPreferences;
	String MediaStatusKey;
    boolean MediaStatusValue;

    public Play()
    {
        process = 0;
        listColor = new ArrayList<Integer>();
        elemetOfTextColors = 0;
        elementOfColors = 0;
        result = -1;
        isMove = Boolean.valueOf(false);
        isClick = Boolean.valueOf(false);
        isFirst = Boolean.valueOf(false);
        MediaStatusKey = "MediaStatusKey";
	    MediaStatusValue = true;
		
    }

    private void addArray(int i)
    {
        int j;
        listColor.clear();
        j = 0;
        do
        {
        	if (j < colors.length)
        	{
        		 listColor.add(Integer.valueOf(colors[j]));
        	        j++;	
        	}
        	else
        	{
        		int k=0;
        		do
        		{
        			if (k >= 8)
                    {
            			return;
                    }
        			listColor.add(Integer.valueOf(colors[i]));
      		      	k++;
        		}while(true);
        		
        		
        	}
        }
        while(true);

    }

    private void checkResult(int i)
    {
label0:
        {
            if (!isClick.booleanValue())
            {
                isClick = Boolean.valueOf(true);
                isFirst = Boolean.valueOf(true);
                if (i != result)
                {
                    break label0;
                }
                if(MediaStatusValue)
                mp.start();
                startGame();
                score = 1 + score;
                textViewScore.setText((new StringBuilder(String.valueOf(score))).toString());
            }
            return;
        }
        moveToResult();
        countDownTimer.cancel();
    }

    private void moveToResult()
    {
        if (!isMove.booleanValue())
        {
            if (mp.isPlaying())
            {
                mp.stop();
            }
            if(MediaStatusValue)
            mpEnd.start();
            isMove = Boolean.valueOf(true);
            Intent intent;
            if (Store.getReferenceInt(this, "score") != 0)
            {
                if (score > Store.getReferenceInt(this, "score"))
                {
                    Store.setReferenceInt(this, "score", score);
                }
            } else
            {
                Store.setReferenceInt(this, "score", score);
            }
            intent = new Intent(this,Result.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    private int randomValue(int i, int j)
    {
        int k;
        do
        {
            k = (new Random()).nextInt(j);
        } while (i == k);
        return k;
    }

    private void startGame()
    {
        process = 0;
        if (isFirst.booleanValue())
        {
            countDownTimer.cancel();
            countDownTimer.start();
        }
        elemetOfTextColors = randomValue(elemetOfTextColors, textColors.length);
        textGame.setText(textColors[elemetOfTextColors]);
        addArray(elemetOfTextColors);
        elementOfColors = (new Random()).nextInt(listColor.size());
        textGame.setTextColor(getResources().getColor(((Integer)listColor.get(elementOfColors)).intValue()));
        if (getResources().getColor(((Integer)listColor.get(elementOfColors)).intValue()) == getResources().getColor(((Integer)listColor.get(elemetOfTextColors)).intValue()))
        {
            result = 1;
        } else
        {
            result = 0;
        }
        isClick = Boolean.valueOf(false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.play);
        progressBar = (ProgressBar)findViewById(R.id.play_process);
        textViewScore = (TextView)findViewById(R.id.play_score);
        textGame = (TextView)findViewById(R.id.play_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "FUTURASTD-BOLD.TTF");
        textGame.setTypeface(typeface);
        textViewScore.setTypeface(typeface);
        buttonNo = (Button)findViewById(R.id.play_button_no);
        buttonYes = (Button)findViewById(R.id.play_button_yes);
        mAdView = (AdView) findViewById(R.id.adView);
	    mAdView.loadAd(new AdRequest.Builder().build());
	    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        MediaStatusValue = sharedPreferences.getBoolean(MediaStatusKey, true);
       
        countDownTimer = new CountDownTimer(Long.parseLong(getString(R.string.time)), 100) {


            public void onFinish()
            {
                Play play = Play.this;
                play.process = 1 + play.process;
                progressBar.setProgress(process);
                moveToResult();
            }

            public void onTick(long l)
            {
                Play play = Play.this;
                play.process = 1 + play.process;
                progressBar.setProgress(process);
            }
            
        };
        buttonYes.setOnClickListener(new android.view.View.OnClickListener() {



            public void onClick(View view)
            {
                checkResult(1);
            }
            
        });
        buttonNo.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                checkResult(0);
            }

         });
 
        mp = MediaPlayer.create(this, R.raw.button);
        mpEnd = MediaPlayer.create(this, R.raw.end);
    }

    public void onDestroy()
    {
    	super.onDestroy();
    }

    protected void onPause()
    {
        process = 0;
        countDownTimer.cancel();
        finish();
        super.onPause();
    }

    protected void onResume()
    {
        isMove = Boolean.valueOf(false);
        isClick = Boolean.valueOf(false);
        score = 0;
        startGame();
        super.onResume();
    }


}
