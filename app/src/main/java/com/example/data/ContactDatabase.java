package com.example.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ContactDatabase extends SQLiteOpenHelper {
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "contactmanagement";

    public ContactDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE contact(_id INTEGER, name TEXT PRIMARY KEY, phone TEXT, email TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }

    public void createContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("phone", contact.getPhone());
        content.put("name",contact.getName());
        content.put("email", contact.getEmail());

        db.insert("contact", null, content);
        db.close();
    }

    public void deleteContact(String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("contact", "phone=?", new String[] {phone});
        db.close();
    }

    public void updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("phone", contact.getPhone());
        content.put("name",contact.getName());
        content.put("email", contact.getEmail());

        db.update("contact", content, "phone=?", new String[] {contact.getPhone()});
        db.close();
    }

    public Cursor listContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM contact", new String[]{});

    }
}
