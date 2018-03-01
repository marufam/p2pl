package com.projek.p2pl.pemeriksaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.projek.p2pl.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by amien on 28/02/18.
 */

public class Periksa extends AbstractStep {
    private int i = 1;

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
        return i > 1;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}
