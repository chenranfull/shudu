package com.homework.shudu;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KeyPad extends Dialog implements android.view.View.OnClickListener {
	DrawView drawView;
	Button[] btn = new Button[10];
	public KeyPad(Context context, DrawView drawView) {
		super(context,R.style.style1);
		this.drawView=drawView;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keypad);
		btn[0]=(Button) findViewById(R.id.keypad_1);
		btn[1]=(Button) findViewById(R.id.keypad_2);
		btn[2]=(Button) findViewById(R.id.keypad_3);
		btn[3]=(Button) findViewById(R.id.keypad_4);
		btn[4]=(Button) findViewById(R.id.keypad_5);
		btn[5]=(Button) findViewById(R.id.keypad_6);
		btn[6]=(Button) findViewById(R.id.keypad_7);
		btn[7]=(Button) findViewById(R.id.keypad_8);
		btn[8]=(Button) findViewById(R.id.keypad_9);
		btn[9]=(Button) findViewById(R.id.keypad_01);

		for(int i = 0;i<10;i++){
			btn[i].setOnClickListener(this);
		}
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.keypad_1:
			drawView.setTitle("1");
			break;
		case R.id.keypad_2:
			drawView.setTitle("2");
			break;
		case R.id.keypad_3:
			drawView.setTitle("3");
			break;
		case R.id.keypad_4:
			drawView.setTitle("4");
			break;
		case R.id.keypad_5:
			drawView.setTitle("5");
			break;
		case R.id.keypad_6:
			drawView.setTitle("6");
			break;
		case R.id.keypad_7:
			drawView.setTitle("7");
			break;
		case R.id.keypad_8:
			drawView.setTitle("8");
			break;
		case R.id.keypad_9:
			drawView.setTitle("9");
			break;
		case R.id.keypad_01:
				drawView.setTitle("null");
				break;
		}
		dismiss();
	}
}
