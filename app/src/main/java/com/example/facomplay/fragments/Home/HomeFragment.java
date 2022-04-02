package com.example.facomplay.fragments.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.adapter.MusicaRecyclerAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View v;
    String nomesCantores[], nomesMusicas[];

    int capas[] = {R.drawable.nego_drama, R.drawable.desabafo, R.drawable.munra, R.drawable.oitavo, R.drawable.ponta, R.drawable.vai_baby,
            R.drawable.oooh, R.drawable.leal, R.drawable.favela_sinistra, R.drawable.ponta, R.drawable.ainda_gosto_dela, R.drawable.blinding,
            R.drawable.earf, R.drawable.fuego, R.drawable.buque};

    private ArrayList<Musica> musicaArrayList;
    private RecyclerView recyclerView;


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.recyclerViewMusicas);
        MusicaRecyclerAdapter adapter = new MusicaRecyclerAdapter(musicaArrayList);
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
            musicaArrayList.add(new Musica("Teste", cantor, capas[i]));
            i++;
        }
//        musicaArrayList.add(new Musica("Teste", "TesteCantor", 2));
//        musicaArrayList.add(new Musica("Teste2", "TesteCantor2", 22));
//        musicaArrayList.add(new Musica("Teste3", "TesteCantor3", 23));
//        musicaArrayList.add(new Musica("Teste4", "TesteCantor4", 24));
//        musicaArrayList.add(new Musica("Teste5", "TesteCantor5", 25));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));
//        musicaArrayList.add(new Musica("Teste6", "TesteCantor6", 26));


    }




}