package com.example.pavilion.inverterymanagement;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavilion on 11-05-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DBName = "InventoryManagement";
    private static final int DBVersion = 1;
    public static final String TableName = "IMS";
    private static final String Id = "id";
    private static  String ItemName = "Name";
    private static final String ItemDes = "Description";
    private static final String ItemQuntity = "Quantity";
    private static final String ItemUnits = "Units";
    private static final String ItemPrice = "Price";

    public DatabaseHandler(Context context) {
        super(context, DBName, null, DBVersion);
    }

    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE " + TableName + "(" + Id + " INTEGER PRIMARY KEY AUTOINCREMENT ," + ItemName + " TEXT," + ItemDes + " TEXT," +
         ItemQuntity+" DOUBLE,"+ItemUnits + " TEXT," + ItemPrice + " DOUBLE" + ");";
        db.execSQL(Query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    public void insertItems(String Name, String Des,double quntity,String Units, double Price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemName, Name);
        values.put(ItemDes, Des);
        values.put(ItemQuntity,quntity);
        values.put(ItemUnits, Units);
        values.put(ItemPrice, Price);
        db.insert(TableName, null, values);
        db.close();
    }

    public List<String> getAllItems() {
        List<String> list = new ArrayList<String>();
        String SlQuery = "SELECT * FROM " + TableName;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }

    public List<String> getItemsPrice(String Name) {
        List<String> list = new ArrayList<String>();
        String SlQuery = "SELECT * FROM " + TableName +" WHERE "+ItemName+ " = "+"'"+Name+"' ;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(""+cursor.getInt(0));
                list.add(""+cursor.getDouble(3));
                list.add(""+cursor.getDouble(5));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }

    public String valueSaved(double quantity , double price,int id)
    {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        cv.put(ItemQuntity,quantity);
        cv.put(ItemPrice, price);
        db.update(TableName, cv, Id + " = " + id, null);
        return "Saved Successfully";
    }

}
