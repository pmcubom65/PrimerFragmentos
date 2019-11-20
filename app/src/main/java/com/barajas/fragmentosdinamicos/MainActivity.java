package com.barajas.fragmentosdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener,
FragmentUno.OnFragmentInteractionListener, FragmentDos.OnFragmentInteractionListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    FragmentContainer uno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button2);
        b2=(Button) findViewById(R.id.button3);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.mifragment,new BlankFragment());
        ft.commit();





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUno f=new FragmentUno();
                getSupportFragmentManager().beginTransaction().replace(R.id.mifragment, f).commit();
                Toast.makeText(MainActivity.this, "FRAGMENTO UNO", Toast.LENGTH_LONG).show();

            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDos fd=new FragmentDos();
                getSupportFragmentManager().beginTransaction().replace(R.id.mifragment, fd).commit();
                Toast.makeText(MainActivity.this, "FRAGMENTO DOS", Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(MainActivity.this, "Funciona?", Toast.LENGTH_LONG).show();
    }
}
