package com.example.facomplay.fragments.Home;

import android.media.Image;

public class Musica {
    private String nomeMusica;
    private String nomeCantor;
    private int fotoMusica;

    public Musica(String nomeMusica, String nomeCantor, int fotoMusica) {
        this.nomeMusica = nomeMusica;
        this.nomeCantor = nomeCantor;
        this.fotoMusica = fotoMusica;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public int getFotoMusica() {
        return fotoMusica;
    }

    public void setFotoMusica(int fotoMusica) {
        this.fotoMusica = fotoMusica;
    }
}
