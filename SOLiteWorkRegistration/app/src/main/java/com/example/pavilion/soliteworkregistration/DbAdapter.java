package com.example.pavilion.soliteworkregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by Pavilion on 29-04-2016.
 */
public class DbAdapter
{
    private static final String DB_Name = "mydb";
    private  static  final int version = 1;

    public   static  final  String ID = "Id";
    public   static final String Name = "Name";
    public   static final String city="City";
    public   static final String state="State";

    private static final String Table_Name ="Savings";

    private static  final String Query = "create table "+Table_Name+ " ("+ID+" integer primary key autoincrement,"+ Name +" text not null,"+city+" text not null,"+state+" text not null);";

    private  Context context;
    private  DbHelper dbHelper;
    private SQLiteDatabase db;

      public DbAdapter(Context ctx)
      {
            this.context = ctx;
            dbHelper = new DbHelper(ctx,DB_Name,null,version);
      }

      private  class DbHelper extends SQLiteOpenHelper
      {

          public DbHelper(Context ctx,String dbName, SQLiteDatabase.CursorFactory factory, int version)
          {
              super(ctx,dbName,factory,version);
          }

          @Override
          public void onCreate(SQLiteDatabase db) {
              try{
                  db.execSQL(Query);
              }catch (Exception e)
              {
                  Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
              }
          }

          @Override
          public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

          }
      }

    public  DbAdapter open() throws  SQLException
    {

            db = dbHelper.getWritableDatabase();
        return  this;
    }

    public void close()
    {
        dbHelper.close();
    }

    public  boolean contacts(String Nm,String ct,String st)
    {
        ContentValues values = new ContentValues();
        values.put(Name,Nm);
        values.put(city,ct);
        values.put(state, st);
        return db.insert(Table_Name,null,values) > 0 ? true : false;
    }

    public Cursor getAllContacts()
    {
        return  db.query(Table_Name, new  String[]{Name,city,state},null,null,null,null,null);
    }
}
