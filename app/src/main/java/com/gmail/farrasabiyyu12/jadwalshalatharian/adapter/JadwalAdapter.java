package com.gmail.farrasabiyyu12.jadwalshalatharian.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jadwalshalatharian.R;
import com.gmail.farrasabiyyu12.jadwalshalatharian.model.ItemsItem;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyViewHolder> {
    List<ItemsItem> mItemList;

    public JadwalAdapter(List<ItemsItem> ItemList) {
        mItemList = ItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jadwal_list_layout, viewGroup, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(JadwalAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_info_shubuh_adapter.setText(mItemList.get(i).getFajr());
        myViewHolder.tv_info_dzuhur_adapter.setText(mItemList.get(i).getDhuhr());
        myViewHolder.tv_info_ashar_adapter.setText(mItemList.get(i).getAsr());
        myViewHolder.tv_info_maghrib_adapter.setText(mItemList.get(i).getMaghrib());
        myViewHolder.tv_info_isya_adapter.setText(mItemList.get(i).getIsha());
        myViewHolder.tv_tanggal.setText("Date For " + mItemList.get(i).getDateFor());

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_tanggal, tv_info_shubuh_adapter, tv_info_dzuhur_adapter, tv_info_ashar_adapter, tv_info_maghrib_adapter,
                tv_info_isya_adapter;

        public MyViewHolder(View itemView) {
            super(itemView);

            //TODO Bind TextView
            tv_info_shubuh_adapter = itemView.findViewById(R.id.tv_info_shubuh_adapter);
            tv_info_dzuhur_adapter = itemView.findViewById(R.id.tv_info_dzuhur_adapter);
            tv_info_ashar_adapter = itemView.findViewById(R.id.tv_info_ashar_adapter);
            tv_info_maghrib_adapter = itemView.findViewById(R.id.tv_info_maghrib_adapter);
            tv_info_isya_adapter = itemView.findViewById(R.id.tv_info_isya_adapter);
            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
        }
    }
}
