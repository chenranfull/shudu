package com.homework.shudu;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign extends Activity {
    Button sign_sign,back_sign;
    EditText name_sign,psw_sign,psw2_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        DataBase dataBase = new DataBase(this);

        sign_sign = findViewById(R.id.sign_sign);
        back_sign = findViewById(R.id.back_sign);
        name_sign = findViewById(R.id.name_sign);
        psw_sign = findViewById(R.id.psw_sign);
        psw2_sign = findViewById(R.id.psw2_sign);

        sign_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String n = name_sign.getText().toString();
                String p = psw_sign.getText().toString();
                String p2 = psw2_sign.getText().toString();

                if (p.equals(p2)){

                    if(dataBase.add(n,p)){
                        Toast.makeText(Sign.this,"添加成功",Toast.LENGTH_SHORT).show();
                        Log.d("","true");
                        Intent intent = new Intent(Sign.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Sign.this,"注册失败，账户已存在",Toast.LENGTH_SHORT).show();
                        Log.d("","false");
                    }
                }else{
                    Toast.makeText(Sign.this,"注册失败，两次密码输入不一致",Toast.LENGTH_SHORT).show();
                }


//                String n = name_sign.getText().toString();
//                String p = psw_sign.getText().toString();
//                String p2 = psw2_sign.getText().toString();
//                String pulzze = "1";
//                if (p.equals(p2)){
//
//                    if(dataBase.add(n,p,pulzze)){
//                        Toast.makeText(Sign.this,"添加成功",Toast.LENGTH_SHORT).show();
//                        Log.d("","true");
//                        Intent intent = new Intent(Sign.this, Login.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(Sign.this,"注册失败，账户已存在",Toast.LENGTH_SHORT).show();
//                        Log.d("","false");
//                    }
//                }else{
//                    Toast.makeText(Sign.this,"注册失败，两次密码输入不一致",Toast.LENGTH_SHORT).show();
//                }
//

            }
        });
        back_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign.this, MainPage.class);

                startActivity(intent);
            }
        });


    }
}