package com.example.languagetest.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

public class LocaleManager
{

	private static final String LANGUAGE_FARSI = "fa";

	public LocaleManager()
	{}

	public Context setLocale(Context c)
	{
		return updateResources(c, getLanguage());
	}


	private String getLanguage()
	{
		return LANGUAGE_FARSI;
	}

	private Context updateResources(Context context, String language)
	{
		Locale locale = new Locale(language);
		Locale.setDefault(locale);

		Resources res = context.getResources();
		Configuration config = new Configuration(res.getConfiguration());
		if (Build.VERSION.SDK_INT  >= JELLY_BEAN_MR1)
		{
			config.setLocale(locale);
			context = context.createConfigurationContext(config);
		}
		else
		{
			config.locale = locale;
			res.updateConfiguration(config, res.getDisplayMetrics());
		}
		return context;
	}
}