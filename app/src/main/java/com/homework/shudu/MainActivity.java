package com.homework.shudu;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button start,goon,about,exchange,exit,setting;
	private Game game = new Game();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		start=(Button) findViewById(R.id.btBegin);
		goon=(Button) findViewById(R.id.btContinue);
		about=(Button) findViewById(R.id.btAbout);
		exchange =(Button) findViewById(R.id.btExchange);
		exit=(Button) findViewById(R.id.btExit);
		setting=findViewById(R.id.btSetting);
		start.setOnClickListener(this);
		goon.setOnClickListener(this);
		about.setOnClickListener(this);
		exchange.setOnClickListener(this);
		exit.setOnClickListener(this);
		setting.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.btBegin:
				Intent intent = new Intent(MainActivity.this, ChangeLevel.class);
				startActivity(intent);
				break;
			case R.id.btContinue:
				if(game.begin==0)
					startNewGame(0);
				else
					startNewGame(-1);
				break;
			case R.id.btAbout:
				Intent intent01=new Intent();
				intent01.setClass(this,About.class);
				startActivity(intent01);
				break;
			case R.id.btExchange:
				Intent intent03=new Intent();
				intent03.setClass(this,Personal.class);
				startActivity(intent03);
				break;
			case R.id.btExit:
//				exitAlert("确定退出吗？");

				Intent intent00=new Intent(this,MainPage.class);
				intent00.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

				startActivity(intent00);
				break;
			case R.id.btSetting:
				Intent intent02=new Intent();
				intent02.setClass(this,Setting.class);
				startActivity(intent02);
				break;
		}
	}

	// 显示对话框
	private void exitAlert(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
				.setTitle("提示")
				.setCancelable(true)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finish();
					}
				}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						return;
					}
				});
		AlertDialog alert = builder.create();
		//alert.setContentView(R.style.blackDialog);
		alert.show();
	}
	private void startNewGame(int diff){
		Intent intent=new Intent(this,Game.class);
		intent.putExtra("diff", diff);
		startActivity(intent);
	}



}
