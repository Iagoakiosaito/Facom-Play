package com.example.facomplay.fragments.Config;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.facomplay.R;

import java.util.Locale;

public class ConfigFragment extends Fragment{

    private View v;
    private Spinner spinnerModo, spinnerIdioma;
    private Button btnMode;
    private ImageView btn_facom;



    public ConfigFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_config, container, false);

        definirElementos(v);

        return v;
    }

    private void definirElementos(View v) {

        spinnerIdioma = v.findViewById(R.id.spinnerIdioma);
        ArrayAdapter<CharSequence> adapterIdioma = ArrayAdapter.createFromResource(requireContext(), R.array.idiomas, android.R.layout.simple_spinner_item);
        adapterIdioma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinnerIdioma.setAdapter(adapterIdioma);
        spinnerIdioma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                        selecionarIdioma("pt");
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                        break;
                    case 2:
                        selecionarIdioma("en");
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                        break;
                    case 3:
                        selecionarIdioma("es");
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SharedPreferences appSettingPrefs = getActivity().getSharedPreferences("App", 0);
        SharedPreferences.Editor sharedPrefsEdit = appSettingPrefs.edit();
        Boolean isNightModeOn = appSettingPrefs.getBoolean("NightMode", false);
        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        btnMode = v.findViewById(R.id.switch_btn);

        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNightModeOn) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPrefsEdit.putBoolean("NightMode", false);
                    sharedPrefsEdit.apply();

                    btnMode.setText("Enable Dark Mode");

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPrefsEdit.putBoolean("NightMode", true);
                    sharedPrefsEdit.apply();

                    btnMode.setText("Disable Dark Mode");
                }
            }
        });

        btn_facom = v.findViewById(R.id.imageView);
        btn_facom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(requireContext(), "Alunos: Iago Akio saito e Lucas Guimarães Volpe", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void selecionarIdioma(String idioma){
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

}