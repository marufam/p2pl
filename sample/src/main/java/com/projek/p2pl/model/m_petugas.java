package com.projek.p2pl.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amien on 28/02/18.
 */

public class m_petugas extends RealmObject {

    @PrimaryKey
    private String id;

    private String nomorsurat;

    private String tanggalsurat;

    private String nama;

    private String noinduk;

    private String jabatan;

    private String rayon;

    private String alamat;

    private String cabang;

    private String wilayah;

    private String nama_vendor;

    private String noinduk_vendor;

    private String jabatan_vendor;

    private String nomor_surat_porli;

    private String tanggal;

    private String petugas1;

    private String petugas2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomorsurat() {
        return nomorsurat;
    }

    public String getTanggalsurat() {
        return tanggalsurat;
    }

    public void setTanggalsurat(String tanggalsurat) {
        this.tanggalsurat = tanggalsurat;
    }

    public void setNomorsurat(String nomorsurat) {
        this.nomorsurat = nomorsurat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoinduk() {
        return noinduk;
    }

    public void setNoinduk(String noinduk) {
        this.noinduk = noinduk;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getNama_vendor() {
        return nama_vendor;
    }

    public void setNama_vendor(String nama_vendor) {
        this.nama_vendor = nama_vendor;
    }

    public String getNoinduk_vendor() {
        return noinduk_vendor;
    }

    public void setNoinduk_vendor(String noinduk_vendor) {
        this.noinduk_vendor = noinduk_vendor;
    }

    public String getJabatan_vendor() {
        return jabatan_vendor;
    }

    public void setJabatan_vendor(String jabatan_vendor) {
        this.jabatan_vendor = jabatan_vendor;
    }

    public String getNomor_surat_porli() {
        return nomor_surat_porli;
    }

    public void setNomor_surat_porli(String nomor_surat_porli) {
        this.nomor_surat_porli = nomor_surat_porli;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPetugas1() {
        return petugas1;
    }

    public void setPetugas1(String petugas1) {
        this.petugas1 = petugas1;
    }

    public String getPetugas2() {
        return petugas2;
    }

    public void setPetugas2(String petugas2) {
        this.petugas2 = petugas2;
    }
}
