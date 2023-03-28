package com.homework.shudu;



import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DrawView extends View {

	private Game new_game;
	private Music music = new Music();
	private Prefs prefs =new Prefs();
	private int difficulty;
	private int i,j,m=0;
	private float width,height;
	public final Rect selRect=new Rect();
	private int selX=9,selY=9;
	public String[][] puzzle = new String[9][9];




//
//		long startTime=System.currentTimeMillis();   //获取开始时间
//		//函数主体代码
//		long endTime=System.currentTimeMillis(); //获取结束时间

//	初始化预设
	public String[][]  easyPuzzle = new String[][]{
			{"9","8"," ","5"," "," ","1","7","4"},
			{" ","3","6"," "," ","9","5"," ","2"},
			{"1","5"," ","4"," "," "," "," ","9"},
			{"8"," "," "," ","2"," "," "," "," "},
			{" ","6","3"," ","9","5"," "," ","8"},
			{"7","1"," ","8","4"," "," "," "," "},
			{"3"," ","4","9"," "," "," "," "," "},
			{"6"," "," ","3","7","4","8","2","5"},
			{"5"," ","8"," ","6","1","4"," "," "},
	};
	public String[][]  mediumPuzzle = new String[][]{
			{"1"," "," "," "," "," "," "," "," "},
			{" ","2"," "," "," "," "," "," "," "},
			{" "," ","3"," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," ","4"," "," "," "," "," "},
			{"6"," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{"8"," "," "," "," "," ","4"," "," "},
			{"9"," "," "," "," "," "," "," "," "},
	};
	public String[][]  hardPuzzle = new String[][]{
			{"1"," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{"3"," "," "," "," ","4"," "," "," "},
			{" "," "," "," "," "," "," ","2"," "},
			{"5"," "," "," "," "," "," "," "," "},
			{"6"," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," ","7"," "," "},
			{" "," "," "," ","8"," "," "," "," "},
			{"9"," "," "," "," "," "," "," ","1"},
	};
	

	public DrawView(Context context, int diff) {
		super(context);
		//取得绘图的上下文环境
		new_game=(Game)context;
		setFocusable(true);//允许键盘事件为true，才会响应该事件
		setFocusableInTouchMode(true);//允许触屏事件为true才会响应相应事件
		for(i=0;i<9;i++)
			for(j=0;j<9;j++){
				switch(diff){
				case 0:
					puzzle[i][j]=easyPuzzle[i][j];
					break;
				case 1:
					puzzle[i][j]=mediumPuzzle[i][j];
					break;
				case 2:
					puzzle[i][j]=hardPuzzle[i][j];
					break;
				case -1:

//
//					ArrayList arr =  db.getAll();
//					ArrayList arr1 =  db.getAllnow();
//					NowUser u = (NowUser) arr1.get(0);
//					for (int i = 0; i < arr.size(); i++) {
//						User dbUser = (User) arr.get(i);
//						if (   u.getName().equals(dbUser.getName()) ){
//							puzzle[i][j]=dbUser.getPuzzle().substring(m,m+1);
//							m++;
//							break;
//						}
//					}


//
					puzzle[i][j]=new_game.continueString.substring(m,m+1);
					m++;
					break;
				}
			}
	}
	//绘制9*9的格子，利用线条颜色的不同吧81个 格子形成九宫格
	@Override
	protected void onDraw(Canvas canvas) {
//		setBackgroundColor(R.drawable.bg);
		super.onDraw(canvas);
		/*绘制背景颜色*/
		canvas.drawColor(ColorActivity.colour);
//		canvas.drawColor(R.drawable.bg);
		//实例化画笔
		Paint paint = new Paint();
		//消去画笔锯齿
		paint.setAntiAlias(true);
		//设置画笔的样式为实心
		paint.setStyle(Paint.Style.FILL);
		//设置画笔粗细
		paint.setStrokeWidth(1);
		//定义颜色
		paint.setColor(ColorActivity.linecolour);
		//绘制线条
		width = getWidth()/9f;
		height = width;
//		height = getHeight()/9f;
		for(i=0;i<=9;i++){
			canvas.drawLine(0, i*height, getWidth(), i*height, paint);
			canvas.drawLine(i*width, 0, i*width, getWidth(), paint);
		}
		paint.setStrokeWidth(3);
		for(i=0;i<=9;i=i+3){
			canvas.drawLine(0, i*height, getWidth(), i*height, paint);
			canvas.drawLine(i*width, 0, i*width, getWidth(), paint);
		}
		//绘制九宫格内数字
		Paint fontPaint = new Paint();
		fontPaint.setColor(ColorActivity.fontcolour);

		fontPaint.setTextSize(prefs.getTextSize(getContext()));
		for(i=0;i<9;i++)
			for(j=0;j<9;j++){
				canvas.drawText(puzzle[i][j], j*width+(width*0.3f), i*height+(height*0.6f), fontPaint);
			}
		//绘制矩形

		fontPaint.setColor(Color.argb(60,240, 145, 146));
		canvas.drawRect(selRect, fontPaint);
	}
	/*
	 * onSizeChanged在屏幕发生改变的时候调用，在初始化一个屏幕时，在onCreate方法之前调用 
	 * 通过重写该方法，在其内部获取屏幕的宽度，从而获取游戏中矩形框的宽度和高度
	 * */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width=getWidth()/9f;
		height=getHeight()/9f;
		getRect(selX,selY,selRect);
	}

	/*根据传入的selX和selY重新设置矩形的，长、宽和初始为主*/
	private void getRect(float selX,float selY,Rect selRect){
		selRect.set((int)(selX*width)+1,(int)( selY*height)+1, (int)((selX+1)*width)-1, (int)((selY+1)*height)-1);
	}
	
	public void setTitle(String t){
		String l = "null";
		if(t.equals(l)){

			puzzle[selY][selX]=" ";
			invalidate(selRect);
		}else {
			int flag = 0;

			for(int i =0;i<9;i++){
				if(puzzle[selY][i].equals(t)||puzzle[i][selX].equals(t))
					flag=1;
			}
			int xx = (selX) / 3, yy = (selY) / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (puzzle[yy * 3 + i][xx * 3 + j].equals(t))
						flag = 1;
				}
			}
			if(flag==1){
				Thread newThread = new Thread(){
					@Override
					public void run(){
						music.playSound(getContext(), R.raw.sound);
					}
				};
				newThread.start();
				Toast.makeText(getContext(), "输入冲突", 8000).show();

			}
			else
				puzzle[selY][selX]=t;
			invalidate(selRect);
		}
	}
	
	/*相应触屏功能*/
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		selX=(int) (event.getX()/width);
		if (event.getY()>width*9){
			return false;
		}else{
			selY=(int) (event.getY()/height);
		}
//		selY=(int) (event.getY()/height);
//		selRect.set((int)(selY*width)+1,(int)( selX*height)+1, (int)((selY+1)*width)-1, (int)((selX+1)*height)-1);
		invalidate(selRect);
		getRect(selX, selY, selRect);
		invalidate(selRect);
		new KeyPad(getContext(), this).show();
		return false;
	}
	
	 /** 根据用户点击的方向键，设置选中矩形的位置， invalidate()，通知onDraw重新绘图
	 * */
		public void selectXY(int x,int y){
		invalidate(selRect);
	}

}
