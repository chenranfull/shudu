package com.homework.shudu;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
	private static MediaPlayer mp=null;
	private static MediaPlayer mps=null;
	public void play(Context context,int resources){
		stop(context);
		if(Prefs.getBackMusic(context)){
		mp=MediaPlayer.create(context, resources);
		mp.setLooping(true);
		mp.start();
		}
	}
	public static void stop(Context context){
		if(mp!=null){
			mp.stop();
			mp.release();
			mp=null;
		}
	}
	public static void playSound(Context context,int resources){
//		stop(context);
		if(Prefs.getSoundSet(context)){
		mps=MediaPlayer.create(context, resources);
		mps.setLooping(false);
		mps.start();
		}
	}
}
