package com.projek.p2pl.pemeriksaan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.projek.p2pl.R;
import com.projek.p2pl.model.m_barangbukti;
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_periksa;
import com.projek.p2pl.model.m_petugas;


import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by amien on 28/02/18.
 */

public class BarangBukti extends AbstractStep {

    private int i = 1;
    private Realm mRealm;

    @Bind(R.id.merk_bb_kwh) EditText merkBbKwh;
    @Bind(R.id.tarip_bb_kwh) EditText taripBbKwh;
    @Bind(R.id.nopabrik_bb_kwh)   EditText nopabrikBbKwh;
    @Bind(R.id.tahun_bb_kwh)   EditText tahunBbKwh;
    @Bind(R.id.faktormeter_bb_kwh)    EditText faktormeterBbKwh;
    @Bind(R.id.ukuranx_bb_kwh)    EditText ukuranxBbKwh;
    @Bind(R.id.ukurany_bb_kwh)    EditText ukuranyBbKwh;
    @Bind(R.id.ampere_bb_kwh)    EditText ampereBbKwh;
    @Bind(R.id.stand_bb_kWh)    EditText standBbKWh;

    @Bind(R.id.merk_bb_kvarh)    EditText merkBbKvarh;
    @Bind(R.id.tarip_bb_kvarh)    EditText taripBbKvarh;
    @Bind(R.id.nopabrik_bb_kvarh)    EditText nopabrikBbKvarh;
    @Bind(R.id.tahun_bb_kVarh)    EditText tahunBbKvarh;
    @Bind(R.id.faktormeter_bb_kvarh)    EditText faktormeterBbKvarh;
    @Bind(R.id.ukuranx_bb_kvarh)    EditText ukuranxBbKvarh;
    @Bind(R.id.ukurany_bb_kvarh)    EditText ukuranyBbKvarh;
    @Bind(R.id.ampere_bb_kvarh)    EditText ampereBbKvarh;
    @Bind(R.id.stand_bb_kvarh)    EditText standBbKvarh;

    @Bind(R.id.merk_bb_kva)    EditText merkBbKva;
    @Bind(R.id.tarip_bb_kva)    EditText taripBbKva;
    @Bind(R.id.nopabrik_bb_kva)    EditText nopabrikBbKva;
    @Bind(R.id.tahun_bb_kVa)    EditText tahunBbKva;
    @Bind(R.id.faktormeter_bb_kva)    EditText faktormeterBbKva;
    @Bind(R.id.ukuranx_bb_kva)    EditText ukuranxBbKva;
    @Bind(R.id.ukurany_bb_kva)    EditText ukuranyBbKva;
    @Bind(R.id.ampere_bb_kva)    EditText ampereBbKva;

    @Bind(R.id.nama_bb_pembatas)    EditText namaBbPembatas;
    @Bind(R.id.tipeukuran_bb_pembatas)    EditText tipeukuranBbPembatas;
    @Bind(R.id.ukuranx_bb_pembatas)    EditText ukuranxBbPembatas;
    @Bind(R.id.ukurany_bb_pembatas)    EditText ukuranyBbPembatas;

    @Bind(R.id.merk_bb_trafo)    EditText merkBbTrafo;
    @Bind(R.id.nopabrik_bb_trafo)    EditText nopabrikBbTrafo;
    @Bind(R.id.ratio_bb_trafo)    EditText ratioBbTrafo;

    @Bind(R.id.jeniskabel_bb_kabel)    EditText jeniskabelBbKabel;
    @Bind(R.id.diameterx_bb_kabel)    EditText diameterxBbKabel;
    @Bind(R.id.diametery_bb_kabel)    EditText diameteryBbKabel;
    @Bind(R.id.panjang_bb_kabel)    EditText panjangBbKabel;

    @Bind(R.id.merk_bb_kontaktor)    EditText merkBbKontaktor;
    @Bind(R.id.nopabrik_bb_kontaktor)    EditText nopabrikBbKontaktor;
    @Bind(R.id.fasa_bb_trafo)    EditText fasaBbTrafo;

    @Bind(R.id.jenis_bb_fuse)    EditText jenisBbFuse;
    @Bind(R.id.merk_bb_fuse)    EditText merkBbFuse;
    @Bind(R.id.nopabrik_bb_fuse)    EditText nopabrikBbFuse;

    @Bind(R.id.ukuran_bb_gembok)    EditText ukuranBbGembok;

    @Bind(R.id.gardu_bb)    EditText garduBb;
    @Bind(R.id.kotakapp_bb)    EditText kotakappBb;
    @Bind(R.id.pengukur_bb)    EditText pengukurBb;
    @Bind(R.id.pembatas_bb)    EditText pembatasBb;
    @Bind(R.id.bantupengukuran_bb)    EditText bantupengukuranBb;
    @Bind(R.id.pelindung_bb)    EditText pelindungBb;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.barangbukti, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getInstance(getContext());

    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
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
        return "Form Barang Bukti";
    }

    @Override
    public boolean nextIf() {
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        Toast.makeText(mStepper, "Complete", Toast.LENGTH_SHORT).show();
        Log.d("preference coba",pemeriksaan.getAll().toString());
        insert_petugas();
        insert_pelanggan();
        insert_periksa();
        insert_barangbukti();

        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        SharedPreferences.Editor myperiksa = pref.edit();
        myperiksa.clear();

        getActivity().finish();
//        Log.d("Pemeriksaan","kwh meter 1a : " + pemeriksaan.getString("kwh_meter_1a",null));
//        Log.d("Pemeriksaan","kondisi visual 1a : " + pemeriksaan.getString("kondisi_visual_1a",null));
//        Log.d("Pemeriksaan","jenis 1b : " + pemeriksaan.getString("jenis_1b",null));
//        Log.d("Pemeriksaan","kondisi visual 1b : " + pemeriksaan.getString("kondisi_visual_1b",null));
//        Log.d("Pemeriksaan","jenis 2b : " + pemeriksaan.getString("jenis_2b",null));
//        Log.d("Pemeriksaan","papan meter 3a : " + pemeriksaan.getString("papan_meter_3a",null));
//        Log.d("Pemeriksaan","jenis 3a : " + pemeriksaan.getString("jenis_3a",null));
//        Log.d("Pemeriksaan","kondisi visual 3a : " + pemeriksaan.getString("kondisi_visual_3a",null));
//        Log.d("Pemeriksaan","jenis 3a2 : " + pemeriksaan.getString("jenis_3a2",null));
//        Log.d("Pemeriksaan","sesuai 4a : " + pemeriksaan.getString("sesuai",null));
//        Log.d("Pemeriksaan","hasil : " + pemeriksaan.getString("hasil",null));

        return i > i;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }

    public void insert_barangbukti(){
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        mRealm.beginTransaction();
        m_barangbukti mybarangbukti = mRealm.createObject(m_barangbukti.class);
        mybarangbukti.setId(pemeriksaan.getString("id",null));
        mybarangbukti.setMerkBbKwh(merkBbKwh.getText().toString());
        mybarangbukti.setTaripBbKwh(taripBbKwh.getText().toString());
        mybarangbukti.setNopabrikBbKwh(nopabrikBbKwh.getText().toString());
        mybarangbukti.setTahunBbKwh(tahunBbKwh.getText().toString());
        mybarangbukti.setFaktormeterBbKwh(faktormeterBbKwh.getText().toString());
        mybarangbukti.setUkuranxBbKwh(ukuranxBbKwh.getText().toString());
        mybarangbukti.setUkuranyBbKwh(ukuranyBbKwh.getText().toString());
        mybarangbukti.setAmpereBbKwh(ampereBbKwh.getText().toString());
        mybarangbukti.setStandBbKWh(standBbKWh.getText().toString());

        mybarangbukti.setMerkBbKvarh(merkBbKvarh.getText().toString());
        mybarangbukti.setTaripBbKvarh(taripBbKvarh.getText().toString());
        mybarangbukti.setNopabrikBbKvarh(nopabrikBbKvarh.getText().toString());
        mybarangbukti.setTahunBbKvarh(tahunBbKvarh.getText().toString());
        mybarangbukti.setFaktormeterBbKvarh(faktormeterBbKvarh.getText().toString());
        mybarangbukti.setUkuranxBbKvarh(merkBbKvarh.getText().toString());
        mybarangbukti.setUkuranyBbKvarh(ukuranyBbKvarh.getText().toString());
        mybarangbukti.setAmpereBbKvarh(ampereBbKvarh.getText().toString());
        mybarangbukti.setStandBbKvarh(standBbKvarh.getText().toString());

        mybarangbukti.setMerkBbKva(merkBbKva.getText().toString());
        mybarangbukti.setTaripBbKva(taripBbKva.getText().toString());
        mybarangbukti.setNopabrikBbKva(nopabrikBbKva.getText().toString());
        mybarangbukti.setTahunBbKva(tahunBbKva.getText().toString());
        mybarangbukti.setFaktormeterBbKva(faktormeterBbKva.getText().toString());
        mybarangbukti.setUkuranxBbKva(ukuranxBbKva.getText().toString());
        mybarangbukti.setUkuranyBbKva(ukuranyBbKva.getText().toString());
        mybarangbukti.setAmpereBbKva(ampereBbKva.getText().toString());

        mybarangbukti.setNamaBbPembatas(namaBbPembatas.getText().toString());
        mybarangbukti.setTipeukuranBbPembatas(tipeukuranBbPembatas.getText().toString());
        mybarangbukti.setUkuranxBbPembatas(ukuranxBbPembatas.getText().toString());
        mybarangbukti.setUkuranyBbPembatas(ukuranyBbPembatas.getText().toString());

        mybarangbukti.setMerkBbTrafo(merkBbTrafo.getText().toString());
        mybarangbukti.setNopabrikBbTrafo(nopabrikBbTrafo.getText().toString());
        mybarangbukti.setRatioBbTrafo(ratioBbTrafo.getText().toString());

        mybarangbukti.setJeniskabelBbKabel(jeniskabelBbKabel.getText().toString());
        mybarangbukti.setDiameterxBbKabel(diameterxBbKabel.getText().toString());
        mybarangbukti.setDiameteryBbKabel(diameteryBbKabel.getText().toString());
        mybarangbukti.setPanjangBbKabel(panjangBbKabel.getText().toString());
        mybarangbukti.setMerkBbKontaktor(merkBbKontaktor.getText().toString());
        mybarangbukti.setNopabrikBbKontaktor(nopabrikBbKontaktor.getText().toString());
        mybarangbukti.setFasaBbTrafo(fasaBbTrafo.getText().toString());
        mybarangbukti.setJenisBbFuse(jenisBbFuse.getText().toString());
        mybarangbukti.setMerkBbFuse(merkBbFuse.getText().toString());
        mybarangbukti.setNopabrikBbFuse(nopabrikBbFuse.getText().toString());
        mybarangbukti.setUkuranBbGembok(ukuranBbGembok.getText().toString());
        mybarangbukti.setGarduBb(garduBb.getText().toString());
        mybarangbukti.setKotakappBb(kotakappBb.getText().toString());
        mybarangbukti.setPengukurBb(pengukurBb.getText().toString());
        mybarangbukti.setPembatasBb(pembatasBb.getText().toString());
        mybarangbukti.setBantupengukuranBb(bantupengukuranBb.getText().toString());
        mybarangbukti.setPelindungBb(pelindungBb.getText().toString());
        mRealm.commitTransaction();
    }

    public void insert_periksa() {
        SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode
        String hasil = "s";
        mRealm.beginTransaction();
        m_periksa myperiksa = mRealm.createObject(m_periksa.class);
        myperiksa.setId(pemeriksaan.getString("id",null));
        myperiksa.setKwh_meter_1a(pemeriksaan.getString("kwh_meter_1a",null));
        myperiksa.setMerk_1a(pemeriksaan.getString("merk_1a", null));
        myperiksa.setTahun_1a(pemeriksaan.getString("tahun_1a",null));
        myperiksa.setPutaran_1a(pemeriksaan.getString("putaran_1a",null));
        myperiksa.setKondisi_visual_1a(pemeriksaan.getString("kondisi_visual_1a",null));
        myperiksa.setSegel_terpasang_1b(pemeriksaan.getString("segel_terpasang_1b",null));
        myperiksa.setJenis_1b(pemeriksaan.getString("jenis_1b",null));
        myperiksa.setAcuan_1b(pemeriksaan.getString("acuan_1b",null));
        myperiksa.setTahun_1b(pemeriksaan.getString("tahun_1b",null));
        myperiksa.setKondisi_visual_1b(pemeriksaan.getString("kondisi_visual_1b",null));
        myperiksa.setKapasitas_2a(pemeriksaan.getString("kapasitas_2a",null));
        myperiksa.setMerk_2a(pemeriksaan.getString("merk_2a",null));
        myperiksa.setSegel_terpasang_2b(pemeriksaan.getString("segel_terpasang_2b",null));
        myperiksa.setJenis_2b(pemeriksaan.getString("jenis_2b",null));
        myperiksa.setAcuan_2b(pemeriksaan.getString("acuan_2b",null));
        myperiksa.setTahun_2b(pemeriksaan.getString("tahun_2b", null));
        myperiksa.setPapan_meter_3a(pemeriksaan.getString("papan_meter_3a",null));
        myperiksa.setJenis_3a(pemeriksaan.getString("jenis_3a",null));
        myperiksa.setKondisi_visual_3a(pemeriksaan.getString("kondisi_visual_3a",null));
        myperiksa.setSegel_terpasang_3a(pemeriksaan.getString("segel_terpasang_3a",null));
        myperiksa.setJenis_3a2(pemeriksaan.getString("jenis_3a2",null));
        myperiksa.setAcuan_3a(pemeriksaan.getString("acuan_3a",null));
        myperiksa.setTahun_3a(pemeriksaan.getString("tahun_3a",null));
        myperiksa.setSesuai(pemeriksaan.getString("sesuai",null));
        myperiksa.setHasil(pemeriksaan.getString("hasil",null));
        myperiksa.setPelanggaran(pemeriksaan.getString("pelanggaran",null));
        myperiksa.setDeskripsi_pelanggaran(pemeriksaan.getString("deskripsi_pelanggaran", null));
        myperiksa.setTindakan(pemeriksaan.getString("tindakan",null));
        mRealm.commitTransaction();
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
        mypelanggan.setNomor_identitas(pemeriksaan.getString("nomor_identitas",null));
        mypelanggan.setPekerjaan_penghuni(pemeriksaan.getString("pekerjaan_penghuni",null));

        mypelanggan.setTerdaftar(pemeriksaan.getString("terdaftar",null));

        mypelanggan.setNoktp_saksi1(pemeriksaan.getString("noktp_saksi1",null));
        mypelanggan.setNama_saksi1(pemeriksaan.getString("nama_saksi1",null));
        mypelanggan.setNoktp_saksi2(pemeriksaan.getString("noktp_saksi2",null));
        mypelanggan.setNama_saksi2(pemeriksaan.getString("nama_saksi2",null));
        mypelanggan.setFoto(pemeriksaan.getString("foto",null));
        mypelanggan.setStatus(pemeriksaan.getString("status",null));
        mypelanggan.setLat(Double.parseDouble(pemeriksaan.getString("lat",null)));
        mypelanggan.setLng(Double.parseDouble(pemeriksaan.getString("lng",null)));
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
        mypetugas.setTanggal_suratpolri(pemeriksaan.getString("tanggal_nsp", null));

        mypetugas.setPetugas1(pemeriksaan.getString("petugas1", null));
        mypetugas.setNippetugas1(pemeriksaan.getString("nippetugas1", null));
        mypetugas.setJabatanpetugas1(pemeriksaan.getString("jabatanpetugas1", null));

        mypetugas.setPetugas2(pemeriksaan.getString("petugas2", null));
        mypetugas.setNippetugas2(pemeriksaan.getString("nippetugas2", null));
        mypetugas.setJabatanpetugas2(pemeriksaan.getString("jabatanpetugas2", null));
        mRealm.commitTransaction();
    }


}













