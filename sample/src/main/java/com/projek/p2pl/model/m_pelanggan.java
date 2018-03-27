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
    private String trafo;
    private String tarif;
    private String peruntukan;
    private String nama_penghuni;
    private String alamat_penghuni;
    private String nomor_identitas;
    private String pekerjaan_penghuni;
    private String terdaftar; // true false
    private String nama_saksi1;
    private String noktp_saksi1;
    private String nama_saksi2;
    private String noktp_saksi2;
    private String foto;
    private String status;
    private Double lat;
    private Double lng;

    public String getTrafo() {
        return trafo;
    }

    public void setTrafo(String trafo) {
        this.trafo = trafo;
    }

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

    public String getNomor_identitas() {
        return nomor_identitas;
    }

    public void setNomor_identitas(String nomor_identitas) {
        this.nomor_identitas = nomor_identitas;
    }

    public String getPekerjaan_penghuni() {
        return pekerjaan_penghuni;
    }

    public void setPekerjaan_penghuni(String pekerjaan_penghuni) {
        this.pekerjaan_penghuni = pekerjaan_penghuni;
    }

    public String getNama_saksi1() {
        return nama_saksi1;
    }

    public void setNama_saksi1(String nama_saksi1) {
        this.nama_saksi1 = nama_saksi1;
    }

    public String getNoktp_saksi1() {
        return noktp_saksi1;
    }

    public void setNoktp_saksi1(String noktp_saksi1) {
        this.noktp_saksi1 = noktp_saksi1;
    }

    public String getNama_saksi2() {
        return nama_saksi2;
    }

    public void setNama_saksi2(String nama_saksi2) {
        this.nama_saksi2 = nama_saksi2;
    }

    public String getNoktp_saksi2() {
        return noktp_saksi2;
    }

    public void setNoktp_saksi2(String noktp_saksi2) {
        this.noktp_saksi2 = noktp_saksi2;
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

    public String getTerdaftar() {
        return terdaftar;
    }

    public void setTerdaftar(String terdaftar) {
        this.terdaftar = terdaftar;
    }

    public String getPeruntukan() {
        return peruntukan;
    }

    public void setPeruntukan(String peruntukan) {
        this.peruntukan = peruntukan;
    }
}
