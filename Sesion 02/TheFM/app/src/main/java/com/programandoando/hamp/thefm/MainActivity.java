package com.programandoando.hamp.thefm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.programandoando.hamp.thefm.ui.HypedArtistsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Usuario no cambia la orientacion del dispositivo
        if(savedInstanceState==null) {
            //Conexion Fragmentos con la activity
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new HypedArtistsFragment())
                    //.add(R.id.main_container,new HypedArtistsFragment())
                    .commit();
        }

    }
}
