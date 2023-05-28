package com.example.tugasuts10120134.model;

public class Kegiatan {
    private int id;
    private String judul;
    private String tanggal;
    private String kategori;
    private String isi;

    public Kegiatan() {
    }

    public Kegiatan(String judul, String tanggal, String kategori, String isi) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.isi = isi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}