package com.projek.p2pl.pemeriksaan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.projek.p2pl.R;
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_periksa;
import com.projek.p2pl.model.m_petugas;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by amien on 28/02/18.
 */

public class Periksa extends AbstractStep {
    private int i = 1;
    private Realm mRealm;
//    private final static String CLICK = "click";

    @Bind(R.id.kwh_meter_1a) Spinner kwh_meter_1a;
    @Bind(R.id.merk_1a) Spinner merk_1a;
    @Bind(R.id.tahun_1a) EditText tahun_1a;
    @Bind(R.id.putaran_1a) EditText putaran_1a;
    @Bind(R.id.kondisi_visual_1a) Spinner kondisi_visual_1a;

    @Bind(R.id.segel_terpasang_1b) EditText segel_terpasang_1b;
    @Bind(R.id.jenis_1b) Spinner jenis_1b;
    @Bind(R.id.acuan_1b) EditText acuan_1b;
    @Bind(R.id.tahun_1b) EditText tahun_1b;
    @Bind(R.id.kondisi_visual_1b) Spinner kondisi_visual_1b;

    @Bind(R.id.kapasitas_2a) EditText kapasitas_2a;
    @Bind(R.id.merk_2a) Spinner merk_2a;
    @Bind(R.id.segel_terpasang_2b) EditText segel_terpasang_2b;
    @Bind(R.id.jenis_2b) Spinner jenis_2b;
    @Bind(R.id.acuan_2b) EditText acuan_2b;
    @Bind(R.id.tahun_2b) EditText tahun_2b;

    @Bind(R.id.papan_meter_3a) Spinner papan_meter_3a;
    @Bind(R.id.jenis_3a) Spinner jenis_3a;
    @Bind(R.id.kondisi_visual_3a) Spinner kondisi_visual_3a;
    @Bind(R.id.segel_terpasang_3a) EditText segel_terpasang_3a;
    @Bind(R.id.jenis_3a2) Spinner jenis_3a2;
    @Bind(R.id.acuan_3a) EditText acuan_3a;
    @Bind(R.id.tahun_3a) EditText tahun_3a;

    @Bind(R.id.sesuai) Spinner sesuai;
    @Bind(R.id.hasil) Spinner hasil;
    @Bind(R.id.pelanggaran) Spinner pelanggaran;
    @Bind(R.id.deskripsi_pelanggaran) EditText deskripsi_pelanggaran;
    @Bind(R.id.tindakan) EditText tindakan;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.periksa, container, false);

        mRealm = Realm.getInstance(getContext());

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
//        state.putInt(CLICK, i);
    }

    @Override
    public String name() {
        return "Step " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
        return true;
    }


    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "Form Periksa";
    }

    @Override
    public boolean nextIf() {
        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("kwh_meter_1a",kwh_meter_1a.getSelectedItem().toString());
        editor.putString("merk_1a",merk_1a.getSelectedItem().toString());
        editor.putString("tahun_1a",tahun_1a.getText().toString());
        editor.putString("putaran_1a",putaran_1a.getText().toString());
        editor.putString("kondisi_visual_1a",kondisi_visual_1a.getSelectedItem().toString());
        editor.putString("segel_terpasang_1b",segel_terpasang_1b.getText().toString());
        editor.putString("jenis_1b",jenis_1b.getSelectedItem().toString());
        editor.putString("acuan_1b",acuan_1b.getText().toString());
        editor.putString("tahun_1b",tahun_1b.getText().toString());
        editor.putString("kondisi_visual_1b",kondisi_visual_1b.getSelectedItem().toString());
        editor.putString("kapasitas_2a",kapasitas_2a.getText().toString());
        editor.putString("merk_2a",merk_2a.getSelectedItem().toString());
        editor.putString("segel_terpasang_2b",segel_terpasang_2b.getText().toString());
        editor.putString("jenis_2b",jenis_2b.getSelectedItem().toString());
        editor.putString("acuan_2b",acuan_2b.getText().toString());
        editor.putString("tahun_2b",tahun_2b.getText().toString());
        editor.putString("papan_meter_3a",papan_meter_3a.getSelectedItem().toString());
        editor.putString("jenis_3a",jenis_3a.getSelectedItem().toString());
        editor.putString("kondisi_visual_3a",kondisi_visual_3a.getSelectedItem().toString());
        editor.putString("segel_terpasang_3a",segel_terpasang_3a.getText().toString());
        editor.putString("jenis_3a2",jenis_3a2.getSelectedItem().toString());
        editor.putString("acuan_3a",acuan_3a.getText().toString());
        editor.putString("tahun_3a",tahun_3a.getText().toString());
        editor.putString("sesuai",sesuai.getSelectedItem().toString());
        editor.putString("hasil",hasil.getSelectedItem().toString());
        editor.putString("pelanggaran",pelanggaran.getSelectedItem().toString());
        editor.putString("deskripsi_pelanggan",deskripsi_pelanggaran.getText().toString());
        editor.putString("tindakan",tindakan.getText().toString());
        editor.commit();

        return i > 1;

    }


//    public void insert_periksa(){
//        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
//        mRealm.beginTransaction();
//        m_periksa editor = mRealm.createObject(m_periksa.class);
//        editor.setId(pemeriksaan.getString("id",null));
//        mRealm.commitTransaction();
//
//    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}
