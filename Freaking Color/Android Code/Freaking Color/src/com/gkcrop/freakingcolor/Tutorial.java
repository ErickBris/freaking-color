package com.gkcrop.freakingcolor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Tutorial extends Activity
{

    private LinearLayout background;
    private Boolean isClickFirst;
    private LinearLayout linear_dyk;
    private LinearLayout linear_tut1;
    private LinearLayout linear_tut2;
    private TextView text_but;
    private TextView text_dyk;
    private TextView text_your_left;
    private TextView text_your_right;
    private Button tutorial_button_no;
    private Button tutorial_button_play;
    private Button tutorial_button_yes;
    private TextView tutorial_text;
    private TextView tutorial_text_fade;

    public Tutorial()
    {
        isClickFirst = Boolean.valueOf(false);
    }

    private void AnimationTut()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        tutorial_text_fade.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {

            

            public void onAnimationEnd(Animation animation)
            {
                (new Thread() {

                    public void run()
                    {
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {


                            public void run()
                            {
                                AnimationTut1();
                            }
            
                        });
                    }
                }).start();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                tutorial_text_fade.setVisibility(0);
            }

        });
    }

    private void AnimationTut1()
    {
        tutorial_text_fade.setText("THE COLOR IS BLUE?");
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(1000);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        tutorial_text_fade.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {

            

            public void onAnimationEnd(Animation animation)
            {
                tutorial_button_no.setVisibility(0);
                tutorial_button_yes.setVisibility(0);
                AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation1.setDuration(1000);
                alphaanimation1.setFillAfter(true);
                alphaanimation1.setFillBefore(true);
                alphaanimation1.setFillEnabled(true);
                tutorial_button_no.startAnimation(alphaanimation1);
                tutorial_button_yes.startAnimation(alphaanimation1);
                alphaanimation1.setAnimationListener(new AnimationListener() {

                    public void onAnimationEnd(Animation animation)
                    {
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                        tutorial_button_no.setVisibility(0);
                        tutorial_button_yes.setVisibility(0);
                    }
            
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            	
            }
        });
    }

    private void AnimationTut2()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(500);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        tutorial_text.startAnimation(alphaanimation);
        tutorial_text_fade.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
                tutorial_text_fade.setText("THE COLOR IS YELLOW?");
                tutorial_text.setText("YELLOW");
                tutorial_text.setTextColor(getResources().getColor(R.color.yellow));
                AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation1.setDuration(500);
                alphaanimation1.setFillAfter(true);
                alphaanimation1.setFillBefore(true);
                alphaanimation1.setFillEnabled(true);
                tutorial_text.startAnimation(alphaanimation1);
                alphaanimation1.setAnimationListener(new AnimationListener() {

                

                    public void onAnimationEnd(Animation animation)
                    {
                        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                        alphaanimation.setDuration(500);
                        alphaanimation.setFillAfter(true);
                        alphaanimation.setFillBefore(true);
                        alphaanimation.setFillEnabled(true);
                        tutorial_text_fade.startAnimation(alphaanimation);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

        });
    }

    private void AnimationTut3()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(500);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        linear_tut1.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {



            public void onAnimationEnd(Animation animation)
            {
                linear_tut1.setVisibility(8);
                background.setBackgroundColor(getResources().getColor(R.color.background));
                AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation1.setDuration(500);
                alphaanimation1.setFillAfter(true);
                alphaanimation1.setFillBefore(true);
                alphaanimation1.setFillEnabled(true);
                linear_tut2.startAnimation(alphaanimation1);
                alphaanimation1.setAnimationListener(new AnimationListener() {

                    public void onAnimationEnd(Animation animation)
                    {
                        (new Thread() {

                            public void run()
                            {
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch (InterruptedException interruptedexception)
                                {
                                    interruptedexception.printStackTrace();
                                }
                                runOnUiThread(new Runnable() {

                                    public void run()
                                    {
                                        AnimationTut4();
                                    }
            
                                });
                            }
                        }).start();
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }
        });
    }

    private void AnimationTut4()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(500);
        alphaanimation.setFillAfter(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillEnabled(true);
        linear_dyk.startAnimation(alphaanimation);
        alphaanimation.setAnimationListener(new AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
                linear_dyk.setVisibility(8);
                background.setBackgroundColor(getResources().getColor(R.color.background));
                AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation1.setDuration(500);
                alphaanimation1.setFillAfter(true);
                alphaanimation1.setFillBefore(true);
                alphaanimation1.setFillEnabled(true);
                text_but.setVisibility(8);
                text_your_left.setVisibility(8);
                text_your_right.setVisibility(0);
                tutorial_button_play.setVisibility(8);
                text_your_right.startAnimation(alphaanimation1);
                alphaanimation1.setAnimationListener(new AnimationListener() {


                    public void onAnimationEnd(Animation animation)
                    {
                        text_but.setVisibility(0);
                        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                        alphaanimation.setDuration(500);
                        alphaanimation.setFillAfter(true);
                        alphaanimation.setFillBefore(true);
                        alphaanimation.setFillEnabled(true);
                        text_but.startAnimation(alphaanimation);
                        alphaanimation.setAnimationListener(new AnimationListener() {

                            public void onAnimationEnd(Animation animation)
                            {
                                text_your_left.setVisibility(0);
                                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                                alphaanimation.setDuration(500);
                                alphaanimation.setFillAfter(true);
                                alphaanimation.setFillBefore(true);
                                alphaanimation.setFillEnabled(true);
                                text_your_left.startAnimation(alphaanimation);
                                alphaanimation.setAnimationListener(new AnimationListener() {

                                    public void onAnimationEnd(Animation animation)
                                    {
                                        tutorial_button_play.setVisibility(0);
                                        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                                        alphaanimation.setDuration(500);
                                        alphaanimation.setFillAfter(true);
                                        alphaanimation.setFillBefore(true);
                                        alphaanimation.setFillEnabled(true);
                                        tutorial_button_play.startAnimation(alphaanimation);
                                    }

                                    public void onAnimationRepeat(Animation animation)
                                    {
                                    }

                                    public void onAnimationStart(Animation animation)
                                    {
                                    }

                                });
                            }

                            public void onAnimationRepeat(Animation animation)
                            {
                            }

                            public void onAnimationStart(Animation animation)
                            {
                            }
                        });
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }
        });
    }

    private void event()
    {
        linear_tut2.setOnClickListener(new android.view.View.OnClickListener() {



            public void onClick(View view)
            {
            }

            
        });
        tutorial_button_play.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                Store.setReferenceBoolean(Tutorial.this, "first", Boolean.valueOf(true));
                Intent intent = new Intent(Tutorial.this, Play.class);
                startActivity(intent);
                finish();
            }
            
        });
        tutorial_button_no.setOnClickListener(new android.view.View.OnClickListener() {


            public void onClick(View view)
            {
                if (!isClickFirst.booleanValue())
                {
                    AnimationTut2();
                    isClickFirst = Boolean.valueOf(true);
                }
            }
        });
        tutorial_button_yes.setOnClickListener(new android.view.View.OnClickListener() {



            public void onClick(View view)
            {
                if (isClickFirst.booleanValue())
                {
                    AnimationTut3();
                }
            }
        });
    }

    private void init()
    {
        background = (LinearLayout)findViewById(R.id.background);
        tutorial_text = (TextView)findViewById(R.id.tutorial_text);
        tutorial_text_fade = (TextView)findViewById(R.id.tutorial_text_fade);
        tutorial_button_no = (Button)findViewById(R.id.tutorial_button_no);
        tutorial_button_yes = (Button)findViewById(R.id.tutorial_button_yes);
        linear_dyk = (LinearLayout)findViewById(R.id.linear_dyk);
        tutorial_button_play = (Button)findViewById(R.id.tutorial_button_play);
        linear_tut1 = (LinearLayout)findViewById(R.id.linear_tut1);
        linear_tut2 = (LinearLayout)findViewById(R.id.linear_tut2);
        text_dyk = (TextView)findViewById(R.id.text_dyk);
        text_your_right = (TextView)findViewById(R.id.text_your_right);
        text_but = (TextView)findViewById(R.id.text_but);
        text_your_left = (TextView)findViewById(R.id.text_your_left);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "FUTURASTD-BOLD.TTF");
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "FUTURASTD-BOOK.TTF");
        tutorial_text.setTypeface(typeface);
        text_dyk.setTypeface(typeface);
        text_but.setTypeface(typeface);
        tutorial_text_fade.setTypeface(typeface1);
        text_your_right.setTypeface(typeface1);
        text_your_left.setTypeface(typeface1);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.tutorial);
        init();
        event();
        (new Thread() {

        	public void run()
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                runOnUiThread(new Runnable() {

                    public void run()
                    {
                        AnimationTut();
                    }
                });
            }
        }).start();
    }

    protected void onResume()
    {
        super.onResume();
    }
}
