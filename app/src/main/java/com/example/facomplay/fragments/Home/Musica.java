package com.example.facomplay.fragments.Home;

public class Musica {
    private String nomeMusica;
    private String nomeCantor;
    private int fotoMusica;
    private int musicaSom;

    public Musica(String nomeMusica, String nomeCantor, int fotoMusica, int musicaSom) {
        this.nomeMusica = nomeMusica;
        this.nomeCantor = nomeCantor;
        this.fotoMusica = fotoMusica;
        this.musicaSom = musicaSom;
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

    public int getMusicaSom() {
        return musicaSom;
    }

    public void setMusicaSom(int musicaSom) {
        this.musicaSom = musicaSom;
    }
}
