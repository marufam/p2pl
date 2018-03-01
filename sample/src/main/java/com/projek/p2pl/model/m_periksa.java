package com.projek.p2pl.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amien on 28/02/18.
 */

public class m_periksa extends RealmObject {

    @PrimaryKey
    private String id;

    private String kwh_meter_1a;

    private String merk_1a;

    private String tahun_1a;

    private String putaran_1a;

    private String kondisi_visual_1a;

    private String segel_terpasang_1b;

    private String jenis_1b;

    private String acuan_1b;

    private String tahun_1b;

    private String kondisi_visual_1b;

    private String kapasitas_2a;

    private String merk_2a;

    private String segel_terpasang_2b;

    private String jenis_2b;

    private String acuan_2b;

    private String tahun_2b;

    private String papan_meter_3a;

    private String jenis_3a;

    private String kondisi_visual_3a;

    private String segel_terpasang_3a;

    private String jenis_3a2;

    private String acuan_3a;

    private String tahun_3a;

    private String sesuai;

    private String hasil;

    private String pelanggaran;

    private String deskripsi_pelanggaran;

    private String tindakan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKwh_meter_1a() {
        return kwh_meter_1a;
    }

    public void setKwh_meter_1a(String kwh_meter_1a) {
        this.kwh_meter_1a = kwh_meter_1a;
    }

    public String getMerk_1a() {
        return merk_1a;
    }

    public void setMerk_1a(String merk_1a) {
        this.merk_1a = merk_1a;
    }

    public String getTahun_1a() {
        return tahun_1a;
    }

    public void setTahun_1a(String tahun_1a) {
        this.tahun_1a = tahun_1a;
    }

    public String getPutaran_1a() {
        return putaran_1a;
    }

    public void setPutaran_1a(String putaran_1a) {
        this.putaran_1a = putaran_1a;
    }

    public String getKondisi_visual_1a() {
        return kondisi_visual_1a;
    }

    public void setKondisi_visual_1a(String kondisi_visual_1a) {
        this.kondisi_visual_1a = kondisi_visual_1a;
    }

    public String getSegel_terpasang_1b() {
        return segel_terpasang_1b;
    }

    public void setSegel_terpasang_1b(String segel_terpasang_1b) {
        this.segel_terpasang_1b = segel_terpasang_1b;
    }

    public String getJenis_1b() {
        return jenis_1b;
    }

    public void setJenis_1b(String jenis_1b) {
        this.jenis_1b = jenis_1b;
    }

    public String getAcuan_1b() {
        return acuan_1b;
    }

    public void setAcuan_1b(String acuan_1b) {
        this.acuan_1b = acuan_1b;
    }

    public String getTahun_1b() {
        return tahun_1b;
    }

    public void setTahun_1b(String tahun_1b) {
        this.tahun_1b = tahun_1b;
    }

    public String getKondisi_visual_1b() {
        return kondisi_visual_1b;
    }

    public void setKondisi_visual_1b(String kondisi_visual_1b) {
        this.kondisi_visual_1b = kondisi_visual_1b;
    }

    public String getKapasitas_2a() {
        return kapasitas_2a;
    }

    public void setKapasitas_2a(String kapasitas_2a) {
        this.kapasitas_2a = kapasitas_2a;
    }

    public String getMerk_2a() {
        return merk_2a;
    }

    public void setMerk_2a(String merk_2a) {
        this.merk_2a = merk_2a;
    }

    public String getSegel_terpasang_2b() {
        return segel_terpasang_2b;
    }

    public void setSegel_terpasang_2b(String segel_terpasang_2b) {
        this.segel_terpasang_2b = segel_terpasang_2b;
    }

    public String getJenis_2b() {
        return jenis_2b;
    }

    public void setJenis_2b(String jenis_2b) {
        this.jenis_2b = jenis_2b;
    }

    public String getAcuan_2b() {
        return acuan_2b;
    }

    public void setAcuan_2b(String acuan_2b) {
        this.acuan_2b = acuan_2b;
    }

    public String getTahun_2b() {
        return tahun_2b;
    }

    public void setTahun_2b(String tahun_2b) {
        this.tahun_2b = tahun_2b;
    }

    public String getPapan_meter_3a() {
        return papan_meter_3a;
    }

    public void setPapan_meter_3a(String papan_meter_3a) {
        this.papan_meter_3a = papan_meter_3a;
    }

    public String getJenis_3a() {
        return jenis_3a;
    }

    public void setJenis_3a(String jenis_3a) {
        this.jenis_3a = jenis_3a;
    }

    public String getKondisi_visual_3a() {
        return kondisi_visual_3a;
    }

    public void setKondisi_visual_3a(String kondisi_visual_3a) {
        this.kondisi_visual_3a = kondisi_visual_3a;
    }

    public String getSegel_terpasang_3a() {
        return segel_terpasang_3a;
    }

    public void setSegel_terpasang_3a(String segel_terpasang_3a) {
        this.segel_terpasang_3a = segel_terpasang_3a;
    }

    public String getJenis_3a2() {
        return jenis_3a2;
    }

    public void setJenis_3a2(String jenis_3a2) {
        this.jenis_3a2 = jenis_3a2;
    }

    public String getAcuan_3a() {
        return acuan_3a;
    }

    public void setAcuan_3a(String acuan_3a) {
        this.acuan_3a = acuan_3a;
    }

    public String getTahun_3a() {
        return tahun_3a;
    }

    public void setTahun_3a(String tahun_3a) {
        this.tahun_3a = tahun_3a;
    }

    public String getSesuai() {
        return sesuai;
    }

    public void setSesuai(String sesuai) {
        this.sesuai = sesuai;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getPelanggaran() {
        return pelanggaran;
    }

    public void setPelanggaran(String pelanggaran) {
        this.pelanggaran = pelanggaran;
    }

    public String getDeskripsi_pelanggaran() {
        return deskripsi_pelanggaran;
    }

    public void setDeskripsi_pelanggaran(String deskripsi_pelanggaran) {
        this.deskripsi_pelanggaran = deskripsi_pelanggaran;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }
}
