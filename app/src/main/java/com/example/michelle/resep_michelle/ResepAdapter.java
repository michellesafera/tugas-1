package com.example.michelle.resep_michelle;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Michelle on 9/23/2017.
 */
public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepHolder> {
    private String mJudul[];
    private String mKeterangan[];
    private ResepListener mListener;

    public ResepAdapter(String judul[], String ket[], ResepListener listener){
        mJudul = judul;
        mKeterangan = ket;
        mListener = listener;
    }

    interface ResepListener{
        void onClick(int position);
    }

    @Override
    public ResepHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_resep, parent, false);
        return new ResepHolder(view);
    }

    @Override
    public void onBindViewHolder(ResepHolder holder, int position) {
        String judul = mJudul[position];
        String ket = mKeterangan[position];
        holder.setResep(judul,ket);
    }

    @Override
    public int getItemCount() {
        return mJudul.length;
    }

    public String getJudul(int position){
        return mJudul[position];
    }

    public class ResepHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView1;
        private TextView textView2;
        public ResepHolder(View itemView){
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.judulResep);
            textView2 = (TextView) itemView.findViewById(R.id.keterangan);
            itemView.setOnClickListener(this);
        }
        public void setResep(String judul, String ket){
            textView1.setText(judul);
            textView2.setText(ket);
        }

        @Override
        public void onClick(View v){
            mListener.onClick(getAdapterPosition());
        }
    }
}
