package com.example.tugasuts10120134.ui.home;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("SELAMAT DATANG DI MENU UTAMA KLIK ICON KIRI TATAS UNTUK MELIHAT OPSI");
    }

    public LiveData<String> getText() {
        return mText;
    }
}