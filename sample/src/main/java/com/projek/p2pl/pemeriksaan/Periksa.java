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
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        Toast.makeText(mStepper, "Complete", Toast.LENGTH_SHORT).show();
        Log.d("preference coba",pemeriksaan.getAll().toString());
        insert_petugas();
        insert_pelanggan();
        insert_periksa();

        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();

        getActivity().finish();

        return i > 1;

    }

    public void insert_pelanggan(){
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        mRealm.beginTransaction();
        m_pelanggan mypelanggan = mRealm.createObject(m_pelanggan.class);
        mypelanggan.setId(pemeriksaan.getString("id",null));
        mypelanggan.setId_pelanggan(pemeriksaan.getString("id_pelanggan",null));
        mypelanggan.setNama(pemeriksaan.getString("nama",null));
        mypelanggan.setAlamat(pemeriksaan.getString("alamat",null));
        mypelanggan.setNo_gardu(pemeriksaan.getString("no_gardu",null));
        mypelanggan.setTarif(pemeriksaan.getString("tarif",null));
        mypelanggan.setNama_penghuni(pemeriksaan.getString("nama_penghuni",null));
        mypelanggan.setAlamat_penghuni(pemeriksaan.getString("alamat_penghuni",null));
        mypelanggan.setNoktp_penghuni(pemeriksaan.getString("noktp",null));
        mypelanggan.setId_pelanggan(pemeriksaan.getString("id_pelanggan",null));
        mypelanggan.setNama_saksi(pemeriksaan.getString("nama_saksi",null));
        mypelanggan.setAlamat_saksi(pemeriksaan.getString("alamat_saksi",null));
        mypelanggan.setNomor_identitas(pemeriksaan.getString("nomor_identitas",null));
        mypelanggan.setPekerjaan_saksi(pemeriksaan.getString("pekerjaan_saksi",null));
        mypelanggan.setFoto(pemeriksaan.getString("foto",null));
        mypelanggan.setStatus(pemeriksaan.getString("status",null));
        mypelanggan.setLat(Double.parseDouble(pemeriksaan.getString("lat",null)));
        mypelanggan.setLng(Double.parseDouble(pemeriksaan.getString("lng",null)));
        mRealm.commitTransaction();

    }

    public void insert_periksa(){
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        mRealm.beginTransaction();
        m_periksa myperiksa = mRealm.createObject(m_periksa.class);
        myperiksa.setId(pemeriksaan.getString("id",null));
        myperiksa.setKwh_meter_1a(kwh_meter_1a.getSelectedItem().toString());
        myperiksa.setMerk_1a(merk_1a.getSelectedItem().toString());
        myperiksa.setTahun_1a(tahun_1a.getText().toString());
        myperiksa.setPutaran_1a(putaran_1a.getText().toString());
        myperiksa.setKondisi_visual_1a(kondisi_visual_1a.getSelectedItem().toString());
        myperiksa.setSegel_terpasang_1b(segel_terpasang_1b.getText().toString());
        myperiksa.setJenis_1b(jenis_1b.getSelectedItem().toString());
        myperiksa.setAcuan_1b(acuan_1b.getText().toString());
        myperiksa.setTahun_1b(tahun_1b.getText().toString());
        myperiksa.setKondisi_visual_1b(kondisi_visual_1b.getSelectedItem().toString());
        myperiksa.setKapasitas_2a(kapasitas_2a.getText().toString());
        myperiksa.setMerk_2a(merk_2a.getSelectedItem().toString());
        myperiksa.setSegel_terpasang_2b(segel_terpasang_2b.getText().toString());
        myperiksa.setJenis_2b(jenis_2b.getSelectedItem().toString());
        myperiksa.setAcuan_2b(acuan_2b.getText().toString());
        myperiksa.setTahun_2b(tahun_2b.getText().toString());
        myperiksa.setPapan_meter_3a(papan_meter_3a.getSelectedItem().toString());
        myperiksa.setJenis_3a(jenis_3a.getSelectedItem().toString());
        myperiksa.setKondisi_visual_3a(kondisi_visual_3a.getSelectedItem().toString());
        myperiksa.setSegel_terpasang_3a(segel_terpasang_3a.getText().toString());
        myperiksa.setJenis_3a2(jenis_3a2.getSelectedItem().toString());
        myperiksa.setAcuan_3a(acuan_3a.getText().toString());
        myperiksa.setTahun_3a(tahun_3a.getText().toString());
        myperiksa.setSesuai(sesuai.getSelectedItem().toString());
        myperiksa.setHasil(hasil.getSelectedItem().toString());
        myperiksa.setPelanggaran(pelanggaran.getSelectedItem().toString());
        myperiksa.setDeskripsi_pelanggaran(deskripsi_pelanggaran.getText().toString());
        myperiksa.setTindakan(tindakan.getText().toString());
        mRealm.commitTransaction();

    }

    public void insert_petugas(){
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        mRealm.beginTransaction();
        m_petugas mypetugas = mRealm.createObject(m_petugas.class);
        mypetugas.setId(pemeriksaan.getString("id", null));
        mypetugas.setNomorsurat(pemeriksaan.getString("nomorsurat", null));
        mypetugas.setTanggalsurat(pemeriksaan.getString("tanggalsurat", null));
        mypetugas.setNama(pemeriksaan.getString("nama_petugas", null));
        mypetugas.setNoinduk(pemeriksaan.getString("noinduk_petugas", null));
        mypetugas.setJabatan(pemeriksaan.getString("jabatan_petugas", null));
        mypetugas.setNama_vendor(pemeriksaan.getString("namavendor", null));
        mypetugas.setNoinduk_vendor(pemeriksaan.getString("noindukvendor", null));
        mypetugas.setJabatan_vendor(pemeriksaan.getString("jabatanvendor", null));
        mypetugas.setNomor_surat_porli(pemeriksaan.getString("nomorsuratpolri", null));
        mypetugas.setTanggal(pemeriksaan.getString("tanggal_nsp", null));
        mypetugas.setPetugas1(pemeriksaan.getString("petugas1", null));
        mypetugas.setPetugas2(pemeriksaan.getString("petugas2", null));
        mRealm.commitTransaction();
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}
