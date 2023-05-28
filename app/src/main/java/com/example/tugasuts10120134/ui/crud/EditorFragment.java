package com.example.tugasuts10120134.ui.crud;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tugasuts10120134.R;
import com.example.tugasuts10120134.helper.Helper;


public class EditorFragment extends Fragment {

    private EditText editJudul, editKategori, editIsi;
    private Button btnSave;
    private Helper db = new Helper(requireContext());
    private String id, judul, tanggal, kategori, isi;

    public EditorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_editor, container, false);

        editJudul = view.findViewById(R.id.text_judul);
        editKategori = view.findViewById(R.id.text_kategori);
        editIsi = view.findViewById(R.id.text_isi);


        return view;
    }
}