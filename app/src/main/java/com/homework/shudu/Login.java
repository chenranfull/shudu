package com.homework.shudu;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends Activity {

    Button login_login,back_login;
    EditText name_login,psw_login;
    NowUser nUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_login = findViewById(R.id.login_login);
        back_login = findViewById(R.id.back_login);
        name_login = findViewById(R.id.name_login);
        psw_login = findViewById(R.id.psw_login);
        DataBase dataBase = new DataBase(this);

        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainPage.class);
                startActivity(intent);

            }
        });
        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =  name_login.getText().toString();
                String psw = psw_login.getText().toString();
                String puzzle = "1" ;
                User user = new User(name, psw, puzzle);

                if( NameNoNUll(user, dataBase.getAll())){

                    if ( toLogin(user, dataBase.getAll())){
                        nUser= new NowUser(name);
                        boolean b = dataBase.addnow(nUser.getName());
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                        finish();

                    }else {

                    }

                }else{
                    Toast.makeText(Login.this,"登录失败,账号未注册",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean toLogin(User user,ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            User dbUser = (User) arrayList.get(i);
            if (    user.getName().equals(dbUser.getName()) && user.getPsw().equals(dbUser.getPsw()) ){

                return true;
            }
        }
        return false ;
    }
    public boolean NameNoNUll(User user,ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            User dbUser = (User) arrayList.get(i);
            if (    user.getName().equals(dbUser.getName())  ){

                return true;
            }
        }
        return false ;



    }

}