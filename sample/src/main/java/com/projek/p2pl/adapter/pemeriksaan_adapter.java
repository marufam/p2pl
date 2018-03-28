package com.projek.p2pl.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.projek.p2pl.DetailActivity;
import com.projek.p2pl.R;
import com.projek.p2pl.model.m_barangbukti;
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_periksa;
import com.projek.p2pl.model.m_petugas;

import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class pemeriksaan_adapter extends RecyclerView.Adapter<pemeriksaan_adapter.ViewHolder> implements RealmChangeListener {

    private RealmResults<m_pelanggan> items;
    private RealmResults<m_petugas> mypetugas;
    private RealmResults<m_periksa> myperiksa;
    private RealmResults<m_barangbukti>  mybarangbukti;
    Context a;

    public pemeriksaan_adapter(RealmResults<m_pelanggan> items, RealmResults<m_petugas> mypetugas, RealmResults<m_periksa> myperiksa, RealmResults<m_barangbukti> mybarangbukti,  Context a) {
        this.items = items;
        this.mypetugas = mypetugas;
        this.myperiksa = myperiksa;
        this.mybarangbukti = mybarangbukti;
        items.addChangeListener(this);
        this.a = a;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_pemeriksaan,viewGroup,false);
        return new pemeriksaan_adapter.ViewHolder(itemView);
    }

    private void postData(final String url, final String s_id){
//        final SharedPreferences pemeriksaan = getContext().getSharedPreferences("pemeriksaan", 0);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Realm mRealm;
                mRealm = Realm.getInstance(a);
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
                String terdaftar = "";
                if(m_pelanggan.getTerdaftar() == null){
                    terdaftar =  "1";
                }
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        // petugas
                        .addFormDataPart("nomorsurat", m_petugas.getNosurat() )
                        .addFormDataPart("tanggal_sekarang", m_petugas.getTglsurat() )
                        .addFormDataPart("nomorsurat_tugas", m_petugas.getNomorsurat_tugas() )
                        .addFormDataPart("tanggal_nomorsurat_tugas", m_petugas.getTanggalsurat_tugas() )
                        .addFormDataPart("nama", m_petugas.getNama() )
                        .addFormDataPart("no_induk", m_petugas.getNoinduk() )
                        .addFormDataPart("jabatan", m_petugas.getJabatan() )
                        .addFormDataPart("rayon", "Tulung" )
                        .addFormDataPart("alamat", "Jl. Klaten" )
                        .addFormDataPart("cabang", "Klaten" )
                        .addFormDataPart("wilayah", "Jateng" )
                        .addFormDataPart("nama_vendor", m_petugas.getNama_vendor() )
                        .addFormDataPart("no_induk_vendor", m_petugas.getNoinduk_vendor() )
                        .addFormDataPart("jabatan_vendor", m_petugas.getJabatan_vendor() )
                        .addFormDataPart("nomor_surat_polri", m_petugas.getNomor_surat_porli() )
                        .addFormDataPart("tanggal_suratpolri", m_petugas.getTanggal_suratpolri() )
                        .addFormDataPart("nama_polri1", m_petugas.getPetugas1() )
                        .addFormDataPart("nip_polri1", m_petugas.getNippetugas1() )
                        .addFormDataPart("jabatan_polri1", m_petugas.getJabatanpetugas1() )
                        .addFormDataPart("nama_polri2", m_petugas.getPetugas2() )
                        .addFormDataPart("nip_polri2", m_petugas.getNippetugas2() )
                        .addFormDataPart("jabatan_polri2", m_petugas.getJabatanpetugas2() )

//                        .addFormDataPart("tanggal", "2018-01-01" )

                        // pelanggan

                        .addFormDataPart("terdaftar", terdaftar.toString() )
                        .addFormDataPart("id_pelanggan", m_pelanggan.getId_pelanggan() )
                        .addFormDataPart("nama_pelanggan", m_pelanggan.getNama() )
                        .addFormDataPart("alamat_pelanggan", m_pelanggan.getAlamat() )
                        .addFormDataPart("no_gardu", m_pelanggan.getNo_gardu() )
                        .addFormDataPart("trafo", m_pelanggan.getTrafo() )
                        .addFormDataPart("tarif", m_pelanggan.getTarif() )
                        .addFormDataPart("peruntukan", m_pelanggan.getPeruntukan() )
                        .addFormDataPart("nama_penghuni", m_pelanggan.getNama_penghuni() )
                        .addFormDataPart("alamat_penghuni", m_pelanggan.getAlamat_penghuni() )
                        .addFormDataPart("noktp_penghuni", m_pelanggan.getNomor_identitas() )
                        .addFormDataPart("pekerjaan_penghuni", m_pelanggan.getPekerjaan_penghuni() )
                        .addFormDataPart("nama_saksi1", m_pelanggan.getNama_saksi1() )
                        .addFormDataPart("no_ktp_saksi1", m_pelanggan.getNoktp_saksi1() )
                        .addFormDataPart("nama_saksi2", m_pelanggan.getNama_saksi2() )
                        .addFormDataPart("no_ktp_saksi2", m_pelanggan.getNoktp_saksi2() )
                        .addFormDataPart("foto", m_pelanggan.getFoto() )
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
                        .addFormDataPart("type_kwh", m_barangbukti.getTypeBbKwh() )
                        .addFormDataPart("merk_kwh", m_barangbukti.getMerkBbKwh() )
                        .addFormDataPart("tarif_kwh", m_barangbukti.getTaripBbKwh() )
                        .addFormDataPart("no_pabrik_kwh", m_barangbukti.getNopabrikBbKwh() )
                        .addFormDataPart("tahun_kwh", m_barangbukti.getTahunBbKwh() ) ////////////
                        .addFormDataPart("faktor_meter_kwh", m_barangbukti.getFaktormeterBbKwh() )
                        .addFormDataPart("ukuran_kwh", m_barangbukti.getUkuranxBbKwh().toString() + "x" + m_barangbukti.getUkuranyBbKwh().toString() )
                        .addFormDataPart("constanta_kwh", m_barangbukti.getAmpereBbKwh() )
                        .addFormDataPart("stand_meter_kwh", m_barangbukti.getStandBbKWh() )

                        .addFormDataPart("type_kvarh", m_barangbukti.getTypeBbKvarh() )
                        .addFormDataPart("merk_kvarh", m_barangbukti.getMerkBbKvarh() )
                        .addFormDataPart("tarif_kvarh", m_barangbukti.getTaripBbKvarh() )
                        .addFormDataPart("no_pabrik_kvarh", m_barangbukti.getNopabrikBbKvarh() )
                        .addFormDataPart("tahun_kvarh", m_barangbukti.getTahunBbKvarh() ) //////////////
                        .addFormDataPart("faktor_meter_kvarh", m_barangbukti.getFaktormeterBbKvarh() )
                        .addFormDataPart("ukuran_kvarh", m_barangbukti.getUkuranxBbKvarh().toString() + "x" + m_barangbukti.getUkuranyBbKvarh().toString() )
                        .addFormDataPart("constanta_kvarh", m_barangbukti.getAmpereBbKvarh() )
                        .addFormDataPart("stand_meter_kvarh", m_barangbukti.getStandBbKvarh() )

                        .addFormDataPart("type_kva", m_barangbukti.getTypeBbKva() )
                        .addFormDataPart("merk_kva", m_barangbukti.getMerkBbKva() )
                        .addFormDataPart("tarif_kva", m_barangbukti.getTaripBbKva() )
                        .addFormDataPart("no_pabrik_kva", m_barangbukti.getNopabrikBbKva() )
                        .addFormDataPart("tahun_kva", m_barangbukti.getTahunBbKva() ) ///////////////
                        .addFormDataPart("faktor_meter_kva", m_barangbukti.getFaktormeterBbKva() )
                        .addFormDataPart("ukuran_kva", m_barangbukti.getUkuranxBbKva().toString() + "x" + m_barangbukti.getUkuranyBbKva().toString() )
                        .addFormDataPart("constanta_kva", m_barangbukti.getAmpereBbKva() )

                        .addFormDataPart("nama_pembatas", m_barangbukti.getNamaBbPembatas() )
                        .addFormDataPart("type_ukuran_pembatas", m_barangbukti.getTipeukuranBbPembatas() )
                        .addFormDataPart("ukuran_pembatas", m_barangbukti.getUkuranxBbPembatas().toString() + "x" + m_barangbukti.getUkuranxBbPembatas().toString() )

                        .addFormDataPart("type_trafo", m_barangbukti.getTypeBbTrafo() )
                        .addFormDataPart("merk_trafo", m_barangbukti.getMerkBbTrafo() )
                        .addFormDataPart("no_pabrik_trafo", m_barangbukti.getNopabrikBbTrafo() )
                        .addFormDataPart("tahun_trafo", m_barangbukti.getTahunBbTrafo() )
                        .addFormDataPart("ratio_trafo", m_barangbukti.getRatioBbTrafo() )

                        .addFormDataPart("jenis_kabel_sadapan", m_barangbukti.getJeniskabelBbKabel() ) ////////////
                        .addFormDataPart("diameter_sadapan", m_barangbukti.getDiameterxBbKabel().toString() + "x" +  m_barangbukti.getDiameteryBbKabel().toString())
                        .addFormDataPart("panjang_sadapan", m_barangbukti.getPanjangBbKabel() )

                        .addFormDataPart("merk_kontaktor", m_barangbukti.getMerkBbKontaktor() )
                        .addFormDataPart("type_kontaktor", m_barangbukti.getTypeBbKontaktor() )
                        .addFormDataPart("no_pabrik_kontaktor", m_barangbukti.getNopabrikBbKontaktor() )
                        .addFormDataPart("tahun_kontaktor", m_barangbukti.getTahunBbKontaktor() )
                        .addFormDataPart("fasa_kontaktor", m_barangbukti.getFasaBbTrafo() )

                        .addFormDataPart("jenis_fuse", m_barangbukti.getJenisBbFuse() )
                        .addFormDataPart("type_fuse", m_barangbukti.getTypeBbFuse() )
                        .addFormDataPart("merk_fuse", m_barangbukti.getMerkBbFuse() )
                        .addFormDataPart("no_pabrik_fuse", m_barangbukti.getNopabrikBbFuse() )
                        .addFormDataPart("tahun_fuse", m_barangbukti.getTahunBbFuse() )

                        .addFormDataPart("ukuran_gembok", m_barangbukti.getUkuranBbGembok() )

                        .addFormDataPart("segel_gardu", m_barangbukti.getGarduBb() )
                        .addFormDataPart("segel_kontakapp", m_barangbukti.getKotakappBb() )
                        .addFormDataPart("segel_pengukur", m_barangbukti.getPengukurBb() )
                        .addFormDataPart("segel_pembatas", m_barangbukti.getPembatasBb() )
                        .addFormDataPart("segel_bantu", m_barangbukti.getBantupengukuranBb() )
                        .addFormDataPart("segel_pelindung", m_barangbukti.getPelindungBb() )

                        .addFormDataPart("key", "123456789" )
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

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final m_pelanggan model_pelanggan = items.get(i);
        final m_petugas model_petugas = mypetugas.get(i);
        final m_periksa model_periksa = myperiksa.get(i);
        final m_barangbukti model_barangbukti = mybarangbukti.get(i);

        final String nama = model_pelanggan.getNama();
        final String deskripsi = model_periksa.getDeskripsi_pelanggaran();
        final String petugas = model_petugas.getNama();
        final String tindakan = model_periksa.getTindakan();

        viewHolder.nama.setText(nama);
        viewHolder.tdeskripsi.setText((deskripsi));
        viewHolder.ttindakan.setText((tindakan));
        viewHolder.tpetugas.setText((petugas));

        viewHolder.syn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(a, "Syncronyse", Toast.LENGTH_SHORT).show();
                Log.d("P2TL - ID(Pel)",model_pelanggan.getId_pelanggan());
                postData("http://192.168.43.126/p2tl_service/petugas", model_pelanggan.getId());
//                Log.d("P2TL - Pelanggan",model_pelanggan.getNama());
//                Log.d("P2TL - Alamat Pel",model_pelanggan.getAlamat());
//                Log.d("P2TL - No.Gardu Pel",model_pelanggan.getNo_gardu());
//                Log.d("P2TL - ID(Pet)",model_petugas.getId());
//                Log.d("P2TL - ID(Per)",model_periksa.getId());
//                Log.d("P2TL - periksa",model_periksa.getMerk_1a());
//                Log.d("P2TL - ID(Ba)",model_barangbukti.getId());
//                Log.d("P2TL - barangbukti",model_barangbukti.getAmpereBbKwh());

            }
        });

        viewHolder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(a, DetailActivity.class);
                i.putExtra("id", model_pelanggan.getId().toString());
                i.putExtra("nama", model_pelanggan.getNama().toString());
                i.putExtra("alamat", model_pelanggan.getAlamat().toString());
                i.putExtra("nogardu", model_pelanggan.getNo_gardu().toString());
                i.putExtra("tarif", model_pelanggan.getTarif().toString());
                i.putExtra("deskripsi", deskripsi.toString());
                i.putExtra("tindakan", model_periksa.getTindakan().toString());
                i.putExtra("petugas", model_petugas.getNama().toString());

                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onChange() {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, tdeskripsi, tpetugas, ttindakan;
        Button syn, detail;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
            tdeskripsi = (TextView) itemView.findViewById(R.id.t_deskripsi);
            tpetugas = (TextView) itemView.findViewById(R.id.t_namapetugas);
            ttindakan = (TextView) itemView.findViewById(R.id.t_tindakan);
            syn = (Button) itemView.findViewById(R.id.syn);
            detail = (Button) itemView.findViewById(R.id.detail);
        }
    }
}
