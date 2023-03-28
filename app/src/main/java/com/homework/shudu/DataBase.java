package com.homework.shudu;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    private SQLiteDatabase dp;
    public DataBase(Context context){
        super(context,"TEXT1.dp",null,1);
        dp = this.getWritableDatabase();
    }
    public boolean add(String name,String psw){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("psw",psw);

        long i = dp.insert("users",null,values);
        if(i>0){
            Log.d("","注册成功");
            return true;
        }return false;
    }
    public boolean addnow(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);

        long i = dp.insert("nowusers",null,values);
        if(i>0){
            Log.d("","baocun");
            return true;
        }return false;
    }
    public ArrayList getAll(){
        ArrayList arr = new ArrayList();
        Cursor cursor = dp.query("users",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString( cursor.getColumnIndex("name"));
            @SuppressLint("Range") String psw = cursor.getString( cursor.getColumnIndex("psw"));

            User u = new User(name,psw);
            arr.add(u);
        }return arr;
    }

    public ArrayList getAllnow(){
        ArrayList arr = new ArrayList();
        Cursor cursor = dp.query("nowusers",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString( cursor.getColumnIndex("name"));

            NowUser u = new NowUser(name);
            arr.add(u);
        }return arr;
    }

    public boolean updateData(String  name, User user) {
        ContentValues cv = new ContentValues();

        cv.put("name", user.getName());
        cv.put("psw", user.getPsw());
        cv.put("puzzle", user.getPuzzle());

        dp.update("users", cv, "name" + "=" + name, null);
        return true;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table users (name text primary key,psw text not null,puzzle text)";
        sqLiteDatabase.execSQL(sql);
        String sql1 = "create table nowusers (name text primary key)";
        sqLiteDatabase.execSQL(sql1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
