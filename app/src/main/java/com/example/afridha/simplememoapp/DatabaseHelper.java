package com.example.afridha.simplememoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.afridha.simplememoapp.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SimpleNote.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "DataHelper";
    private static final String TABLE_NAME = "Notes";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String DATE_CREATED = "created";
    private static final String DATE_MODIFIED = "modified";
    private static final String[] COL_ALL = new String[]{ID, TITLE, CONTENT, DATE_CREATED, DATE_MODIFIED};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_NOTES = "CREATE TABLE " + TABLE_NAME + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", "
                + TITLE + " TEXT NOT NULL" + ", "
                + CONTENT + " TEXT NOT NULL" + ", "
                + DATE_CREATED + " TEXT NOT NULL" + ", "
                + DATE_MODIFIED + " TEXT NOT NULL"
                + ")";
        Log.d(TAG, CREATE_TABLE_NOTES);
        db.execSQL(CREATE_TABLE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        Log.d(TAG, DROP_TABLE);
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, note.getTitle());
        values.put(CONTENT, note.getContent());
        values.put(DATE_CREATED, note.getDateCreated());
        values.put(DATE_MODIFIED, note.getDateModified());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Note> getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Note> noteList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, COL_ALL, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                note.setDateCreated(cursor.getString(3));
                note.setDateModified(cursor.getString(4));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return noteList;
    }

    public void deleteNote(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = '" + id + "'", new String[]{});
        db.close();
    }

    public void editNote(Note note, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, note.getTitle());
        values.put(CONTENT, note.getContent());
        values.put(DATE_MODIFIED, note.getDateModified());
        db.update(TABLE_NAME, values, ID + " =?", new String[]{String.valueOf(id)});
        db.close();
    }
}