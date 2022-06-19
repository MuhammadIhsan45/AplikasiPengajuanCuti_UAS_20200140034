package rapticon.tk.apkuas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    //Membuat constructor database
    public Database(Context context)
    {
        super(context, "ProdiTI4", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table teman(id integer primary key, nama text,bidang text,mulai text, selesai text , keterangan text ,status text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists teman");
        onCreate(db);
    }

    public void insertData(HashMap<String, String> queryValues)
    {
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("bidang", queryValues.get("bidang"));
        nilai.put("mulai", queryValues.get("mulai"));
        nilai.put("selesai", queryValues.get("selesai"));
        nilai.put("keterangan", queryValues.get("keterangan"));
        nilai.put("status", queryValues.get("status"));
        basisdata.insert("teman", null, nilai);
        basisdata.close();
    }

    public void UpdateData(HashMap<String, String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("bidang", queryValues.get("bidang"));
        nilai.put("mulai", queryValues.get("mulai"));
        nilai.put("selesai", queryValues.get("selesai"));
        nilai.put("keterangan", queryValues.get("keterangan"));
        nilai.put("status", queryValues.get("status"));
        db.update("teman",nilai,"id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    public void DeleteData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("teman","id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getAllTeman()
    {
        ArrayList<HashMap<String, String>> daftarTeman;
        daftarTeman = new ArrayList<HashMap<String, String>>();
        String selectQuery = "Select * from teman";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst())
        {
            do
            {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("bidang", cursor.getString(2));
                map.put("mulai", cursor.getString(3));
                map.put("selesai", cursor.getString(4));
                map.put("keterangan", cursor.getString(5));
                map.put("status", cursor.getString(6));
                daftarTeman.add(map);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return daftarTeman;
    }
}