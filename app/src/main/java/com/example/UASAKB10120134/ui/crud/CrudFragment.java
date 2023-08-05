package com.example.UASAKB10120134.ui.crud;

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
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.UASAKB10120134.EditorActivity;
import com.example.UASAKB10120134.MenuUtamaActivity;
import com.example.UASAKB10120134.R;
import com.example.UASAKB10120134.TambahActivity;
import com.example.UASAKB10120134.adapter.AdapterCatatan;
import com.example.UASAKB10120134.adapter.NoteAdapter;
import com.example.UASAKB10120134.helper.Helper;
import com.example.UASAKB10120134.model.ModelCatatan;
import com.example.UASAKB10120134.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    FloatingActionButton tambah;
    AdapterCatatan adapterCatatan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelCatatan> listCatatan;
    RecyclerView tv_tampil;

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

        tambah = view.findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), TambahActivity.class));
        });
        tv_tampil = view.findViewById(R.id.tv_tampil);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (getContext());
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager (getActivity());
        tv_tampil.setLayoutManager(mLayout);
        tv_tampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();

        // Inflate the layout for this fragment
        return view;
    }

    private void tampilData() {
        database.child("Catatan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCatatan = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren())
                {
                    ModelCatatan mhs = item.getValue(ModelCatatan.class);
                    mhs.setKey(item.getKey());
                    listCatatan.add(mhs);
                }

                //adapterMahasiswa = new AdapterCatatan(listCatatan, EditorActivity.this);
                adapterCatatan = new AdapterCatatan(listCatatan, getActivity());
                tv_tampil.setAdapter(adapterCatatan);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //listCatatan.clear();
        //tampilData();
        //adapterCatatan.notifyDataSetChanged();
    }
}