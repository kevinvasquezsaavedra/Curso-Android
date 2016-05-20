package com.example.usuario.tipsdesalud;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.usuario.tipsdesalud.modelo.ModeloArticulos;
import com.programandoando.hamp.tipsdesalud.Modelo.ModeloArticulos;
/**
 * Fragmento especializado para la lista de artículos
 */
public class FragmentoListaArticulos extends Fragment
        implements AdaptadorArticulos.OnItemClickListener {
    private EscuchaFragmento escucha;
    public FragmentoListaArticulos() {
    }
    public static FragmentoListaArticulos crear() {
        return new FragmentoListaArticulos();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Manejo de argumentos
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento_lista_articulos, container, false);
        View recyclerView = v.findViewById(R.id.reciclador);
        assert recyclerView != null;
        prepararLista((RecyclerView) recyclerView);
        return v;
    }
    private void prepararLista(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new AdaptadorArticulos(ModeloArticulos.ITEMS, this));
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EscuchaFragmento) {
            escucha = (EscuchaFragmento) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debes implementar EscuchaFragmento");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        escucha = null;
    }
    @Override
    public void onClick(AdaptadorArticulos.ViewHolder viewHolder, String idArticulo)
    {
    }
    public interface EscuchaFragmento {
        void alSeleccionarItem(String idArticulo);


    }

    public void cargarDetalle(String idArticulo) {
        if (escucha != null) {
            escucha.alSeleccionarItem(idArticulo);
        }
    }

}

