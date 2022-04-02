package com.example.facomplay.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.Musica;

public class ProfileFragment extends Fragment {

    View v;
    ImageView imagem_perfil;
    TextView nome_usuario, tipo_usuario;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_profile, container, false);
        imagem_perfil = v.findViewById(R.id.imagem_perfil);
        imagem_perfil.setImageResource(R.drawable.pato);
        nome_usuario = v.findViewById(R.id.nomeUsuario);
        nome_usuario.setText("PatuRoco");
        tipo_usuario = v.findViewById(R.id.tipoUsuario);
        tipo_usuario.setText("Usuário comum");

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}