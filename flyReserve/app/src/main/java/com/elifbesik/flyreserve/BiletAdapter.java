package com.elifbesik.flyreserve;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class BiletAdapter extends RecyclerView.Adapter<BiletAdapter.BiletHolder> {
    private ArrayList<Bilet> biletList;
    private Context context;
    private OnItemClickListener listener;

    public BiletAdapter(ArrayList<Bilet> biletList, Context context) {
        this.biletList = biletList;
        this.context = context;
    }
    @NonNull
    @Override
    public BiletHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bilet_item,parent,false);
        return new BiletHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull  BiletHolder holder, int position) {
         Bilet bilet =biletList.get(position);
         holder.setData(bilet);
    }
    @Override
    public int getItemCount() {
        return biletList.size();
    }
    class BiletHolder extends RecyclerView.ViewHolder{
        TextView txtAd,txtSoyad,txtUlke;

        public BiletHolder(@NonNull View itemView){
            super(itemView);
            txtAd=(TextView)itemView.findViewById(R.id.bilet_item_textViewYolcuAdi);
            txtSoyad=(TextView)itemView.findViewById(R.id.bilet_item_textViewYolcuSoyadi);
            txtUlke=(TextView)itemView.findViewById(R.id.bilet_item_textViewUlke);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getAdapterPosition();
                    if(listener!=null && position !=RecyclerView.NO_POSITION )
                        listener.onItemClick(biletList.get(position));
                }
            });
        }
        public void setData(Bilet bilet){
            this.txtAd.setText(bilet.getIsim());
            this.txtSoyad.setText(bilet.getSoyisim());
            //this.txtTarih.setText(bilet.getTarih());
            //this.txtTarih2.setText(bilet.getTarih2());
            this.txtUlke.setText(bilet.getUlke());
            //this.txtHavaalani.setText(bilet.getHavaalani());
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Bilet bilet);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener ;
    }
}
