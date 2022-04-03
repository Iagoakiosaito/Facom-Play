package com.example.facomplay;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;

public class MyApplication extends Application {

    private boolean isPlayingMusic = false;
    private MediaPlayer mediaPlayer = null;

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayerEntrada) {
        this.mediaPlayer = mediaPlayerEntrada;
    }

    public boolean getIsPlayingMusic() {
        return this.isPlayingMusic;
    }

    public void setPlayingMusic(boolean playingMusic) {
        this.isPlayingMusic = playingMusic;
    }

    public void tocarMusica(Context context, int[] musicas, int indexMusica){
        mediaPlayer = MediaPlayer.create(context, musicas[indexMusica]);
        mediaPlayer.start();
    }

    public void pararMusica(){
        mediaPlayer.stop();
    }

}