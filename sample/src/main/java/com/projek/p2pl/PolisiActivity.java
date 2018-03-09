package com.projek.p2pl;

/**
 * Created by amien on 09/03/18.
 */

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.Button;

import com.projek.p2pl.model.m_barangbukti;
import com.projek.p2pl.model.m_polri;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import io.realm.Realm;

public class PolisiActivity extends Activity  {

    @Bind(R.id.card_view) CardView cardView;
    @Bind(R.id.namapolri) EditText namapolri;
    @Bind(R.id.nip) EditText nip;
    @Bind(R.id.jabatan) EditText jabatan;
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polisi);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.simpan) void onSimpanClick() {
        //TODO implement
        String id = String.valueOf((int) System.currentTimeMillis() / 1000);
        mRealm.beginTransaction();
        m_polri mypolri = mRealm.createObject(m_polri.class);
        mypolri.setId_polri(id);
        mypolri.setNip(nip.getText().toString());
        mypolri.setNama(namapolri.getText().toString());
        mypolri.setJabatan(jabatan.getText().toString());
        mRealm.commitTransaction();
        finish();
    }

    @OnLongClick(R.id.simpan) boolean onSimpanLongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.cancel) void onCancelClick() {
        //TODO implement
    }

    @OnLongClick(R.id.cancel) boolean onCancelLongClick() {
        //TODO implement
        return true;
    }
}
