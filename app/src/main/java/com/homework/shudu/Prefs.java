package com.homework.shudu;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Prefs extends PreferenceActivity {
	public static int textSize = 44;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
	}
	public static boolean getBackMusic(Context context){
		return 
				PreferenceManager.getDefaultSharedPreferences(context).getBoolean("music",true);
	}
	public static boolean getSoundSet(Context context){
		return
				PreferenceManager.getDefaultSharedPreferences(context).getBoolean("sound", true);
	}
	public static int getTextSize(Context context){
		textSize = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("textsize", "44"));
		return textSize;
	}
}
