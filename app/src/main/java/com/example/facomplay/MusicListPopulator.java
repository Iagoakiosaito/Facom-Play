package com.example.facomplay;

import com.example.facomplay.fragments.Home.Musica;

import java.util.ArrayList;

public class MusicListPopulator {

    public int[] capas = {R.drawable.nego_drama, R.drawable.desabafo, R.drawable.munra, R.drawable.oitavo, R.drawable.ponta, R.drawable.vai_baby,
            R.drawable.oooh, R.drawable.leal, R.drawable.favela_sinistra, R.drawable.pseudo, R.drawable.ainda_gosto_dela, R.drawable.blinding,
            R.drawable.earf, R.drawable.fuego, R.drawable.buque};

    public int[] musicas = {R.raw.nego_drama, R.raw.deixa_eu_dizer, R.raw.munra, R.raw.oitavo_anjo, R.raw.ponta_de_lanca, R.raw.vai_baby,
            R.raw.oooh, R.raw.leal, R.raw.favela_sinistra, R.raw.pseudosocial, R.raw.ainda_gosto_dela, R.raw.blinding_lights,
            R.raw.earfquake, R.raw.fuego, R.raw.buque_de_flores};

    public ArrayList<Musica> musicasList = new ArrayList<>();

    String[] nomesCantores;
    String[] nomesMusicas;

    public MusicListPopulator() {

    }

    public ArrayList<Musica> gerarListaDeMusicas(String[] nomesCantores, String[] nomesMusicas){
        setNomesCantores(nomesCantores);
        setNomesMusicas(nomesMusicas);
        this.nomesMusicas = nomesMusicas;
        int i = 0;
        for (String cantor: nomesCantores) {
            musicasList.add(new Musica(nomesMusicas[i], cantor, capas[i], i));
            i++;
        }
        return musicasList;
    }

    public String[] getNomesCantores() {
        return nomesCantores;
    }

    public void setNomesCantores(String[] nomesCantores) {
        this.nomesCantores = nomesCantores;
    }

    public String[] getNomesMusicas() {
        return nomesMusicas;
    }

    public void setNomesMusicas(String[] nomesMusicas) {
        this.nomesMusicas = nomesMusicas;
    }

    public int[] getCapas() {
        return capas;
    }

    public void setCapas(int[] capas) {
        this.capas = capas;
    }

    public int[] getMusicas() {
        return musicas;
    }

    public void setMusicas(int[] musicas) {
        this.musicas = musicas;
    }
}
