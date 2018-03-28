package com.projek.p2pl.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amien on 06/03/18.
 */

public class m_barangbukti extends RealmObject {
    @PrimaryKey
    private String id;
    private String typeBbKwh;
    private String merkBbKwh;
    private String taripBbKwh;
    private String nopabrikBbKwh;
    private String tahunBbKwh; //
    private String faktormeterBbKwh;
    private String ukuranxBbKwh;
    private String ukuranyBbKwh;
    private String ampereBbKwh;
    private String standBbKWh;

    private String typeBbKvarh;
    private String merkBbKvarh;
    private String taripBbKvarh;
    private String nopabrikBbKvarh;
    private String tahunBbKvarh; //
    private String faktormeterBbKvarh;
    private String ukuranxBbKvarh;
    private String ukuranyBbKvarh;
    private String ampereBbKvarh;
    private String standBbKvarh;

    private String typeBbKva;
    private String merkBbKva;
    private String taripBbKva;
    private String nopabrikBbKva;
    private String tahunBbKva; //
    private String faktormeterBbKva;
    private String ukuranxBbKva;
    private String ukuranyBbKva;
    private String ampereBbKva;

    private String namaBbPembatas;
    private String tipeukuranBbPembatas;
    private String ukuranxBbPembatas;
    private String ukuranyBbPembatas;

    private String typeBbTrafo;
    private String merkBbTrafo;
    private String nopabrikBbTrafo;
    private String ratioBbTrafo;

    private String jeniskabelBbKabel;
    private String diameterxBbKabel;
    private String diameteryBbKabel;
    private String panjangBbKabel;

    private String typeBbKontaktor;
    private String merkBbKontaktor;
    private String nopabrikBbKontaktor;
    private String tahunBbKontaktor;
    private String fasaBbTrafo;

    private String jenisBbFuse;
    private String typeBbFuse;
    private String merkBbFuse;
    private String nopabrikBbFuse;
    private String tahunBbFuse;

    private String ukuranBbGembok;

    private String garduBb;
    private String kotakappBb;
    private String pengukurBb;
    private String pembatasBb;
    private String bantupengukuranBb;
    private String pelindungBb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeBbKwh() {
        return typeBbKwh;
    }

    public void setTypeBbKwh(String typeBbKwh) {
        this.typeBbKwh = typeBbKwh;
    }

    public String getMerkBbKwh() {
        return merkBbKwh;
    }

    public void setMerkBbKwh(String merkBbKwh) {
        this.merkBbKwh = merkBbKwh;
    }

    public String getTaripBbKwh() {
        return taripBbKwh;
    }

    public void setTaripBbKwh(String taripBbKwh) {
        this.taripBbKwh = taripBbKwh;
    }

    public String getNopabrikBbKwh() {
        return nopabrikBbKwh;
    }

    public void setNopabrikBbKwh(String nopabrikBbKwh) {
        this.nopabrikBbKwh = nopabrikBbKwh;
    }

    public String getTahunBbKwh() {
        return tahunBbKwh;
    }

    public void setTahunBbKwh(String tahunBbKwh) {
        this.tahunBbKwh = tahunBbKwh;
    }

    public String getFaktormeterBbKwh() {
        return faktormeterBbKwh;
    }

    public void setFaktormeterBbKwh(String faktormeterBbKwh) {
        this.faktormeterBbKwh = faktormeterBbKwh;
    }

    public String getUkuranxBbKwh() {
        return ukuranxBbKwh;
    }

    public void setUkuranxBbKwh(String ukuranxBbKwh) {
        this.ukuranxBbKwh = ukuranxBbKwh;
    }

    public String getUkuranyBbKwh() {
        return ukuranyBbKwh;
    }

    public void setUkuranyBbKwh(String ukuranyBbKwh) {
        this.ukuranyBbKwh = ukuranyBbKwh;
    }

    public String getAmpereBbKwh() {
        return ampereBbKwh;
    }

    public void setAmpereBbKwh(String ampereBbKwh) {
        this.ampereBbKwh = ampereBbKwh;
    }

    public String getStandBbKWh() {
        return standBbKWh;
    }

    public void setStandBbKWh(String standBbKWh) {
        this.standBbKWh = standBbKWh;
    }

    public String getTypeBbKvarh() {
        return typeBbKvarh;
    }

    public void setTypeBbKvarh(String typeBbKvarh) {
        this.typeBbKvarh = typeBbKvarh;
    }

    public String getMerkBbKvarh() {
        return merkBbKvarh;
    }

    public void setMerkBbKvarh(String merkBbKvarh) {
        this.merkBbKvarh = merkBbKvarh;
    }

    public String getTaripBbKvarh() {
        return taripBbKvarh;
    }

    public void setTaripBbKvarh(String taripBbKvarh) {
        this.taripBbKvarh = taripBbKvarh;
    }

    public String getNopabrikBbKvarh() {
        return nopabrikBbKvarh;
    }

    public void setNopabrikBbKvarh(String nopabrikBbKvarh) {
        this.nopabrikBbKvarh = nopabrikBbKvarh;
    }

    public String getTahunBbKvarh() {
        return tahunBbKvarh;
    }

    public void setTahunBbKvarh(String tahunBbKvarh) {
        this.tahunBbKvarh = tahunBbKvarh;
    }

    public String getFaktormeterBbKvarh() {
        return faktormeterBbKvarh;
    }

    public void setFaktormeterBbKvarh(String faktormeterBbKvarh) {
        this.faktormeterBbKvarh = faktormeterBbKvarh;
    }

    public String getUkuranxBbKvarh() {
        return ukuranxBbKvarh;
    }

    public void setUkuranxBbKvarh(String ukuranxBbKvarh) {
        this.ukuranxBbKvarh = ukuranxBbKvarh;
    }

    public String getUkuranyBbKvarh() {
        return ukuranyBbKvarh;
    }

    public void setUkuranyBbKvarh(String ukuranyBbKvarh) {
        this.ukuranyBbKvarh = ukuranyBbKvarh;
    }

    public String getAmpereBbKvarh() {
        return ampereBbKvarh;
    }

    public void setAmpereBbKvarh(String ampereBbKvarh) {
        this.ampereBbKvarh = ampereBbKvarh;
    }

    public String getStandBbKvarh() {
        return standBbKvarh;
    }

    public void setStandBbKvarh(String standBbKvarh) {
        this.standBbKvarh = standBbKvarh;
    }

    public String getTypeBbKva() {
        return typeBbKva;
    }

    public void setTypeBbKva(String typeBbKva) {
        this.typeBbKva = typeBbKva;
    }

    public String getMerkBbKva() {
        return merkBbKva;
    }

    public void setMerkBbKva(String merkBbKva) {
        this.merkBbKva = merkBbKva;
    }

    public String getTaripBbKva() {
        return taripBbKva;
    }

    public void setTaripBbKva(String taripBbKva) {
        this.taripBbKva = taripBbKva;
    }

    public String getNopabrikBbKva() {
        return nopabrikBbKva;
    }

    public void setNopabrikBbKva(String nopabrikBbKva) {
        this.nopabrikBbKva = nopabrikBbKva;
    }

    public String getTahunBbKva() {
        return tahunBbKva;
    }

    public void setTahunBbKva(String tahunBbKva) {
        this.tahunBbKva = tahunBbKva;
    }

    public String getFaktormeterBbKva() {
        return faktormeterBbKva;
    }

    public void setFaktormeterBbKva(String faktormeterBbKva) {
        this.faktormeterBbKva = faktormeterBbKva;
    }

    public String getUkuranxBbKva() {
        return ukuranxBbKva;
    }

    public void setUkuranxBbKva(String ukuranxBbKva) {
        this.ukuranxBbKva = ukuranxBbKva;
    }

    public String getUkuranyBbKva() {
        return ukuranyBbKva;
    }

    public void setUkuranyBbKva(String ukuranyBbKva) {
        this.ukuranyBbKva = ukuranyBbKva;
    }

    public String getAmpereBbKva() {
        return ampereBbKva;
    }

    public void setAmpereBbKva(String ampereBbKva) {
        this.ampereBbKva = ampereBbKva;
    }

    public String getNamaBbPembatas() {
        return namaBbPembatas;
    }

    public void setNamaBbPembatas(String namaBbPembatas) {
        this.namaBbPembatas = namaBbPembatas;
    }

    public String getTipeukuranBbPembatas() {
        return tipeukuranBbPembatas;
    }

    public void setTipeukuranBbPembatas(String tipeukuranBbPembatas) {
        this.tipeukuranBbPembatas = tipeukuranBbPembatas;
    }

    public String getUkuranxBbPembatas() {
        return ukuranxBbPembatas;
    }

    public void setUkuranxBbPembatas(String ukuranxBbPembatas) {
        this.ukuranxBbPembatas = ukuranxBbPembatas;
    }

    public String getUkuranyBbPembatas() {
        return ukuranyBbPembatas;
    }

    public void setUkuranyBbPembatas(String ukuranyBbPembatas) {
        this.ukuranyBbPembatas = ukuranyBbPembatas;
    }

    public String getTypeBbTrafo() {
        return typeBbTrafo;
    }

    public void setTypeBbTrafo(String typeBbTrafo) {
        this.typeBbTrafo = typeBbTrafo;
    }

    public String getMerkBbTrafo() {
        return merkBbTrafo;
    }

    public void setMerkBbTrafo(String merkBbTrafo) {
        this.merkBbTrafo = merkBbTrafo;
    }

    public String getNopabrikBbTrafo() {
        return nopabrikBbTrafo;
    }

    public void setNopabrikBbTrafo(String nopabrikBbTrafo) {
        this.nopabrikBbTrafo = nopabrikBbTrafo;
    }

    public String getRatioBbTrafo() {
        return ratioBbTrafo;
    }

    public void setRatioBbTrafo(String ratioBbTrafo) {
        this.ratioBbTrafo = ratioBbTrafo;
    }

    public String getJeniskabelBbKabel() {
        return jeniskabelBbKabel;
    }

    public void setJeniskabelBbKabel(String jeniskabelBbKabel) {
        this.jeniskabelBbKabel = jeniskabelBbKabel;
    }

    public String getDiameterxBbKabel() {
        return diameterxBbKabel;
    }

    public void setDiameterxBbKabel(String diameterxBbKabel) {
        this.diameterxBbKabel = diameterxBbKabel;
    }

    public String getDiameteryBbKabel() {
        return diameteryBbKabel;
    }

    public void setDiameteryBbKabel(String diameteryBbKabel) {
        this.diameteryBbKabel = diameteryBbKabel;
    }

    public String getPanjangBbKabel() {
        return panjangBbKabel;
    }

    public void setPanjangBbKabel(String panjangBbKabel) {
        this.panjangBbKabel = panjangBbKabel;
    }

    public String getTypeBbKontaktor() {
        return typeBbKontaktor;
    }

    public void setTypeBbKontaktor(String typeBbKontaktor) {
        this.typeBbKontaktor = typeBbKontaktor;
    }

    public String getMerkBbKontaktor() {
        return merkBbKontaktor;
    }

    public void setMerkBbKontaktor(String merkBbKontaktor) {
        this.merkBbKontaktor = merkBbKontaktor;
    }

    public String getNopabrikBbKontaktor() {
        return nopabrikBbKontaktor;
    }

    public void setNopabrikBbKontaktor(String nopabrikBbKontaktor) {
        this.nopabrikBbKontaktor = nopabrikBbKontaktor;
    }

    public String getTahunBbKontaktor() {
        return tahunBbKontaktor;
    }

    public void setTahunBbKontaktor(String tahunBbKontaktor) {
        this.tahunBbKontaktor = tahunBbKontaktor;
    }

    public String getFasaBbTrafo() {
        return fasaBbTrafo;
    }

    public void setFasaBbTrafo(String fasaBbTrafo) {
        this.fasaBbTrafo = fasaBbTrafo;
    }

    public String getJenisBbFuse() {
        return jenisBbFuse;
    }

    public void setJenisBbFuse(String jenisBbFuse) {
        this.jenisBbFuse = jenisBbFuse;
    }

    public String getTypeBbFuse() {
        return typeBbFuse;
    }

    public void setTypeBbFuse(String typeBbFuse) {
        this.typeBbFuse = typeBbFuse;
    }

    public String getMerkBbFuse() {
        return merkBbFuse;
    }

    public void setMerkBbFuse(String merkBbFuse) {
        this.merkBbFuse = merkBbFuse;
    }

    public String getNopabrikBbFuse() {
        return nopabrikBbFuse;
    }

    public void setNopabrikBbFuse(String nopabrikBbFuse) {
        this.nopabrikBbFuse = nopabrikBbFuse;
    }

    public String getTahunBbFuse() {
        return tahunBbFuse;
    }

    public void setTahunBbFuse(String tahunBbFuse) {
        this.tahunBbFuse = tahunBbFuse;
    }

    public String getUkuranBbGembok() {
        return ukuranBbGembok;
    }

    public void setUkuranBbGembok(String ukuranBbGembok) {
        this.ukuranBbGembok = ukuranBbGembok;
    }

    public String getGarduBb() {
        return garduBb;
    }

    public void setGarduBb(String garduBb) {
        this.garduBb = garduBb;
    }

    public String getKotakappBb() {
        return kotakappBb;
    }

    public void setKotakappBb(String kotakappBb) {
        this.kotakappBb = kotakappBb;
    }

    public String getPengukurBb() {
        return pengukurBb;
    }

    public void setPengukurBb(String pengukurBb) {
        this.pengukurBb = pengukurBb;
    }

    public String getPembatasBb() {
        return pembatasBb;
    }

    public void setPembatasBb(String pembatasBb) {
        this.pembatasBb = pembatasBb;
    }

    public String getBantupengukuranBb() {
        return bantupengukuranBb;
    }

    public void setBantupengukuranBb(String bantupengukuranBb) {
        this.bantupengukuranBb = bantupengukuranBb;
    }

    public String getPelindungBb() {
        return pelindungBb;
    }

    public void setPelindungBb(String pelindungBb) {
        this.pelindungBb = pelindungBb;
    }
}
