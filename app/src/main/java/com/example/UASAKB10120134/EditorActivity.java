package com.example.UASAKB10120134;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.UASAKB10120134.helper.Helper;

public class EditorActivity extends AppCompatActivity {

    private EditText editJudul, editKategori, editIsi;
    private Button btnSave, Btnback;
    private Helper db = new Helper(this);
    private String id, judul, tanggal, kategori, isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        //setContentView(R.layout);

        btnSave = findViewById(R.id.btn_save);
        Btnback = findViewById(R.id.btn_back);

        editJudul = findViewById(R.id.edit_judul);
        editKategori = findViewById(R.id.edit_kategori);
        editIsi = findViewById(R.id.edit_isi);

        id = getIntent().getStringExtra("id");
        judul = getIntent().getStringExtra("judul");
        kategori = getIntent().getStringExtra("kategori");
        isi= getIntent().getStringExtra("isi");

        if (id == null || id.equals(""))
        {
            setTitle("Tambah Catatan");
        }
        else
        {
            setTitle("Edit Catatan");
            editJudul.setText(judul);
            editKategori.setText(kategori);
            editIsi.setText(isi);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (id == null || id.equals(""))
                    {
                        save();
                    }
                    else
                    {
                        edit();
                    }
                } catch (Exception e) {
                    Log.e("Saving", e.getMessage());
                }
            }
        });

        Btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void save()
    {
        if (String.valueOf(editJudul.getText()).equals("") || String.valueOf(editKategori.getText()).equals("") || String.valueOf(editIsi.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        } else {
            db.insert(editJudul.getText().toString(), editKategori.getText().toString(), editIsi.getText().toString());
            finish();
        }
    }

    private void edit()
    {
        if (String.valueOf(editJudul.getText()).equals("") || String.valueOf(editKategori.getText()).equals("") || String.valueOf(editIsi.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        } else {
            db.update(Integer.parseInt(id), editJudul.getText().toString(), editKategori.getText().toString(), editIsi.getText().toString());
            finish();
        }
    }
}