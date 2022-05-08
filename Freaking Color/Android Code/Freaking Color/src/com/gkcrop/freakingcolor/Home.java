package com.gkcrop.freakingcolor;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends Activity {
	
	Button btn_start,btn_try;
	ImageView img_rate,img_moreapp,imageViewMediaMenu;
	private AdView mAdView;
	private InterstitialAd mInterstitial;
	Editor editor;
	SharedPreferences sharedPreferences;
	String MediaStatusKey;
    boolean MediaStatusValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		btn_start=(Button)findViewById(R.id.button_start);
		btn_try=(Button)findViewById(R.id.button_try);
		MediaStatusKey = "MediaStatusKey";
	    MediaStatusValue = true;
		
		imageViewMediaMenu = (ImageView)findViewById(R.id.imageViewMediaMenu);
	    img_rate=(ImageView)findViewById(R.id.img_rateapp);
	    img_moreapp=(ImageView)findViewById(R.id.img_moreapp);
	    
	    imageViewMediaMenu.setOnClickListener(new View.OnClickListener() {

        	public void onClick(View view)
            {
                Home menuactivity = Home.this;
                boolean flag;
                if (MediaStatusValue)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                menuactivity.MediaStatusValue = flag;
                if (MediaStatusValue)
                {
                    imageViewMediaMenu.setImageResource(R.drawable.sound);
                } else
                {
                    imageViewMediaMenu.setImageResource(R.drawable.mute);
                }
                editor.putBoolean(MediaStatusKey, MediaStatusValue);
                editor.commit();
            }
        });
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        MediaStatusValue = sharedPreferences.getBoolean(MediaStatusKey, true);
        if (MediaStatusValue)
        {
            imageViewMediaMenu.setImageResource(R.drawable.sound);
        } else
        {
            imageViewMediaMenu.setImageResource(R.drawable.mute);
        }
	    
	    mAdView = (AdView) findViewById(R.id.adView);
	    mAdView.loadAd(new AdRequest.Builder().build());
	    
	    mInterstitial = new InterstitialAd(this);
		mInterstitial.setAdUnitId(getResources().getString(R.string.admob_intertestial_id));
		mInterstitial.loadAd(new AdRequest.Builder().build());
		
		
		btn_start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Play.class);
                startActivity(intent);
                
			}
		});
		
		btn_try.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Tutorial.class);
				startActivity(intent);
				
			}
		});
		
		
		
	     img_rate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
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
	        
	        img_moreapp.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse(getString(R.string.play_more_apps))));
					
				}
			});
		
	}
	
	
	 @Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			
			AlertDialog.Builder alert = new AlertDialog.Builder(
					Home.this);
			alert.setTitle(getString(R.string.app_name));
			alert.setIcon(R.drawable.ic_launcher);
			alert.setMessage(getString(R.string.exit_msg));
		
			alert.setPositiveButton(getString(R.string.exit_yes),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							
							 //you may open Interstitial Ads here
							 if (mInterstitial.isLoaded()) {
						            mInterstitial.show();
						        }
							finish();
						}

			});
		
			alert.setNegativeButton(getString(R.string.exit_no),
					new DialogInterface.OnClickListener() {
		
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							 
							 
						}
					});
			alert.show();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
		
		}

}
