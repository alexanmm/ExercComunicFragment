package br.com.digitalhouse.exerccomunicfragment.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.exerccomunicfragment.R;
import br.com.digitalhouse.exerccomunicfragment.interfaces.Comunicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment{

    private Comunicator comunicator;
    private Button buttonGreen;
    private Button buttonRed;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        comunicator = (Comunicator) context;

    }

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1, container, false);

        buttonGreen = view.findViewById(R.id.buttonGreen);
        buttonRed = view.findViewById(R.id.buttonRed);

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.receberMensagem("VERDE");
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.receberMensagem("VERMELHO");
            }
        });

        return view;
    }

}
