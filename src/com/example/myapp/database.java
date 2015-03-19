package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sam on 3/2/2015.
 */
public class database {
    public static final String MYDATABASE_NAME = "MY_DATABASE";
    public static final int MYDATABASE_VERSION = 1;

//SAM IS A BUTT
    public static final String MYDATABASE_TABLE = "ST";
    public static final String KEY_ID = "_id";
    public static final String Z = "Z";
    public static final String Y = "Y";
    public static final String X = "X";



    //create table MY_DATABASE (ID integer primary key, Content text not null);
    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + MYDATABASE_TABLE + " ("
                    + KEY_ID + " integer primary key autoincrement, "
                    + Z+ " text not null, "
                    + Y + " text not null,"
                    + X+ " text not null);";


    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public database(Context c){
        context = c;
    }

    public database openToRead() throws android.database.SQLException {

        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public database openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        sqLiteHelper.close();
    }

    public long insert(String sid, String sname,String sroll){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Z, sid);
        contentValues.put(Y,sname);
        contentValues.put(X,sroll);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);

    }

    //public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
    public long update(String sid, String sname,String sroll,int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Z, sid);
        contentValues.put(Y,sname);
        contentValues.put(X,sroll);
        System.out.println(id);

        return sqLiteDatabase.update(MYDATABASE_TABLE, contentValues, KEY_ID+"="+id, null);
    }

    public int deleteAll(){
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    public void delete_byID(int id){
        sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_ID+"="+id, null);
    }

    public Cursor queueAll(){
        String[] columns = new String[]{KEY_ID, Z,Y,X};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                null, null, null, null, null);

        return cursor;
    }
    public Cursor queueAll2(int id){

        String a="SELECT * FROM ST WHERE _id = "+id;

        Cursor cursor=sqLiteDatabase.rawQuery(a, null);

        return cursor;
    }
    public Cursor queueAll3(int id){
        //String[] columns = new String[]{KEY_ID, Z,Y,X};
        String a="SELECT * FROM MT,ST WHERE _id = "+id;
        //Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
        // null, null, null, null, null);
        Cursor cursor=sqLiteDatabase.rawQuery(a, null);

        return cursor;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_DATABASE);

        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }

}

