package com.projek.p2pl;

import android.os.Bundle;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.projek.p2pl.pemeriksaan.Pelanggan;

public class StepActivity extends TabStepper {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Isi Form");
        setAlternativeTab(true);

        addStep(createFragment(new Pelanggan()));
        addStep(createFragment(new Pelanggan()));

        super.onCreate(savedInstanceState);
    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }

}
