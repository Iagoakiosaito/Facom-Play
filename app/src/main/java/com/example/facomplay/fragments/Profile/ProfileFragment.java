package com.example.facomplay.fragments.Profile;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.facomplay.MusicListPopulator;
import com.example.facomplay.MyApplication;
import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.Musica;
import com.example.facomplay.fragments.Profile.adapter.MusicaProfileRecyclerAdapter;

import java.util.ArrayList;
import java.util.Random;

public class ProfileFragment extends Fragment {

    private View v;

    private MediaPlayer mediaPlayerProfile = null;

    private ImageView imagem_perfil;
    private TextView nome_usuario, tipo_usuario, num_seguidores, num_seguindo;
    private ListView list;

    private MusicListPopulator populator = new MusicListPopulator();
    private ArrayList<Musica> musicasList;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_profile, container, false);
        definirElementos(v);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] nomesCantores = getResources().getStringArray(R.array.nome_cantores);
        String[] nomesMusicas = getResources().getStringArray(R.array.nome_musicas);

        musicasList = populator.gerarListaDeMusicas(nomesCantores, nomesMusicas);
    }

    private void definirElementos(@NonNull View v){
        Random numero_random = new Random();
        Integer seguidores = numero_random.nextInt(256);
        Integer seguindo = numero_random.nextInt(256);

        imagem_perfil = v.findViewById(R.id.imagem_perfil);
        imagem_perfil.setImageResource(R.drawable.pato);

        nome_usuario = v.findViewById(R.id.nomeUsuario);
        nome_usuario.setText("PatuRoco");
        nome_usuario =

        tipo_usuario = v.findViewById(R.id.tipoUsuario);
        tipo_usuario.setText(R.string.usuario_comum);

        num_seguidores = v.findViewById(R.id.num_seguidores);
        num_seguidores.setText(seguidores.toString());

        num_seguindo = v.findViewById(R.id.num_seguindo);
        num_seguindo.setText(seguindo.toString());

        RecyclerView recyclerView = v.findViewById(R.id.list_fav);
        MusicaProfileRecyclerAdapter adapter = criarAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private MusicaProfileRecyclerAdapter criarAdapter(){
        return new MusicaProfileRecyclerAdapter(musicasList, musica -> {
            int musicaIndex = musica.getMusicaSom();
            int[] musicas = populator.getMusicas();
            MyApplication isPlayingMusic = ((MyApplication)getActivity().getApplication());

            MyApplication mediaPlayer = ((MyApplication)getActivity().getApplication());

            if (isPlayingMusic.getIsPlayingMusic()) {
                mediaPlayer.pararMusica();
            }
            mediaPlayer.tocarMusica(requireContext(), musicas, musicaIndex);
            isPlayingMusic.setPlayingMusic(true);

        });
    }
}