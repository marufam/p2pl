package com.projek.p2pl.pemeriksaan;

import android.content.SharedPreferences;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
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

    @Bind(R.id.merk_bb_kwh)
    Spinner merkBbKwh;
    @Bind(R.id.type_bb_kwh)
    Spinner typeBbKwh;
    @Bind(R.id.tarip_bb_kwh)
    EditText taripBbKwh;
    @Bind(R.id.nopabrik_bb_kwh)
    EditText nopabrikBbKwh;
    @Bind(R.id.faktormeter_bb_kwh)
    EditText faktormeterBbKwh;
    @Bind(R.id.ukuranx_bb_kwh)
    Spinner ukuranxBbKwh;
    @Bind(R.id.ukurany_bb_kwh)
    Spinner ukuranyBbKwh;
    @Bind(R.id.ampere_bb_kwh)
    EditText ampereBbKwh;
    @Bind(R.id.stand_bb_kWh)
    EditText standBbKWh;

    @Bind(R.id.merk_bb_kvarh)
    Spinner merkBbKvarh;
    @Bind(R.id.type_bb_kvarh)
    Spinner typeBbKvarh;
    @Bind(R.id.tarip_bb_kvarh)
    EditText taripBbKvarh;
    @Bind(R.id.nopabrik_bb_kvarh)
    EditText nopabrikBbKvarh;
    @Bind(R.id.faktormeter_bb_kvarh)
    EditText faktormeterBbKvarh;
    @Bind(R.id.ukuranx_bb_kvarh)
    Spinner ukuranxBbKvarh;
    @Bind(R.id.ukurany_bb_kvarh)
    Spinner ukuranyBbKvarh;
    @Bind(R.id.ampere_bb_kvarh)
    EditText ampereBbKvarh;
    @Bind(R.id.stand_bb_kvarh)
    EditText standBbKvarh;

    @Bind(R.id.merk_bb_kva)
    Spinner merkBbKva;
    @Bind(R.id.type_bb_kva)
    Spinner typeBbKva;
    @Bind(R.id.tarip_bb_kva)
    EditText taripBbKva;
    @Bind(R.id.nopabrik_bb_kva)
    EditText nopabrikBbKva;
    @Bind(R.id.faktormeter_bb_kva)
    EditText faktormeterBbKva;
    @Bind(R.id.ukuranx_bb_kva)
    Spinner ukuranxBbKva;
    @Bind(R.id.ukurany_bb_kva)
    Spinner ukuranyBbKva;
    @Bind(R.id.ampere_bb_kva)
    EditText ampereBbKva;

    AutoCompleteTextView nama_bb_pembatas;
    @Bind(R.id.tarip_bb_pembatas)
    EditText taripBbPembatas;
    @Bind(R.id.ukuranx_bb_pembatas)
    Spinner ukuranxBbPembatas;
    @Bind(R.id.ukurany_bb_pembatas)
    Spinner ukuranyBbPembatas;

    @Bind(R.id.merk_bb_trafo)
    Spinner merkBbTrafo;
    @Bind(R.id.type_bb_trafo)
    Spinner typeBbTrafo;
    @Bind(R.id.nopabrik_bb_trafo)
    EditText nopabrikBbTrafo;
    @Bind(R.id.ratio_bb_trafo)
    EditText ratioBbTrafo;
    @Bind(R.id.tahun_bb_trafo)
    EditText tahunBbTrafo;

    AutoCompleteTextView jenis_bb_kabel;
    @Bind(R.id.diameterx_bb_kabel)
    EditText diameterxBbKabel;
    @Bind(R.id.diametery_bb_kabel)
    EditText diameteryBbKabel;
    @Bind(R.id.panjang_bb_kabel)
    EditText panjangBbKabel;

    @Bind(R.id.merk_bb_kontaktor)
    Spinner merkBbKontaktor;
    @Bind(R.id.type_bb_kontaktor)
    Spinner typeBbKontaktor;
    @Bind(R.id.nopabrik_bb_kontaktor)
    EditText nopabrikBbKontaktor;
    @Bind(R.id.fasa_bb_trafo)
    Spinner fasaBbTrafo;

    @Bind(R.id.jenis_bb_fuse)
    EditText jenisBbFuse;
    @Bind(R.id.merk_bb_fuse)
    Spinner merkBbFuse;
    @Bind(R.id.type_bb_fuse)
    Spinner typeBbFuse;
    @Bind(R.id.nopabrik_bb_fuse)
    EditText nopabrikBbFuse;

    @Bind(R.id.ukuran_bb_gembok)
    Spinner ukuranBbGembok;
    @Bind(R.id.gardu_bb)
    EditText garduBb;
    @Bind(R.id.kotakapp_bb)
    EditText kotakappBb;
    @Bind(R.id.pengukur_bb)
    EditText pengukurBb;
    @Bind(R.id.pembatas_bb)
    EditText pembatasBb;
    @Bind(R.id.bantupengukuran_bb)
    EditText bantupengukuranBb;
    @Bind(R.id.pelindung_bb)
    EditText pelindungBb;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.barangbukti, container, false);

        String[] nama_alat_pembatas = new String[] {
                "MCB", "MCCB", "NFB", "NH Fuse", "FCO"
        };
        ArrayAdapter<String> alat_pembatas_adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_dropdown_item_1line, nama_alat_pembatas);
        nama_bb_pembatas = (AutoCompleteTextView)rootView.findViewById(R.id.nama_bb_pembatas);
        nama_bb_pembatas.setAdapter(alat_pembatas_adapter);

        String[] kabel_sadapan = new String[] {
                "NYM", "NYY", "NGA", "Kabel Tanah"
        };
        ArrayAdapter<String> kabel_sadapan_adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_dropdown_item_1line, kabel_sadapan);
        jenis_bb_kabel = (AutoCompleteTextView)rootView.findViewById(R.id.jenis_bb_kabel);
        jenis_bb_kabel.setAdapter(kabel_sadapan_adapter);



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
        /*
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
        */
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
        mybarangbukti.setMerkBbKwh(merkBbKwh.getSelectedItem().toString());
        mybarangbukti.setTypeBbKwh(typeBbKwh.getSelectedItem().toString());
        mybarangbukti.setTaripBbKwh (taripBbKwh.getText().toString());
        mybarangbukti.setNopabrikBbKwh(nopabrikBbKwh.getText().toString());
        mybarangbukti.setFaktormeterBbKwh(faktormeterBbKwh.getText().toString());
        mybarangbukti.setUkuranxBbKwh(ukuranxBbKwh.getSelectedItem().toString());
        mybarangbukti.setUkuranyBbKwh(ukuranyBbKwh.getSelectedItem().toString());
        mybarangbukti.setAmpereBbKwh(ampereBbKwh.getText().toString());
        mybarangbukti.setStandBbKWh(standBbKWh.getText().toString());

        mybarangbukti.setTypeBbKvarh(typeBbKvarh.getSelectedItem().toString());
        mybarangbukti.setMerkBbKvarh(merkBbKvarh.getSelectedItem().toString());
        mybarangbukti.setTaripBbKvarh(taripBbKvarh.getText().toString());
        mybarangbukti.setNopabrikBbKvarh(nopabrikBbKvarh.getText().toString());
        mybarangbukti.setFaktormeterBbKvarh(faktormeterBbKvarh.getText().toString());
        mybarangbukti.setUkuranxBbKvarh(ukuranxBbKvarh.getSelectedItem().toString());
        mybarangbukti.setUkuranyBbKvarh(ukuranyBbKvarh.getSelectedItem().toString());
        mybarangbukti.setAmpereBbKvarh(ampereBbKvarh.getText().toString());
        mybarangbukti.setStandBbKvarh(standBbKvarh.getText().toString());

        mybarangbukti.setTypeBbKva(typeBbKva.getSelectedItem().toString());
        mybarangbukti.setMerkBbKva(merkBbKva.getSelectedItem().toString());
        mybarangbukti.setTaripBbKva(taripBbKva.getText().toString());
        mybarangbukti.setNopabrikBbKva(nopabrikBbKva.getText().toString());
        mybarangbukti.setFaktormeterBbKva(faktormeterBbKva.getText().toString());
        mybarangbukti.setUkuranxBbKva(ukuranxBbKva.getSelectedItem().toString());
        mybarangbukti.setUkuranyBbKva(ukuranyBbKva.getSelectedItem().toString());
        mybarangbukti.setAmpereBbKva(ampereBbKva.getText().toString());

        mybarangbukti.setNamaBbPembatas(nama_bb_pembatas.getText().toString());
        mybarangbukti.setTipeukuranBbPembatas(taripBbPembatas.getText().toString());
        mybarangbukti.setUkuranxBbPembatas(ukuranxBbPembatas.getSelectedItem().toString());
        mybarangbukti.setUkuranyBbPembatas(ukuranyBbPembatas.getSelectedItem().toString());

        mybarangbukti.setMerkBbTrafo(merkBbTrafo.getSelectedItem().toString());
        mybarangbukti.setTypeBbTrafo(typeBbTrafo.getSelectedItem().toString());
        mybarangbukti.setNopabrikBbTrafo(nopabrikBbTrafo.getText().toString());
        mybarangbukti.setRatioBbTrafo(ratioBbTrafo.getText().toString());

        mybarangbukti.setJeniskabelBbKabel(jenis_bb_kabel.getText().toString());
        mybarangbukti.setDiameterxBbKabel(diameterxBbKabel.getText().toString());
        mybarangbukti.setDiameteryBbKabel(diameteryBbKabel.getText().toString());
        mybarangbukti.setPanjangBbKabel(panjangBbKabel.getText().toString());

        mybarangbukti.setMerkBbKontaktor(merkBbKontaktor.getSelectedItem().toString());
        mybarangbukti.setTypeBbKontaktor(typeBbKontaktor.getSelectedItem().toString());
        mybarangbukti.setNopabrikBbKontaktor(nopabrikBbKontaktor.getText().toString());
        mybarangbukti.setTahunBbTrafo(tahunBbTrafo.getText().toString());
        mybarangbukti.setFasaBbTrafo(fasaBbTrafo.getSelectedItem().toString());

        mybarangbukti.setJenisBbFuse(jenisBbFuse.getText().toString());
        mybarangbukti.setMerkBbFuse(merkBbFuse.getSelectedItem().toString());
        mybarangbukti.setTypeBbFuse(typeBbFuse.getSelectedItem().toString());
        mybarangbukti.setNopabrikBbFuse(nopabrikBbFuse.getText().toString());

        mybarangbukti.setUkuranBbGembok(ukuranBbGembok.getSelectedItem().toString());

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
        mypelanggan.setTrafo(pemeriksaan.getString("trafo",null));
        mypelanggan.setTarif(pemeriksaan.getString("tarif",null));
        mypelanggan.setNama_penghuni(pemeriksaan.getString("nama_penghuni",null));
        mypelanggan.setAlamat_penghuni(pemeriksaan.getString("alamat_penghuni",null));
        mypelanggan.setNomor_identitas(pemeriksaan.getString("nomor_identitas",null));
        mypelanggan.setPekerjaan_penghuni(pemeriksaan.getString("pekerjaan_penghuni",null));
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

        mypetugas.setNosurat(pemeriksaan.getString("nomorsurat", null));
        mypetugas.setTglsurat(pemeriksaan.getString("tanggalsurat", null));

        mypetugas.setNomorsurat_tugas(pemeriksaan.getString("nomorsurat_tugas", null));
        mypetugas.setTanggalsurat_tugas(pemeriksaan.getString("tanggalsurat_tugas", null));

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













