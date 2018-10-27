package com.example.afridha.simplememoapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afridha.simplememoapp.DatabaseHelper;
import com.example.afridha.simplememoapp.Model.Note;
import com.example.afridha.simplememoapp.R;
import com.example.afridha.simplememoapp.UpdateNoteEditor;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NotesViewHolder> {

    public static class NotesViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvDate;
        public CardView cvNotes;
        public ImageView delete, edit;

        public NotesViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvDate = itemView.findViewById(R.id.tvNoteDate);
            delete = itemView.findViewById(R.id.deleteButton);
            cvNotes = itemView.findViewById(R.id.cardNote);
            edit = itemView.findViewById(R.id.editButton);
        }
    }

    public NoteListAdapter(Context context, List<Note> noteList) {

    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}