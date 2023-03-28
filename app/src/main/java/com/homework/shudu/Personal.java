package com.homework.shudu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Personal extends Activity {
    Button sign_personal,back_personal;
    EditText name_personal, psw_personal,psw2_personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        DataBase dataBase = new DataBase(this);
        sign_personal = findViewById(R.id.sign_personal);
        back_personal = findViewById(R.id.back_personal);
        name_personal = findViewById(R.id.name_personal);
        psw_personal = findViewById(R.id.psw_personal);
        psw2_personal = findViewById(R.id.psw2_personal);

        sign_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String n = name_personal.getText().toString();
                String p = psw_personal.getText().toString();
                String p2 = psw2_personal.getText().toString();
                User u = new User(n,p);
                if (p.equals(p2)){
//                ArrayList arrayList =  dataBase.getAllnow();
//                arrayList.get(0);

                   if(dataBase.updateData(n,u)){
                       Toast.makeText(Personal.this,"修改完成，请牢记您的密码",Toast.LENGTH_SHORT).show();
                       Intent intent01 = new Intent(Personal.this, Login.class);
                       intent01.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                       startActivity(intent01);

                   }
                }else{
                    Toast.makeText(Personal.this,"修改失败，两次密码输入不一致",Toast.LENGTH_SHORT).show();
                }


            }
        });
        back_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Personal.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}