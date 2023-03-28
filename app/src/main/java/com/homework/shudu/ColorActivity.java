package com.homework.shudu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends Activity {
    Context context;
    private Button btnColorPicker,btnColorPicker1,btnColorPicker2;

    public static int colour = Color.rgb(213,235,225);
    public static int fontcolour = Color.rgb(240, 145, 146);
    public static int linecolour = Color.rgb(249, 193, 100);
    private ColorPickerDialog dialog,dialog1,dialog2;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initViews();
    }
    private void initViews() {
    	btnColorPicker = (Button) findViewById(R.id.btn_color_picker);
    	btnColorPicker1= (Button) findViewById(R.id.btn_color_picker1);
    	btnColorPicker2= (Button) findViewById(R.id.btn_color_picker2);
    	btnColorPicker.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog = new ColorPickerDialog(context, btnColorPicker.getTextColors().getDefaultColor(),
						getResources().getString(R.string.btn_color_picker),
						new ColorPickerDialog.OnColorChangedListener() {

					@Override
					public void colorChanged(int color) {
						btnColorPicker.setTextColor(color);
						colour = color;
						btnColorPicker.setTextColor(color);
					}
				});
				dialog.show();
			}
			
    	});
    	btnColorPicker1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog1 = new ColorPickerDialog(context, btnColorPicker1.getTextColors().getDefaultColor(),
						getResources().getString(R.string.btn_color_picker1), 
						new ColorPickerDialog.OnColorChangedListener() {
					
					@Override
					public void colorChanged(int color) {
						btnColorPicker1.setTextColor(color);
						fontcolour = color;
						btnColorPicker1.setTextColor(color);
					}
				});
				dialog1.show();
			}
		});
    	btnColorPicker2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog2 = new ColorPickerDialog(context, btnColorPicker2.getTextColors().getDefaultColor(),
						getResources().getString(R.string.btn_color_picker2), 
						new ColorPickerDialog.OnColorChangedListener() {
					
					@Override
					public void colorChanged(int color) {
						btnColorPicker2.setTextColor(color);
						linecolour = color;
						btnColorPicker2.setTextColor(color);
					}
				});
				dialog2.show();
			}
		});

    }
}