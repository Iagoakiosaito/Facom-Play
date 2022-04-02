package com.example.facomplay.fragments.Home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.Musica;

import java.util.ArrayList;

public class MusicaRecyclerAdapter extends RecyclerView.Adapter<MusicaRecyclerAdapter.MyViewHolder> {

    private ArrayList<Musica> musicaArrayList;

    public MusicaRecyclerAdapter(ArrayList<Musica> musicaArrayList){
        this.musicaArrayList = musicaArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeMusicaText;
        private TextView nomeCantorText;
        private ImageView fotoMusica;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeMusicaText = itemView.findViewById(R.id.nomeMusica);
            nomeCantorText = itemView.findViewById(R.id.nomeCantor);
            fotoMusica = itemView.findViewById(R.id.fotoMusica);
        }
    }

    @NonNull
    @Override
    public MusicaRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_musica, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MusicaRecyclerAdapter.MyViewHolder holder, int position) {
        String nomeMusica = musicaArrayList.get(position).getNomeMusica();
        String nomeCantor = musicaArrayList.get(position).getNomeCantor();


        holder.nomeMusicaText.setText(nomeMusica);
        holder.nomeCantorText.setText(nomeCantor);
//        holder.fotoMusica.setImageResource(musicaArrayList.get(position).getFotoMusica());
    }

    @Override
    public int getItemCount() {
        return musicaArrayList.size();
    }
}
