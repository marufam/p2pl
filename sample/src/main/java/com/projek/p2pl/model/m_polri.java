package com.projek.p2pl.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by amien on 28/02/18.
 */

public class m_polri extends RealmObject {
    @PrimaryKey
    private String id_polri;

    private String nama;

    private String nip;

    private String jabatan;

    public String getId_polri() {
        return id_polri;
    }

    public void setId_polri(String id_polri) {
        this.id_polri = id_polri;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
