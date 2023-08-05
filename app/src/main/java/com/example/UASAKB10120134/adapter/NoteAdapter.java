package com.example.UASAKB10120134.adapter;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.UASAKB10120134.R;
import com.example.UASAKB10120134.model.Note;

import java.util.List;

public class NoteAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    List<Note> lists;

    public NoteAdapter(Activity activity, List<Note> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists != null ? lists.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
        {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater != null)
        {
            //view = inflater.inflate(R.layout.list_users, null);
            view = inflater.inflate(R.layout.list_note, null);
        }
        if (view != null)
        {
            TextView judul = view.findViewById(R.id.text_judul);
            TextView tanggal = view.findViewById(R.id.text_tanggal);
            TextView kategori = view.findViewById(R.id.text_kategori);
            TextView isi = view.findViewById(R.id.text_isi);
            Note note = lists.get(i);
            judul.setText(note.getJudul());
            tanggal.setText(note.getTanggal());
            kategori.setText(note.getKategori());
            isi.setText(note.getIsi());

            //TextView name = view.findViewById(R.id.text_name);
            //TextView email = view.findViewById(R.id.text_email);
            //Data data = lists.get(i);
            //name.setText(data.getName());
            //email.setText(data.getEmail());
        }

        return view;
    }
}
