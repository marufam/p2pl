package com.projek.p2pl;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.projek.p2pl.pemeriksaan.Pelanggan;
import com.projek.p2pl.pemeriksaan.Periksa;
import com.projek.p2pl.pemeriksaan.Petugas;

public class StepActivity extends TabStepper {

    private int i = 1;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Isi Form");
        setAlternativeTab(true);

        addStep(createFragment(new Petugas()));
        addStep(createFragment(new Pelanggan()));
        addStep(createFragment(new Periksa()));

        super.onCreate(savedInstanceState);
    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }

}
