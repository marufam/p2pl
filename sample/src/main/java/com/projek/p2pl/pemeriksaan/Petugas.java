package com.projek.p2pl.pemeriksaan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.projek.p2pl.R;
import com.projek.p2pl.StepActivity;
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_petugas;
import com.projek.p2pl.model.m_polri;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by amien on 28/02/18.
 */

public class Petugas extends AbstractStep {

    //    @Bind(R.id.nomorsurat) EditText nosurat;        // nomor surat dengan format
    @Bind(R.id.nomorsurat)
    EditText nomorsurat;     // nomor surat tugas
    @Bind(R.id.tanggalsurat)
    EditText tanggalsurat;
    @Bind(R.id.nama)
    EditText nama;
    @Bind(R.id.noinduk)
    EditText noinduk;
    @Bind(R.id.jabatan)
    EditText jabatan;

    @Bind(R.id.nama_vendor)
    EditText namavendor;
    @Bind(R.id.noinduk_vendor)
    EditText noindukvendor;
    @Bind(R.id.jabatan_vendor)
    EditText jabatanvendor;

    @Bind(R.id.nomor_surat_porli)
    EditText nomorsuratpolri;
    @Bind(R.id.tanggal)
    EditText tanggal;

    @Bind(R.id.petugas1)
    Spinner petugas1;
    @Bind(R.id.petugas2)
    Spinner petugas2;

    @Bind(R.id.nippetugas1)
    EditText nippetugas1;
    @Bind(R.id.jabatanpetugas1)
    EditText jabatanpetugas1;

    @Bind(R.id.nippetugas2)
    EditText nippetugas2;
    @Bind(R.id.jabatanpetugas2)
    EditText jabatanpetugas2;

    @Bind(R.id.tambah_polri)
    Button tambahpolri;

    private int i = 1;
    private Realm mRealm;

    EditText nippolri, namapolri, jabatanpolri;
    Button simpan, cancel;
    ArrayAdapter<String> adapter;
    List<String> users = new ArrayList<>();
    List<m_polri> users2 = new ArrayList<>();

    public Petugas() {
    }

    @OnClick(R.id.tambah_polri)
    void onSimpanClick() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.activity_polisi);
        dialog.setTitle("Tambah Data");

        namapolri = (EditText) dialog.findViewById(R.id.namapolri);
        nippolri = (EditText) dialog.findViewById(R.id.nip);
        jabatanpolri = (EditText) dialog.findViewById(R.id.jabatan);
        simpan = (Button) dialog.findViewById(R.id.simpan);
        cancel = (Button) dialog.findViewById(R.id.cancel);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = String.valueOf((int) System.currentTimeMillis() / 1000);
                mRealm.beginTransaction();
                m_polri mypolri = mRealm.createObject(m_polri.class);
                mypolri.setId_polri(id);
                mypolri.setNip(nippolri.getText().toString());
                mypolri.setNama(namapolri.getText().toString());
                mypolri.setJabatan(jabatanpolri.getText().toString());
                mRealm.commitTransaction();
                loadspinner();
                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.petugas, container, false);
        ButterKnife.bind(this, rootView);
        mRealm = Realm.getInstance(getContext());
        loadspinner();

        petugas1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mStepper, ""+position, Toast.LENGTH_SHORT).show();
                nippetugas1.setText(users2.get(position).getNip());
                jabatanpetugas1.setText(users2.get(position).getJabatan());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        petugas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mStepper, ""+position, Toast.LENGTH_SHORT).show();
                nippetugas2.setText(users2.get(position).getNip());
                jabatanpetugas2.setText(users2.get(position).getJabatan());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return rootView;
    }

    public void loadspinner() {
        users.clear();
        users2.clear();

        users.add("--Tidak Ada--");
        users2.add(new m_polri("1", "-", "-", "-"));
        for (int i = 0; i < mRealm.allObjects(m_polri.class).size(); i++) {
            users.add(mRealm.allObjects(m_polri.class).get(i).getNama().toString());
            users2.add(mRealm.allObjects(m_polri.class).get(i));
        }
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, users);
        petugas1.setAdapter(adapter);
        petugas2.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
//        state.putInt(CLICK, i);
        Toast.makeText(mStepper, "onNext1", Toast.LENGTH_SHORT).show();
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
        return "Form Petugas";
    }

    @Override
    public boolean nextIf() {
//        if( TextUtils.isEmpty(nomorsurat.getText())) {
//            nomorsurat.setError("First name is required!");
//        }else {
//        Toast.makeText(mStepper, "onNext8", Toast.LENGTH_SHORT).show();
        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        SharedPreferences.Editor editor = pref.edit();
        String id = String.valueOf((int) System.currentTimeMillis() / 1000);
        editor.putString("id", id.toString());
        // nomor surat belum
        // rayon, alamat, cabang, wilayah
        editor.putString("nomorsurat_tugas", nomorsurat.getText().toString());    // nomor surat tugas
        editor.putString("tanggal_nomorsurat_tugas", tanggalsurat.getText().toString());

        editor.putString("nama", nama.getText().toString());
        editor.putString("no_induk", noinduk.getText().toString());
        editor.putString("jabatan", jabatan.getText().toString());

        editor.putString("nama_vendor", namavendor.getText().toString());
        editor.putString("no_induk_vendor", noindukvendor.getText().toString());
        editor.putString("jabatan_vendor", jabatanvendor.getText().toString());

        editor.putString("nomor_surat_polri", nomorsuratpolri.getText().toString());
        editor.putString("tanggal_suratpolri", tanggal.getText().toString());

        editor.putString("nama_polri1", petugas1.getSelectedItem().toString());
        editor.putString("nip_polri1", nippetugas1.getText().toString());
        editor.putString("jabatan_polri1", jabatanpetugas1.getText().toString());

        editor.putString("nama_polri2", petugas2.getSelectedItem().toString());
        editor.putString("nip_polri2", nippetugas2.getText().toString());
        editor.putString("jabatan_polri2", jabatanpetugas2.getText().toString());
        editor.commit();
//        }
        return i > i;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }


}













