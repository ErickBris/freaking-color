package com.gkcrop.freakingcolor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		
		Thread splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (waited < 2000) {
						sleep(100);
						waited += 100;
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
			 
					 Intent intent;
                     if (!Store.getReferenceBoolean(SplashActivity.this, "first").booleanValue())
                     {
                         intent = new Intent(SplashActivity.this, Tutorial.class);
                     } else
                     {
                         intent = new Intent(SplashActivity.this, Home.class);
                     }
                     startActivity(intent);
                     finish();
					 
				}
			}
		};
		splashThread.start();
	}
	
}