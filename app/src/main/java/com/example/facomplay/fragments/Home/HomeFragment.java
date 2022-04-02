package com.example.facomplay.fragments.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.adapter.MusicaRecyclerAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View v;
    String[] nomesCantores, nomesMusicas;

    int[] capas = {R.drawable.nego_drama, R.drawable.desabafo, R.drawable.munra, R.drawable.oitavo, R.drawable.ponta, R.drawable.vai_baby,
            R.drawable.oooh, R.drawable.leal, R.drawable.favela_sinistra, R.drawable.ponta, R.drawable.ainda_gosto_dela, R.drawable.blinding,
            R.drawable.earf, R.drawable.fuego, R.drawable.buque};

    private ArrayList<Musica> musicaArrayList;


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewMusicas);
        MusicaRecyclerAdapter adapter = new MusicaRecyclerAdapter(musicaArrayList, musicas -> showToast(musicas.getNomeMusica() + " Foi clicada!"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nomesCantores = getResources().getStringArray(R.array.nome_cantores);
        nomesMusicas = getResources().getStringArray(R.array.nome_musicas);
        musicaArrayList = new ArrayList<>();
        int i = 0;
        for (String cantor: nomesCantores) {
            musicaArrayList.add(new Musica(nomesMusicas[i], cantor, capas[i]));
            i++;
        }
    }

    private void showToast(String mensagem){
        Toast.makeText(requireContext(), mensagem, Toast.LENGTH_SHORT).show();
    }




}