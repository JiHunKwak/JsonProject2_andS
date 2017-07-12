package com.example.kwakgee.accountinrollment.DBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kwakgee.accountinrollment.Contants.Acc_Constants;

/**
 * Created by kwakgee on 2017. 7. 11..
 */

public class Acc_DBManager extends SQLiteOpenHelper {

    public Acc_DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE Account(ID TEXT, Password TEXT, Name TEXT, PhoneNumber TEXT, Email TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public void delete(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public boolean isEmpty() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM Account", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count > 0) return false;
        else return true;
    }

    public String currentName;

    public boolean isMatch(String id, String pw) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Account", null);
        while (cursor.moveToNext()) {
            if (id.equals(cursor.getString(Acc_Constants.INDEX_OF_ID))) {
                if (pw.equals(cursor.getString(Acc_Constants.INDEX_OF_PW))) {
                    currentName = cursor.getString(Acc_Constants.INDEX_OF_NM);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOverlap(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Account", null);
        if(!isEmpty())
        while (cursor.moveToNext()) {
            if (id.equals(cursor.getString(Acc_Constants.INDEX_OF_ID))) return true;
            else return false;
        }
        return false;
    }



//    public void loadData(){
//        SQLiteDatabase db = getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM Account", null);
//        cursor.moveToFirst();
//        if(cursor.getInt(0) != 0){
//            while(cursor.moveToNext()) {
//                String id = cursor.getString(Acc_Constants.INDEX_OF_ID);
//                String pw = cursor.getString(Acc_Constants.INDEX_OF_PW);
//                String name = cursor.getString(Acc_Constants.INDEX_OF_NM);
//                String phone = cursor.getString(Acc_Constants.INDEX_OF_PN);
//                String email = cursor.getString(Acc_Constants.INDEX_OF_EM);
//                Bitmap image = null;
//                Acc_BaseActivity.accArray.add(new Acc_Account(id, pw, name, phone, email, image));
//            }
//        }
//    }

//    public void saveData(){
//        SQLiteDatabase db = getWritableDatabase();
//        for(int i=0; i< Acc_BaseActivity.accArray.size(); i++){
//            String id = Acc_BaseActivity.accArray.get(i).getId();
//            String pw = Acc_BaseActivity.accArray.get(i).getPassword();
//            String name = Acc_BaseActivity.accArray.get(i).getName();
//            String phone = Acc_BaseActivity.accArray.get(i).getPhone();
//            String email = Acc_BaseActivity.accArray.get(i).getEmail();
//            db.execSQL("INSERT INTO Account VALUES('" + name + "', '" + id + "', '" + pw + "', '" + phone + "', '" + email + "');");
//            db.close();
//        }
//    }


}
