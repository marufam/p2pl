package com.projek.p2pl.pemeriksaan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.projek.p2pl.R;
import com.projek.p2pl.model.m_petugas;
import com.projek.p2pl.model.m_polri;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by amien on 28/02/18.
 */

public class BarangBukti extends AbstractStep {

    @Bind(R.id.nomorsurat) EditText nomorsurat;
    @Bind(R.id.tanggalsurat) EditText tanggalsurat;
    @Bind(R.id.nama) EditText nama;
    @Bind(R.id.noinduk) EditText noinduk;
    @Bind(R.id.jabatan) EditText jabatan;
    @Bind(R.id.nama_vendor) EditText namavendor;
    @Bind(R.id.noinduk_vendor) EditText noindukvendor;
    @Bind(R.id.jabatan_vendor) EditText jabatanvendor;
    @Bind(R.id.nomor_surat_porli) EditText nomorsuratpolri;
    @Bind(R.id.tanggal) EditText tanggal;
    @Bind(R.id.petugas1) EditText petugas1;
    @Bind(R.id.petugas2) EditText petugas2;

    private int i = 1;
    private Realm mRealm;

    public BarangBukti() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getInstance(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.barangbukti, container, false);
//        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
//        state.putInt(CLICK, i);
//        Toast.makeText(mStepper, "onNext1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String name() {
//        Toast.makeText(mStepper, "onNext2", Toast.LENGTH_SHORT).show();
        return "Step " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
//        Toast.makeText(mStepper, "onNext3", Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    public void onStepVisible() {
//        Toast.makeText(mStepper, "visible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext() {
//        Toast.makeText(mStepper, "onNext5", Toast.LENGTH_SHORT).show();
        System.out.println("onNext");

    }

    @Override
    public void onPrevious() {
//        Toast.makeText(mStepper, "onNext6", Toast.LENGTH_SHORT).show();
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
//        Toast.makeText(mStepper, "onNext7", Toast.LENGTH_SHORT).show();
        return "Form Barang Bukti";
    }

//    @Override
//    public boolean nextIf() {
////        if( TextUtils.isEmpty(nomorsurat.getText())) {
////            nomorsurat.setError("First name is required!");
////        }else {
////        Toast.makeText(mStepper, "onNext8", Toast.LENGTH_SHORT).show();
//        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
//        SharedPreferences.Editor editor = pref.edit();
//        String id = String.valueOf((int) System.currentTimeMillis() / 1000);
//        editor.putString("id", id.toString());
//        editor.putString("nomorsurat", nomorsurat.getText().toString());
//        editor.putString("tanggalsurat", tanggalsurat.getText().toString());
//        editor.putString("nama_petugas", nama.getText().toString());
//        editor.putString("noinduk_petugas", noinduk.getText().toString());
//        editor.putString("jabatan_petugas", jabatan.getText().toString());
//        editor.putString("namavendor", namavendor.getText().toString());
//        editor.putString("noindukvendor", noindukvendor.getText().toString());
//        editor.putString("jabatanvendor", jabatanvendor.getText().toString());
//        editor.putString("nomorsuratpolri", nomorsuratpolri.getText().toString());
//        editor.putString("tanggal_nsp", tanggal.getText().toString());
//        editor.putString("petugas1", petugas1.getText().toString());
//        editor.putString("petugas2", petugas2.getText().toString());
//        editor.commit();
////        }
//        return i > i;
//    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }


}













