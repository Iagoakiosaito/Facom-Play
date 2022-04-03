package com.example.facomplay.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.facomplay.R;
import com.example.facomplay.fragments.Home.Musica;

import java.util.Random;

public class ProfileFragment extends Fragment {

    View v;
    ImageView imagem_perfil;
    TextView nome_usuario, tipo_usuario, num_seguidores, num_seguindo;
    ListView list;

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
    }

    private void definirElementos(@NonNull View v){
        Random numero_random = new Random();
        Integer seguidores = numero_random.nextInt(256);
        Integer seguindo = numero_random.nextInt(256);

        imagem_perfil = v.findViewById(R.id.imagem_perfil);
        imagem_perfil.setImageResource(R.drawable.pato);

        nome_usuario = v.findViewById(R.id.nomeUsuario);
        nome_usuario.setText("PatuRoco");

        tipo_usuario = v.findViewById(R.id.tipoUsuario);
        tipo_usuario.setText("Usuário comum");

        num_seguidores = v.findViewById(R.id.num_seguidores);
        num_seguidores.setText(seguidores.toString());

        num_seguindo = v.findViewById(R.id.num_seguindo);
        num_seguindo.setText(seguindo.toString());

        list = v.findViewById(R.id.list_fav);
    }
}