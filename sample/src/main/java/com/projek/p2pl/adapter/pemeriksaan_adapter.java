package com.projek.p2pl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projek.p2pl.R;
import com.projek.p2pl.model.m_pelanggan;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;


public class pemeriksaan_adapter extends RecyclerView.Adapter<pemeriksaan_adapter.ViewHolder> implements RealmChangeListener {

    private RealmResults<m_pelanggan> items;
    Context a;

    public pemeriksaan_adapter(RealmResults<m_pelanggan> items, Context a) {
        this.items = items;
        items.addChangeListener(this);
        this.a = a;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_pemeriksaan,viewGroup,false);
        return new pemeriksaan_adapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final m_pelanggan model = items.get(i);
        final String nama = model.getNama();
        final Double lat = model.getLat();
        final Double lng = model.getLng();
        viewHolder.nama.setText(nama+""+lat.toString()+lng.toString());
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
        TextView nama;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama);
        }
    }
}
