package com.example.tugasuts10120134.ui.crud;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.tugasuts10120134.EditorActivity;
import com.example.tugasuts10120134.R;
import com.example.tugasuts10120134.adapter.NoteAdapter;
import com.example.tugasuts10120134.helper.Helper;
import com.example.tugasuts10120134.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrudFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrudFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Core
    ListView listView;
    AlertDialog.Builder dialog;
    List<Note> lists = new ArrayList<>();
    NoteAdapter adapter;
    //Helper db = new Helper(this);
    Helper db;
    Button btnAdd;

    public CrudFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrudFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrudFragment newInstance(String param1, String param2) {
        CrudFragment fragment = new CrudFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crud, container, false);
        listView = view.findViewById(R.id.list_item);
        adapter = new NoteAdapter(getActivity(), lists);
        listView.setAdapter(adapter);

        //db = new Helper(requireContext());
        db = new Helper(getActivity());
        btnAdd = view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditorActivity.class);
            startActivity(intent);
        });

        listView.setOnItemLongClickListener((adapterView, v, i, l) -> {
            final String id = lists.get(i).getId();
            final String  judul = lists.get(i).getJudul();
            final String  tanggal = lists.get(i).getTanggal();
            final String  kategori = lists.get(i).getKategori();
            final String  isi = lists.get(i).getIsi();

            final CharSequence[] dialogItem = {"edit", "Hapus"};
            dialog = new AlertDialog.Builder(getActivity());
            dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0:
                            Intent intent = new Intent(getActivity(), EditorActivity.class);
                            intent.putExtra("id", id);
                            intent.putExtra("judul", judul);
                            intent.putExtra("tanggal", tanggal);
                            intent.putExtra("kategori", kategori);
                            intent.putExtra("isi", isi);
                            startActivity(intent);
                            break;
                        case 1:
                            db.delete(Integer.parseInt(id));
                            lists.clear();
                            // Panggil Data Ulang
                            getData();
                            break;
                    }
                }
            }).show();
            return false;
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void getData()
    {
        ArrayList<HashMap<String,String>> rows = db.getAll();
        for (int i = 0; i < rows.size(); i++)
        {
            String id = rows.get(i).get("id");
            String judul = rows.get(i).get("judul");
            String tanggal = rows.get(i).get("tanggal");
            String kategori = rows.get(i).get("kategori");
            String isi = rows.get(i).get("isi");



            Note data = new Note();
            data.setId(id);
            data.setJudul(judul);
            data.setTanggal(tanggal);
            data.setKategori(kategori);
            data.setIsi(isi);
            lists.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        lists.clear();
        getData();
        adapter.notifyDataSetChanged();
    }
}