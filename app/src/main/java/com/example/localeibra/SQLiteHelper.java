package com.example.localeibra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper{
    private static final String NAMA_DATABASE = "localeapp.db";
    private static final String NAMA_TABLE = "tborder";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "BRAND";
    private static final String COL_3 = "TYPE";
    private static final String COL_4 = "SEX";
    private static final String COL_5= "PRICE";
    private static final String COL_6 = "SIZE";

    public SQLiteHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAMA_TABLE + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT," +
                COL_3 + " TEXT," +
                COL_4 + " TEXT," +
                COL_5 + " TEXT," +
                COL_6 + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE);
    }

    public boolean insertData (String brand, String type,String sex,String price,String size){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, brand );
        values.put(COL_3, type );
        values.put(COL_4, sex );
        values.put(COL_5, price );
        values.put(COL_6, size );
        long result = db.insert(NAMA_TABLE,null, values);
        return result != -1;
    }

    public Cursor getDataAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + NAMA_TABLE, null );
    }

    public boolean updateData(String id, String brand, String type,String sex,String price,String size ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1, id );
        values.put(COL_2, brand );
        values.put(COL_3, type );
        values.put(COL_4, sex );
        values.put(COL_5, price );
        values.put(COL_6, size );

        db.update(NAMA_TABLE, values,COL_1+" = ? ",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(NAMA_TABLE, COL_1+" = ?",new String[]{id});
    }


}
