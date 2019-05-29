package br.com.digitalhouse.exerccomunicfragment.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalhouse.exerccomunicfragment.R;
import br.com.digitalhouse.exerccomunicfragment.interfaces.Comunicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private Comunicator comunicator;

    public Fragment2() {
        // Required empty public constructor
    }

    //Este metodo é chamado quando o fragmento é vinculado a uma activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            comunicator = (Comunicator) context;
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String nomeCor = "";
        View view = inflater.inflate(R.layout.fragment2, container, false);
        TextView text = view.findViewById(R.id.TextViewCor);


        try {

            if (getArguments() != null){
                nomeCor = getArguments().getString("COR");
                text.setText(nomeCor);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        //Altera a cor de fundo do fragment
        if(nomeCor.equals("VERMELHO")){
            text.setBackgroundColor(Color.parseColor("#E76A68")); // Tratamento de cor em Hexadecimal
        } else {
            text.setBackgroundColor(Color.parseColor("#8ECF66")); // Tratamento de cor em Hexadecimal
        }

        return view;
    }

}
