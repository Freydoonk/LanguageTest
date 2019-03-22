package com.example.languagetest.activities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.languagetest.App;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AppCompatActivityBase extends AppCompatActivity
{
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(App.localeManager.setLocale(base));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resetTitle();
	}

	private void resetTitle() {
		try {
			int label = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA).labelRes;
			if (label != 0) {
				setTitle(label);
			}
		} catch (PackageManager.NameNotFoundException e) {  }
	}
}
