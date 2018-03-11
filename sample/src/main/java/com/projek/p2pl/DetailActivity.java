package com.projek.p2pl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.projek.p2pl.model.m_barangbukti;
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_periksa;
import com.projek.p2pl.model.m_petugas;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.card_view)
    CardView cardView;

    @Bind(R.id.nama)
    TextView nama;
    @Bind(R.id.t_alamat)
    TextView tAlamat;
    @Bind(R.id.t_nogardu)
    TextView tNogardu;
    @Bind(R.id.t_tarif)
    TextView tTarif;
    @Bind(R.id.t_deskripsi)
    TextView tDeskripsi;
    @Bind(R.id.t_tindakan)
    TextView tTindakan;
    @Bind(R.id.t_namapetugas)
    TextView tNamapetugas;
//    private Realm mRealm;


    String s_id, s_nama, s_alamat, s_nogardu, s_tarif, s_deskripsi, s_tindakan, s_namapetugas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
//        mRealm = Realm.getInstance(getApplicationContext());

        Intent i = getIntent();
        s_id = i.getStringExtra("id");
        s_nama = i.getStringExtra("nama");
        s_alamat = i.getStringExtra("alamat");
        s_nogardu = i.getStringExtra("nogardu");
        s_tarif = i.getStringExtra("tarif");
        s_deskripsi = i.getStringExtra("deskripsi");
        s_tindakan = i.getStringExtra("tindakan");
        s_namapetugas = i.getStringExtra("petugas");

        nama.setText(s_nama.toString());
        tAlamat.setText(s_alamat.toString());
        tNogardu.setText(s_nogardu.toString());
        tTarif.setText(s_tarif.toString());
        tDeskripsi.setText(s_deskripsi.toString());
        tTindakan.setText(s_tindakan.toString());
        tNamapetugas.setText(s_namapetugas.toString());


//        Toast.makeText(this, "Nama "+m_pelanggan.getNama().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Nama "+m_petugas.getNama().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Hasil "+m_periksa.getHasil().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Gardu "+m_barangbukti.getGarduBb(), Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.p_dokumenapa1)
    void onPDokumenapa1Click() {
        //TODO implement
        Toast.makeText(this, "Print Dokumen 1", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.p_dokumenapa1)
    boolean onPDokumenapa1LongClick() {
        //TODO implement
        postData("http://10.3.141.1/digitalisasi_rest/index.php/RestPemeriksaan_2");
        Toast.makeText(this, "Print Dokumen pemeriksaan", Toast.LENGTH_SHORT).show();
        return true;
    }

    @OnClick(R.id.p_dokumenapa2)
    void onPDokumenapa2Click() {
        //TODO implement

        Toast.makeText(this, "Print Dokumen 2", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.p_dokumenapa2)
    boolean onPDokumenapa2LongClick() {
        //TODO implement
        return true;
    }




    private void postData(final String url){
//        final SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Realm mRealm;
                mRealm = Realm.getInstance(getApplicationContext());
                m_pelanggan m_pelanggan;
                m_periksa m_periksa;
                m_petugas m_petugas;
                m_barangbukti m_barangbukti;

                m_pelanggan = mRealm.where(m_pelanggan.class).equalTo("id", s_id).findFirst();
                mRealm.beginTransaction();
                mRealm.commitTransaction();

                m_petugas = mRealm.where(m_petugas.class).equalTo("id", s_id).findFirst();
                mRealm.beginTransaction();
                mRealm.commitTransaction();

                m_periksa = mRealm.where(m_periksa.class).equalTo("id", s_id).findFirst();
                mRealm.beginTransaction();
                mRealm.commitTransaction();

                m_barangbukti = mRealm.where(m_barangbukti.class).equalTo("id", s_id).findFirst();
                mRealm.beginTransaction();
                mRealm.commitTransaction();
//                File file1 = new File(pemeriksaan.getString("file1",null));
//                File file2 = new File(pemeriksaan.getString("file2",null));
//                File file3 = new File(pemeriksaan.getString("file3",null));
//                File file4 = new File(pemeriksaan.getString("file4",null));
//                File file5 = new File(pemeriksaan.getString("file5",null));
//                File file6 = new File(pemeriksaan.getString("file6",null));

//                String content_type = getMimeType(file1.getPath());

                OkHttpClient client = new OkHttpClient();
//                String url = "http://192.168.1.69:81/p2tl_service/petugas";

                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("rayon", "Tulung" )
                        .addFormDataPart("alamat", "Jl. Klaten" )
                        .addFormDataPart("cabang", "Klaten" )
                        .addFormDataPart("wilayah", "Jateng" )
                        .addFormDataPart("tanggal", "2018-01-01" )
                        // petugas
                        .addFormDataPart("nomor_surat", m_petugas.getNomorsurat() )
                        .addFormDataPart("tanggal_nomorsurat", m_petugas.getTanggalsurat() )
                        .addFormDataPart("nama", m_petugas.getNama() )
                        .addFormDataPart("no_induk", m_petugas.getNoinduk() )
                        .addFormDataPart("jabatan", m_petugas.getJabatan() )
                        .addFormDataPart("nama_vendor", m_petugas.getNama_vendor() )
                        .addFormDataPart("no_induk_vendor", m_petugas.getNoinduk_vendor() )
                        .addFormDataPart("jabatan_vendor", m_petugas.getJabatan_vendor() )
                        .addFormDataPart("nomor_surat_polri", m_petugas.getNomor_surat_porli() )
                        .addFormDataPart("tanggal_suratpolri", m_petugas.getTanggal_suratpolri() )
                        .addFormDataPart("nama_polri1", m_petugas.getPetugas1() )
                        .addFormDataPart("nip_polri1", m_petugas.getNippetugas1().toString() )
                        .addFormDataPart("jabatan_polri1", m_petugas.getJabatanpetugas1() )
                        .addFormDataPart("nama_polri2", m_petugas.getPetugas2() )
                        .addFormDataPart("nip_polri2", m_petugas.getNippetugas2().toString() )
                        .addFormDataPart("jabatan_polri2", m_petugas.getJabatanpetugas2() )
                        // pelanggan
                        .addFormDataPart("terdaftar", "Ya" )
                        .addFormDataPart("id_pelanggan", m_pelanggan.getId_pelanggan() )
                        .addFormDataPart("nama_pelanggan", m_pelanggan.getNama() )
                        .addFormDataPart("alamat_pelanggan", m_pelanggan.getAlamat() )
                        .addFormDataPart("no_gardu", m_pelanggan.getNo_gardu() )
                        .addFormDataPart("tarif", m_pelanggan.getTarif() )
                        .addFormDataPart("peruntukan", "untuk" )
                        .addFormDataPart("nama_penghuni", m_pelanggan.getNama_penghuni() )
                        .addFormDataPart("alamat_penghuni", m_pelanggan.getAlamat_penghuni() )
                        .addFormDataPart("noktp_penghuni", m_pelanggan.getNoktp_penghuni() )
                        .addFormDataPart("nama_saksi", m_pelanggan.getNama_saksi() )
                        .addFormDataPart("alamat_saksi", m_pelanggan.getAlamat_saksi() )
                        .addFormDataPart("nomor_identitas", m_pelanggan.getNomor_identitas() )
                        .addFormDataPart("pekerjaan_saksi", m_pelanggan.getPekerjaan_saksi() )
                        .addFormDataPart("foto", "" )
                        .addFormDataPart("status", m_pelanggan.getStatus() )
                        .addFormDataPart("lat", m_pelanggan.getLat().toString() )
                        .addFormDataPart("long", m_pelanggan.getLng().toString() )
                        // periksa
                        .addFormDataPart("kwh_meter_1a", m_periksa.getKwh_meter_1a() )
                        .addFormDataPart("merk_1a", m_periksa.getMerk_1a() )
                        .addFormDataPart("tahun_1a", m_periksa.getTahun_1a() )
                        .addFormDataPart("putaran_1a", m_periksa.getPutaran_1a() )
                        .addFormDataPart("kondisi_visual_1a", m_periksa.getKondisi_visual_1a() )
                        .addFormDataPart("segel_terpasang_1b", m_periksa.getSegel_terpasang_1b() )
                        .addFormDataPart("jenis_1b", m_periksa.getJenis_1b() )
                        .addFormDataPart("acuan_1b", m_periksa.getAcuan_1b() )
                        .addFormDataPart("tahun_1b", m_periksa.getTahun_1b() )
                        .addFormDataPart("kondisi_visual_1b", m_periksa.getKondisi_visual_1b() )
                        .addFormDataPart("kapasitas_2a", m_periksa.getKapasitas_2a() )
                        .addFormDataPart("merk_2a", m_periksa.getMerk_2a() )
                        .addFormDataPart("segel_terpasang_2b", m_periksa.getSegel_terpasang_2b() )
                        .addFormDataPart("jenis_2b", m_periksa.getJenis_2b() )
                        .addFormDataPart("acuan_2b", m_periksa.getAcuan_2b() )
                        .addFormDataPart("tahun_2b", m_periksa.getTahun_2b() )
                        .addFormDataPart("papan_meter_3a", m_periksa.getPapan_meter_3a() )
                        .addFormDataPart("jenis_3a", m_periksa.getJenis_3a() )
                        .addFormDataPart("kondisi_visual_3a", m_periksa.getKondisi_visual_3a() )
                        .addFormDataPart("segel_terpasang_3a", m_periksa.getSegel_terpasang_3a() )
                        .addFormDataPart("jenis_3a2", m_periksa.getJenis_3a2() )
                        .addFormDataPart("acuan_3a", m_periksa.getAcuan_3a() )
                        .addFormDataPart("tahun_3a", m_periksa.getTahun_3a() )
                        .addFormDataPart("sesuai", m_periksa.getSesuai() )
                        .addFormDataPart("hasil", m_periksa.getHasil() )
                        .addFormDataPart("pelanggaran", m_periksa.getPelanggaran() )
                        .addFormDataPart("deskripsi_pelanggaran", m_periksa.getDeskripsi_pelanggaran() )
                        .addFormDataPart("tindakan", m_periksa.getTindakan() )
                        // barang bukti
                        .addFormDataPart("type_kwh", m_barangbukti.getMerkBbKwh() )
                        .addFormDataPart("tarif_kwh", m_barangbukti.getTaripBbKwh() )
                        .addFormDataPart("no_pabrik_kwh", m_barangbukti.getNopabrikBbKwh() )
                        .addFormDataPart("tahun_kwh", "durung" )
                        .addFormDataPart("faktor_meter_kwh", m_barangbukti.getFaktormeterBbKwh() )
                        .addFormDataPart("ukuran_kwh", m_barangbukti.getUkuranxBbKwh().toString() + "x" + m_barangbukti.getUkuranyBbKwh().toString() )
                        .addFormDataPart("constanta_kwh", m_barangbukti.getAmpereBbKwh() )
                        .addFormDataPart("stand_meter_kwh", m_barangbukti.getStandBbKWh() )
                        .addFormDataPart("type_kvarh", m_barangbukti.getMerkBbKvarh() )
                        .addFormDataPart("tarif_kvarh", m_barangbukti.getTaripBbKvarh() )
                        .addFormDataPart("no_pabrik_kvarh", m_barangbukti.getNopabrikBbKvarh() )
                        .addFormDataPart("tahun_kvarh", "durung" )
                        .addFormDataPart("faktor_meter_kvarh", m_barangbukti.getFaktormeterBbKvarh() )
                        .addFormDataPart("ukuran_kvarh", m_barangbukti.getUkuranxBbKvarh().toString() + "x" + m_barangbukti.getUkuranyBbKvarh().toString() )
                        .addFormDataPart("constanta_kvarh", m_barangbukti.getAmpereBbKvarh() )
                        .addFormDataPart("stand_meter_kvarh", m_barangbukti.getStandBbKvarh() )
                        .addFormDataPart("type_kva", m_barangbukti.getMerkBbKva() )
                        .addFormDataPart("tarif_kva", m_barangbukti.getTaripBbKva() )
                        .addFormDataPart("no_pabrik_kva", m_barangbukti.getNopabrikBbKva() )
                        .addFormDataPart("tahun_kva", "durung" )
                        .addFormDataPart("faktor_meter_kva", m_barangbukti.getFaktormeterBbKva() )
                        .addFormDataPart("ukuran_kva", m_barangbukti.getUkuranxBbKva().toString() + "x" + m_barangbukti.getUkuranyBbKva().toString() )
                        .addFormDataPart("constanta_kva", m_barangbukti.getAmpereBbKva() )
                        .addFormDataPart("nama_pembatas", "durung" )
                        .addFormDataPart("type_ukuran_pembatas", "durung" )
                        .addFormDataPart("ukuran_pembatas", m_barangbukti.getUkuranxBbPembatas().toString() + "x" + m_barangbukti.getUkuranxBbPembatas().toString() )
                        .addFormDataPart("type_trafo", m_barangbukti.getMerkBbTrafo() )
                        .addFormDataPart("no_pabrik_trafo", m_barangbukti.getNopabrikBbTrafo() )
                        .addFormDataPart("ratio_trafo", m_barangbukti.getRatioBbTrafo() )
                        .addFormDataPart("jenis_kabel_sadapan", "durung" )
                        .addFormDataPart("diameter_sadapan", m_barangbukti.getDiameterxBbKabel().toString() + "x" +  m_barangbukti.getDiameteryBbKabel().toString())
                        .addFormDataPart("panjang_sadapan", m_barangbukti.getPanjangBbKabel() )
                        .addFormDataPart("tipe_kontaktor", m_barangbukti.getMerkBbKontaktor() )
                        .addFormDataPart("no_pabrik_kontaktor", m_barangbukti.getNopabrikBbKontaktor() )
                        .addFormDataPart("fasa_kontaktor", m_barangbukti.getFasaBbTrafo() )
                        .addFormDataPart("jenis_fuse", m_barangbukti.getJenisBbFuse() )
                        .addFormDataPart("type_fuse", m_barangbukti.getMerkBbFuse() )
                        .addFormDataPart("no_pabrik_fuse", m_barangbukti.getNopabrikBbFuse() )
                        .addFormDataPart("ukuran_gembok", m_barangbukti.getUkuranBbGembok() )
                        .addFormDataPart("segel_gardu", m_barangbukti.getGarduBb() )
                        .addFormDataPart("segel_kontak", m_barangbukti.getKotakappBb() )
                        .addFormDataPart("segel_pengukur", m_barangbukti.getPengukurBb() )
                        .addFormDataPart("segel_pembatas", m_barangbukti.getPembatasBb() )
                        .addFormDataPart("segel_bantu", m_barangbukti.getBantupengukuranBb() )
                        .addFormDataPart("segel_pelindung", m_barangbukti.getPelindungBb() )
                        // files
//                        .addFormDataPart("file1","file1_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file1))
//                        .addFormDataPart("file2","file2_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file2))
//                        .addFormDataPart("file3","file3_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file3))
//                        .addFormDataPart("file4","file4_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file4))
//                        .addFormDataPart("file5","file5_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file5))
//                        .addFormDataPart("file6","file6_" + file1.getName(), RequestBody.create(MediaType.parse(content_type), file6))
                        .build();


                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    Log.d("tesa", jsonData);

//                    progressDialog.dismiss();
                } catch (IOException e) {
                    Log.d("OKHTTP3", "Error : " + e.toString());
                    e.printStackTrace();
                }

            }
        });

        t.start();
    }
}