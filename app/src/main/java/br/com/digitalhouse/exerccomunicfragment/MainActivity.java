package br.com.digitalhouse.exerccomunicfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitalhouse.exerccomunicfragment.fragment.Fragment1;
import br.com.digitalhouse.exerccomunicfragment.fragment.Fragment2;
import br.com.digitalhouse.exerccomunicfragment.interfaces.Comunicator;

public class MainActivity extends AppCompatActivity implements Comunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Chama o primeiro Fragment
        replaceFragment(R.id.container1, new Fragment1());

        //Chama o segundo Fragment
        replaceFragment(R.id.container2, new Fragment2());

    }

    public void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    @Override
    public void receberMensagem(String nomeCor) {

        //Cria uma instancia do fragmento
        Fragment fragment2 = new Fragment2();

        //Preenche o bundle
        Bundle bundle = new Bundle();
        bundle.putString("COR", nomeCor);

        //set os argumentos
        fragment2.setArguments(bundle);

        //retorna o fragmento
        replaceFragment(R.id.container2, fragment2);

    }

}
