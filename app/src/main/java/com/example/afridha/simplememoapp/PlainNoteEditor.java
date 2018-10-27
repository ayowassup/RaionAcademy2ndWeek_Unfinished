package com.example.afridha.simplememoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afridha.simplememoapp.Model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PlainNoteEditor extends AppCompatActivity {
    EditText etJudul, etIsi;
    String title, content, dateCreated, dateModified, mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);

        etJudul = findViewById(R.id.etTitle);
        etIsi = findViewById(R.id.etContent);

        //Set currentDate
        mCurrentDate = getDate();
    }

    private void saveNote() {
        //Get data from EditText
        String title = etJudul.getText().toString();
        String content = etIsi.getText().toString();

        //Set dateCreated and dateModified value
        dateCreated = mCurrentDate;
        dateModified = dateCreated;

    }


    public String getDate() {
        return "";
    }
}
