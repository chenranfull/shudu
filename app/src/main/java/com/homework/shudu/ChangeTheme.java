package com.homework.shudu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ChangeTheme extends Activity implements OnItemClickListener{
	private ListView lv;
	private SimpleAdapter simp_adapter;
	private List<Map<String,Object>> simp_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_theme);
		lv = (ListView) findViewById(R.id.listView);
		simp_list = new ArrayList<Map<String,Object>>();
		simp_adapter = new SimpleAdapter(this, getData(), R.layout.theme_item, new String[]{"img","text"}, new int[]{R.id.img,R.id.text});
		lv.setAdapter(simp_adapter);
		lv.setOnItemClickListener(this);
	}
	private List<Map<String, Object>> getData() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("img", R.drawable.green);
		map.put("text", "草地绿");
		simp_list.add(map);
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("img", R.drawable.blue);
		map1.put("text", "天空蓝");
		simp_list.add(map1);
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("img", R.drawable.black);
		map2.put("text", "深沉黑");
		simp_list.add(map2);
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("img", R.drawable.diy);
		map3.put("text", "自定义");
		simp_list.add(map3);
		Map<String,Object> map4 = new HashMap<String,Object>();
		map4.put("img", R.drawable.reset);
		map4.put("text", "恢复默认");
		simp_list.add(map4);
		return simp_list;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int p,
			long arg3) {
		switch(p){
		case 0:
			ColorActivity.colour = Color.rgb(154,204,153);
			ColorActivity.fontcolour = Color.rgb(0, 153, 102);
			ColorActivity.linecolour = Color.rgb(24, 168, 119);
			Toast.makeText(this, "已设定：草地绿", 0).show();
			break;
		case 1:
			ColorActivity.colour = Color.rgb(137,180,224);
			ColorActivity.fontcolour = Color.rgb(0, 108, 255);
			ColorActivity.linecolour = Color.rgb(51, 153, 204);
			Toast.makeText(this, "已设定：天空蓝", 0).show();
			break;
		case 2:
			ColorActivity.colour = Color.rgb(12,19,21);
			ColorActivity.fontcolour = Color.rgb(189, 196, 204);
			ColorActivity.linecolour = Color.rgb(20, 49, 64);
			Toast.makeText(this, "已设定：深沉黑", 0).show();
			break;
		case 3:
			Intent intent = new Intent(ChangeTheme.this, ColorActivity.class);
			startActivity(intent);
			break;
		case 4:
			ColorActivity.colour = Color.rgb(213,235,225);
			ColorActivity.fontcolour = Color.rgb(240, 145, 146);
			ColorActivity.linecolour = Color.rgb(249, 193, 100);
			Toast.makeText(this, "已恢复默认主题", 0).show();
			break;
		}
	}
}
