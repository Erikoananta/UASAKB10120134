package com.example.UASAKB10120134.viewpager;

/*
Nama    : Eriko Ananta
NIM     : 10120134
Kelas   : IF-4
Matkul  : Aplikasi Komputer Bergerak
*/

import com.example.UASAKB10120134.R;

public enum ModelObject {

    PERKENALAN1(R.string.judul_1, R.layout.view_perkenalan1),
    PERKENALAN2(R.string.judul_2, R.layout.view_perkenalan2);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
