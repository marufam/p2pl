package com.projek.p2pl.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by amien on 28/02/18.
 */

public class m_pelanggan extends RealmObject {
    @PrimaryKey
    private String id;

    private String id_pelanggan;

    private String nama;

    private String alamat;

    private String no_gardu;

    private String tarif;

    private String nama_penghuni;

    private String alamat_penghuni;

    private String noktp_penghuni;

    private String nama_saksi;

    private String alamat_saksi;

    private String nomor_identitas;

    private String pekerjaan_saksi;

    private String foto;

    private String status;

    private Double lat;

    private Double lng;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_gardu() {
        return no_gardu;
    }

    public void setNo_gardu(String no_gardu) {
        this.no_gardu = no_gardu;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getNama_penghuni() {
        return nama_penghuni;
    }

    public void setNama_penghuni(String nama_penghuni) {
        this.nama_penghuni = nama_penghuni;
    }

    public String getAlamat_penghuni() {
        return alamat_penghuni;
    }

    public void setAlamat_penghuni(String alamat_penghuni) {
        this.alamat_penghuni = alamat_penghuni;
    }

    public String getNoktp_penghuni() {
        return noktp_penghuni;
    }

    public void setNoktp_penghuni(String noktp_penghuni) {
        this.noktp_penghuni = noktp_penghuni;
    }

    public String getNama_saksi() {
        return nama_saksi;
    }

    public void setNama_saksi(String nama_saksi) {
        this.nama_saksi = nama_saksi;
    }

    public String getAlamat_saksi() {
        return alamat_saksi;
    }

    public void setAlamat_saksi(String alamat_saksi) {
        this.alamat_saksi = alamat_saksi;
    }

    public String getNomor_identitas() {
        return nomor_identitas;
    }

    public void setNomor_identitas(String nomor_identitas) {
        this.nomor_identitas = nomor_identitas;
    }

    public String getPekerjaan_saksi() {
        return pekerjaan_saksi;
    }

    public void setPekerjaan_saksi(String pekerjaan_saksi) {
        this.pekerjaan_saksi = pekerjaan_saksi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
