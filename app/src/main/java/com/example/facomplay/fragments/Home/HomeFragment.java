package com.example.facomplay.fragments.Home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facomplay.MusicListPopulator;
import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.adapter.MusicaRecyclerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View v;
    private boolean isPlayingMusic = false;
    private MediaPlayer mediaPlayer = null;

    private MusicListPopulator populator = new MusicListPopulator();

    private ArrayList<Musica> musicasList;


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewMusicas);
        MusicaRecyclerAdapter adapter = criarAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] nomesCantores = getResources().getStringArray(R.array.nome_cantores);
        String[] nomesMusicas = getResources().getStringArray(R.array.nome_musicas);

        musicasList = populator.gerarListaDeMusicas(nomesCantores, nomesMusicas);

    }

    private MusicaRecyclerAdapter criarAdapter(){
        return new MusicaRecyclerAdapter(musicasList, musica -> {
            int musicaIndex = musica.getMusicaSom();
            int[] musicas = populator.getMusicas();
            if (isPlayingMusic) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(requireContext(), musicas[musicaIndex]);
            mediaPlayer.start();
            isPlayingMusic = true;

        });
    }


}