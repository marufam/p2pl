package com.projek.p2pl.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

import io.realm.RealmChangeListener;
import io.realm.RealmResults;


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
