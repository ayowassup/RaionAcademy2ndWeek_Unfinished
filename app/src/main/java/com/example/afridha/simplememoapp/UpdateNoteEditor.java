package com.example.afridha.simplememoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.afridha.simplememoapp.Model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateNoteEditor extends AppCompatActivity {
    EditText etJudul, etIsi;
    String title, content, dateCreated, dateModified, mCurrentDate;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);

        etJudul = findViewById(R.id.etTitle);
        etIsi = findViewById(R.id.etContent);

        //Set currentDate
        mCurrentDate = getDate();

        //Get data from selected notes
        dateModified = mCurrentDate;

    }

    private void updateNote() {
        //Get data from EditText
        String currentTitle = etJudul.getText().toString();
        String currentContent = etIsi.getText().toString();


    }

    public String getDate() {
        return "";
    }

}
