package com.projek.p2pl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_periksa;
import com.projek.p2pl.model.m_petugas;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import io.realm.RealmResults;

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

    String s_id, s_nama, s_alamat, s_nogardu, s_tarif, s_deskripsi, s_tindakan, s_namapetugas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

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
    }


    @OnClick(R.id.p_dokumenapa1)
    void onPDokumenapa1Click() {
        //TODO implement
        Toast.makeText(this, "Print Dokumen 1", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.p_dokumenapa1)
    boolean onPDokumenapa1LongClick() {
        //TODO implement
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
}
