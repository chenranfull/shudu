package com.homework.shudu;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangeLevel extends Activity {
        Button easy_bt,medium_bt,hard_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_button);

        easy_bt=findViewById(R.id.easy_bt);
        medium_bt=findViewById(R.id.medium_bt);
        hard_bt=findViewById(R.id.hard_bt);
        easy_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame(0);
                finish();
            }
        });

        medium_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame(1);
                finish();
            }
        });
        hard_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame(2);
                finish();
            }
        });



    }

    private void startNewGame(int diff){
        Intent intent=new Intent(this,Game.class);
        intent.putExtra("diff", diff);
        startActivity(intent);
    }

}