package com.homework.shudu;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends Activity {
    Button setting,color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setting = (Button) findViewById(R.id.setting);
        color = (Button) findViewById(R.id.color);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Setting.this,Prefs.class);
                startActivity(intent);

            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Setting.this,ChangeTheme.class);
                startActivity(intent1);
            }
        });
    }
}