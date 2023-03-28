package com.homework.shudu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainPage extends Activity {
    public int Sign_RequestCode = 1;
    EditText name;
    EditText psw;
    Button sign;
    Button login,nopsw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

//        name = findViewById(R.id.name);
//        nopsw = findViewById(R.id.nopsw);
        sign = findViewById(R.id.sign);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Login.class);
                startActivity(intent);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, Sign.class);
                startActivity(intent);
            }
        });
        //游客登录
//        nopsw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(MainPage.this,MainActivity.class);
//                startActivityForResult(intent,Sign_RequestCode);
//
//            }
//        });
    }


}