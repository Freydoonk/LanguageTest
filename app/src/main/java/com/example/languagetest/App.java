package com.example.languagetest;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.example.languagetest.utils.LocaleManager;

public class App extends Application {

    // for the sake of simplicity. use DI in real apps instead
    public static LocaleManager localeManager;

    @Override
    protected void attachBaseContext(Context base) {
        localeManager = new LocaleManager();
        super.attachBaseContext(localeManager.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
    }
}