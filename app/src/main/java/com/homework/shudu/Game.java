package com.homework.shudu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends Activity {
	private Music music=new Music();
	public static int begin = 0;
	protected DrawView puzzleview;
	public String continueString ;
	NowUser	nUser;


	Chronometer chronometer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		int diff = getIntent().getIntExtra("diff", 0);
		continueString  = getPreferences(MODE_PRIVATE).getString("puzzle", "");
		puzzleview=new DrawView(this,diff);
		begin=1;
		//setContentView就是设置一个Activity的显示界面,设置该Activity的显示界面为puzzleview
		setContentView(puzzleview);
		//请求puzzleview获得焦点
		puzzleview.requestFocus();


	}
	@Override
	protected void onResume() {
		super.onResume();
		puzzleview.invalidate();
		music.play(this,R.raw.yue);
		continueString  = getPreferences(MODE_PRIVATE).getString("puzzle", "");
	}
	@Override
	protected void onPause() {
		super.onPause();
		music.stop(this);
		getPreferences(MODE_PRIVATE).edit().putString("puzzle",arraytoString()).commit();
	}
	@Override
	protected void onStop() {
		super.onStop();
		music.stop(this);
		getPreferences(MODE_PRIVATE).edit().putString("puzzle",arraytoString()).commit();

			DataBase db1 = new DataBase(this);
			ArrayList arr =  db1.getAll();

			ArrayList arr1 =  db1.getAllnow();

			nUser = (NowUser) arr1.get(0);
				for (int i = 0; i < arr1.size(); i++) {
						User dbUser = (User) arr.get(i);

					if (    nUser.getName().equals(dbUser.getName()) ){
						dbUser.setPuzzle(continueString);
						db1.updateData(nUser.getName(),dbUser);
					}
				}


	}
	private String arraytoString(){
		String s1 = "";
		for(int i = 0; i <9; i ++)
			for(int j = 0; j <9;j++){
				s1+=puzzleview.puzzle[i][j];
			}
		return s1;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.setting:
			Intent intent = new Intent(Game.this,Prefs.class);
			startActivity(intent);
			break;
		case R.id.readRecord:
			Intent intent1 = new Intent(Game.this,ChangeTheme.class);
			startActivity(intent1);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
