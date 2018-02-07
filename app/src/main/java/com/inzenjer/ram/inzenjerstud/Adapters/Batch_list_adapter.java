package com.inzenjer.ram.inzenjerstud.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.api.Batch;
import com.inzenjer.ram.inzenjerstud.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ram on 07-02-2018.
 */

public class Batch_list_adapter extends RecyclerView.Adapter<Batch_list_adapter.mViewHolder> {
    List<com.inzenjer.ram.inzenjerstud.Models.Batch>batch_list = new ArrayList<>();

    public Batch_list_adapter(List<com.inzenjer.ram.inzenjerstud.Models.Batch> batch_list) {
        this.batch_list = batch_list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.batch_inflator,parent,false);
        return new mViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        com.inzenjer.ram.inzenjerstud.Models.Batch b = batch_list.get(position);
        holder.batch_no.setText(b.getBatch_no());
        holder.project_name.setText(b.getProject_name());
        holder.college_name.setText(b.getCollege_name());
        holder.batch_name.setText(b.getBatch_name());

    }

    @Override
    public int getItemCount() {
        return batch_list.size();
    }

    class  mViewHolder extends RecyclerView.ViewHolder{
TextView batch_no,batch_name,college_name,project_name;
        public mViewHolder(View itemView) {
            super(itemView);
            batch_name = itemView.findViewById(R.id.batch_name);
            batch_no = itemView.findViewById(R.id.batch_no);
            college_name = itemView.findViewById(R.id.college_name);
            project_name = itemView.findViewById(R.id.project_name);
        }
    }
}
