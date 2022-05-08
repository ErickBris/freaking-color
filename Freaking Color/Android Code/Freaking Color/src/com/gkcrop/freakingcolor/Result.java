package com.gkcrop.freakingcolor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity
{

    Button buttonRate;
    Button buttonShare;
    Button buttonTryAgain;
    TextView textViewBest;
    TextView textViewNameBest;
    TextView textViewNameScore;
    TextView textViewScore;
    private int value;

    public Result()
    {
    }

    private void AnimationShow()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        buttonTryAgain.startAnimation(alphaanimation);
        buttonShare.startAnimation(alphaanimation);
        buttonRate.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                buttonTryAgain.setVisibility(0);
                buttonShare.setVisibility(0);
                buttonRate.setVisibility(0);
            }
        });
    }

    private void captureScreen()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT",(new StringBuilder("can you pass my ")).append(Store.getReferenceInt(this, "score")).append(" pts in Color Conflict?").toString()+ "\nAndroid: https://play.google.com/store/apps/details?id="+getPackageName());
        startActivity(Intent.createChooser(intent, "Share"));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.result);
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null)
        {
            value = bundle1.getInt("score");
        }
        Typeface typeface = Typeface.createFromAsset(getAssets(), "FUTURASTD-BOLD.TTF");
        textViewScore = (TextView)findViewById(R.id.result_textScore);
        textViewBest = (TextView)findViewById(R.id.result_textBest);
        textViewScore.setTypeface(typeface);
        textViewBest.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "FUTURASTD-BOOK.TTF");
        textViewNameScore = (TextView)findViewById(R.id.result_name_textScore);
        textViewNameBest = (TextView)findViewById(R.id.result_name_textBest);
        textViewNameScore.setTypeface(typeface1);
        textViewNameBest.setTypeface(typeface1);
        textViewScore.setText((new StringBuilder(String.valueOf(value))).toString());
        textViewBest.setText((new StringBuilder(String.valueOf(Store.getReferenceInt(this, "score")))).toString());
        buttonTryAgain = (Button)findViewById(R.id.result_button_try_again);
        buttonShare = (Button)findViewById(R.id.result_button_share);
        buttonRate = (Button)findViewById(R.id.result_button_rate);
        buttonTryAgain.setVisibility(4);
        buttonShare.setVisibility(4);
        buttonRate.setVisibility(4);
        
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {

        	public void onClick(View view)
            {
                Intent intent = new Intent(Result.this,Play.class);
                intent.addFlags(0x10000000);
                startActivity(intent);
                finish();
            }

        });
        
        
        buttonShare.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {
                captureScreen();
            }
        });
        buttonRate.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
            	final String appName = getPackageName();//your application package name i.e play store application url
				try {
					startActivity(new Intent(Intent.ACTION_VIEW,
							Uri.parse("market://details?id="
									+ appName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/store/apps/details?id="
									+ appName)));
				}
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        (new Thread() {

        	public void run()
            {
                try
                {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                runOnUiThread(new Runnable() {

                    public void run()
                    {
                        AnimationShow();
                    }
                });
            }

        }).start();
    }

}