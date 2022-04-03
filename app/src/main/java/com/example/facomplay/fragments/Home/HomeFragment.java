package com.example.facomplay.fragments.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facomplay.MusicListPopulator;
import com.example.facomplay.MyApplication;
import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.adapter.MusicaRecyclerAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    View v;
//    private MediaPlayer mediaPlayer = null;

    private final MusicListPopulator populator = new MusicListPopulator();

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
            MyApplication isPlayingMusic = ((MyApplication) Objects.requireNonNull(getActivity()).getApplication());

            MyApplication mediaPlayer = ((MyApplication)getActivity().getApplication());

            if (isPlayingMusic.getIsPlayingMusic()) {
                mediaPlayer.pararMusica();
            }
            mediaPlayer.tocarMusica(requireContext(), musicas, musicaIndex);
            isPlayingMusic.setPlayingMusic(true);

        });
    }


}